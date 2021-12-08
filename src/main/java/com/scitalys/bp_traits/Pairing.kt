package com.scitalys.bp_traits

import com.scitalys.bp_traits.Pairing.Companion.joinHets
import com.scitalys.bp_traits.utils.gcd
import java.util.*

/**
 * The Pairing() class is responsible of calling [PunnettSquare], calculating the odds,
 * removing duplicates and refactoring hets.
 */
data class Pairing(
    val male: Specimen,
    val female: Specimen,
    var offspringMap: SortedMap<Specimen, Int>
) {

    val totalPossibilities: Int = offspringMap.map { it.value }.sum()

    override fun equals(other: Any?): Boolean {
        if (other !is Pairing) {
            return false
        }

        val thisOffspringMapAsList = this.offspringMap.toList().sortedBy { it.first.mutationsCount }
        val otherOffspringMapAsList = other.offspringMap.toList().sortedBy { it.first.mutationsCount }

        // If the sizes are different there is no reason to keep going with further checks.
        if (thisOffspringMapAsList.size != otherOffspringMapAsList.size) return false

        thisOffspringMapAsList.forEachIndexed { index, (specimen, odds) ->
            val (otherSpecimen, otherOdds) = otherOffspringMapAsList[index]
            if (otherSpecimen != specimen || otherOdds != odds) {
                return false
            }
        }
        if (
            totalPossibilities == other.totalPossibilities &&
            male == other.male &&
            female == other.female
        ) return true
        return false
    }

    override fun hashCode(): Int {
        var result = male.hashCode()
        result = 31 * result + female.hashCode()
        result = 31 * result + offspringMap.hashCode()
        return result
    }

    /**
     * The companion object contains the [fromParents] function which allows to create
     * a pairing object only knowing the parents.
     */
    companion object {

        fun fromParents(parent1: Specimen, parent2: Specimen): Pairing {
            val rawResult =
                PunnettSquare.calculate(parent1.loci.keys, parent2.loci.keys)
            val offspringMap = refine(rawResult.map { it.toLociPairSet() })

            return Pairing(parent1, parent2, offspringMap)
        }


        /**
         * Calls [separateHets], [joinHets] and [simplifyOdds]
         */
        private fun refine(rawResult: List<Set<LociPair>>): SortedMap<Specimen, Int> {


            var (offspringMap, hets) = rawResult.separateHets()
            offspringMap = offspringMap.joinHets(hets = hets)
            offspringMap = offspringMap.simplifyOdds()

            return offspringMap.toSortedMap(
                compareByDescending<Specimen>
                    { it.mutationsCount }.thenBy { it.formattedString }
            )

        }

        /**
         * This function does the following for every offspring in rawResult:
         * - Search and removes hets.
         * - Insert the het into hets or increment its count if it is already present.
         * - Insert offspring without hets into offspringMap or increment its count if
         *   it is already present.
         */
        private fun List<Set<LociPair>>.separateHets():
                Pair<MutableMap<Specimen, Int>, MutableMap<LociPair, Float>> {
            val offspringMap = mutableMapOf<Specimen, Int>()
            val hets = mutableMapOf<LociPair, Float>()
            this.forEach { rawResult ->

                val mutableRawResult = rawResult.toMutableSet()

                // Every trait in rawResult which is a heterozygous recessive
                // gets removed from mutableRawResult and added to hets mapping it
                // to how many times it appears in the whole offsprings list.
                rawResult.forEach { lociPair ->
                    if (lociPair.isHetRecessive()) {
                        if (hets[lociPair] != null) {
                            hets[lociPair] = hets[lociPair]!! + 1f
                        } else {
                            hets[lociPair] = 1f
                        }
                        mutableRawResult -= lociPair
                    }
                }

                // The new traits set without hets gets now transformed into a map
                // with every mutation being at 100% since they are all visual mutations
                // at this point.
                val loci = mutableRawResult.associateWith { 1f }.toMutableMap()

                // Create a specimen with the new trait set.
                val specimen = Specimen(loci = loci)

                // If specimen is null it means there was not an identical specimen already
                // in the list so we create it and assign it an incidence of 1. Otherwise
                // we just increment by one the incidence of the already present identical
                // specimen in the map.
                if (offspringMap.keys.find { it == specimen } != null) {
                    val incidence = offspringMap[specimen]?.plus(1) ?: 1
                    offspringMap[specimen] = incidence
                } else {
                    offspringMap[Specimen(loci)] = 1
                }
            }
            return offspringMap to hets
        }

        /**
         * Add back every het to the offspringMap with a probability equals to how many times
         * the het appeared in the List<Set<Trait>> given back by [PunnettSquare.calculate]
         * divided the number of every specimen which COULD be het for it.
         */
        private fun MutableMap<Specimen, Int>.joinHets(
            hets: MutableMap<LociPair, Float>,
        ): MutableMap<Specimen, Int> {
            // This is needed to create a second map. Using val tmpMutableMap = this won't work
            // because of a ConcurrentModification exception which will happen on the second forEach.
            val tmpMutableMap = mutableMapOf<Specimen, Int>()
            tmpMutableMap.putAll(this)

            hets.forEach { (lociPair, count) ->

                // Extract the mutation from the trait.
                val hetMutation = lociPair.locus2

                // This variable holds the number of offspring which CAN have an heterozygosis
                // for the mutation referred by hetMutation
                var totalPosHet = 0
                // For every specimen in offspringMap check if it can have an
                // heterozygosis of the specified mutation. If it can totalPosHet
                // gets incremented by the incidence of that specimen.
                forEach { (specimen, incidence) ->
                    if (specimen.canBeHetFor(hetMutation)) {
                        totalPosHet += incidence
                    }
                }

                // Adds the het with the correct probability
                // to ALL specimens (since you cannot visually tell)
                val localTmpMutableMap = mutableMapOf<Specimen, Int>()
                tmpMutableMap.forEach { (specimen, odds) ->
                    if (specimen.canBeHetFor(hetMutation)) {
                        localTmpMutableMap[Specimen(specimen.loci + (lociPair to count / totalPosHet))] = odds
                    } else {
                        localTmpMutableMap[specimen] = odds
                    }
                }
                tmpMutableMap.clear()
                tmpMutableMap.putAll(localTmpMutableMap)

            }
            return tmpMutableMap
        }

        /**
         * Calculate greatest common divisor and simplify every odd.
         */
        private fun MutableMap<Specimen, Int>.simplifyOdds(): MutableMap<Specimen, Int> {
            val tmpMutableMap = this

            val gcd = values.toList().gcd

            // A temporary map is created to avoid concurrentModifications
            val tmpOffspringMap: MutableMap<Specimen, Int> = mutableMapOf()
            forEach { (key, incidence) ->
                tmpOffspringMap[key] = incidence / gcd
            }

            // Clear the old list and put the new pairings in.
            tmpMutableMap.putAll(tmpOffspringMap)
            return tmpMutableMap
        }

    }
}

/**
 * Inline function to convert a list of Mutation to a set of Trait
 *
 * This function removes instances of double mutation and, if they are codominant (they
 * have a super form), converts them into the respective super form.
 */
fun List<Mutation?>.toTraitsSet(): Set<Trait> {

    val mutableMutationsList = this.filterNotNull().toMutableList()

    val results = mutableSetOf<Trait>()

    if (mutableMutationsList.isEmpty()) {
        return setOf()
    }

    for (trait in Trait.values()) {
        if (mutableMutationsList.contains(trait.geneLG1) &&
            (mutableMutationsList - trait.geneLG1).contains(trait.geneLG2) &&
            trait.geneLG1 != null &&
            trait.geneLG2 != null
        ) {
            results.add(trait)
            mutableMutationsList.remove(trait.geneLG1)
            mutableMutationsList.remove(trait.geneLG2)
        }
        if (mutableMutationsList.size == 0) {
            break
        }
    }

    for (mutation in mutableMutationsList) {
        Trait.fromValue(mutation, null)?.let { results.add(it) }
    }

    for (mutation in mutableMutationsList) {
        Trait.fromValue(null, mutation)?.let { results.add(it) }
    }

    return results

}

fun List<Mutation?>.toLociPairSet(): Set<LociPair> {

    val mutableMutationsList = this.filterNotNull().toMutableList()

    val results = mutableSetOf<LociPair>()

    if (mutableMutationsList.isEmpty()) {
        return setOf()
    }

    for (morph in Morph.values().filter { it.mutations.size == 1 }) {
        val loci = morph.mutations.first()
        if (mutableMutationsList.contains(loci.locus1) &&
            (mutableMutationsList - loci.locus1).contains(loci.locus2) &&
            loci.locus1 != null &&
            loci.locus2 != null
        ) {
            results.add(loci)
            mutableMutationsList.remove(loci.locus1)
            mutableMutationsList.remove(loci.locus2)
        }
        if (mutableMutationsList.size == 0) {
            break
        }
    }

    for (mutation in mutableMutationsList) {
        Morph.fromValue(LociPair(mutation, null))?.let { results.add(it.mutations.first()) }
    }

    for (mutation in mutableMutationsList) {
        Morph.fromValue(LociPair(null, mutation))?.let { results.add(it.mutations.first()) }
    }

    return results

}