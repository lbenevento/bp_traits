package com.scitalys.bp_traits

import com.scitalys.bp_traits.utils.gcd

/**
 * The Pairing() class is responsible of calling [PunnettSquare], calculating the odds,
 * removing duplicates and refactoring hets.
 */
data class Pairing(
    val male: Specimen,
    val female: Specimen,
    var offspringMap: Map<Specimen, Int>
) {

    val totalPossibilities: Int = offspringMap.map { it.value }.sum()

    override fun equals(other: Any?): Boolean {
        if (other !is Pairing) {
            return false
        }
        if (
            totalPossibilities == other.totalPossibilities &&
            male == other.male &&
            female == other.female &&
            offspringMap == other.offspringMap
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
                PunnettSquare.calculate(parent1.traits.keys.toList(), parent2.traits.keys.toList())
            val offspringMap = refine(rawResult.map { it.toTraitsSet() })

            return Pairing(parent1, parent2, offspringMap)
        }


        /**
         * Calls [separateHets] and then if it has reached the
         * end of the list calls [insertHets] and [simplifyOdds]
         */
        private fun refine(rawResult: List<Set<Trait>>): Map<Specimen, Int> {


            val hets: MutableMap<Trait, Float> = mutableMapOf()
            val offspringMap: MutableMap<Specimen, Int> = mutableMapOf()

            separateHets(
                rawResults = rawResult,
                hets = hets,
                offspringMap = offspringMap
            )

            insertHets(
                hets = hets,
                offspringMap = offspringMap
            )
            simplifyOdds(
                offspringMap
            )

            return offspringMap

        }

        /**
         * This function does the following for every offspring in rawResult:
         * - Search and removes hets.
         * - Insert the het into hets or increment its count if it is already present.
         * - Insert offspring without hets into offspringMap or increment its count if
         *   it is already present.
         */
        private fun separateHets(
            rawResults: List<Set<Trait>>,
            hets: MutableMap<Trait, Float>,
            offspringMap: MutableMap<Specimen, Int>
        ) {
            rawResults.forEach { rawResult ->

                val mutableRawResult = rawResult.toMutableSet()

                // Every trait in rawResult which is a heterozygous recessive
                // gets removed from mutableRawResult and added to hets mapping it
                // to how many times it appears in the whole offsprings list.
                rawResult.forEach { trait ->
                    if (trait.isHetRecessive()) {
                        if (hets[trait] != null) {
                            hets[trait] = hets[trait]!! + 1f
                        } else {
                            hets[trait] = 1f
                        }
                        mutableRawResult -= trait
                    }
                }

                // The new traits set without hets gets now transformed into a map
                // with every mutation being at 100% since they are all visual mutations
                // at this point.
                val traitsMap = mutableMapOf(
                    *mutableRawResult.map { Pair(it, 1f) }.toTypedArray()
                )

                // Search the offspringMap for a specimen with the newly created traitsMap
                val specimen = offspringMap.keys.find { it.traits == traitsMap }

                // If specimen is null it means there was not an identical specimen already
                // in the list so we create it and assign it an incidence of 1. Otherwise
                // we just increment by one the incidence of the already present identical
                // specimen in the map.
                if (specimen != null) {
                    val incidence = offspringMap[specimen]?.plus(1) ?: 1
                    offspringMap[specimen] = incidence
                } else {
                    offspringMap[Specimen(traitsMap)] = 1
                }

            }
        }

        /**
         * Add back every het to the offspringMap with a probability equals to how many times
         * the het appeared in the List<Set<Trait>> given back by [PunnettSquare.calculate]
         * divided the number of every specimen which COULD be het for it.
         */
        private fun insertHets(
            hets: MutableMap<Trait, Float>,
            offspringMap: MutableMap<Specimen, Int>
        ) {

            hets.forEach { (trait, count) ->

                // Extract the mutation from the trait.
                val hetMutation = trait.geneLG2

                // This variable holds the number of offspring which CAN have an heterozygosis
                // for the mutation referred by hetMutation
                var totalPosHet = 0
                // For every specimen in offspringMap check if it can have an
                // heterozygosis of the specified mutation. If it can totalPosHet
                // gets incremented by the incidence of that specimen.
                offspringMap.forEach { (specimen, incidence) ->
                    if (specimen.canBeHetFor(hetMutation)) {
                        totalPosHet += incidence
                    }
                }

                // Adds the het with the correct probability
                // to ALL specimens (since you cannot visually tell)
                offspringMap.forEach { (specimen, _) ->
                    if (specimen.canBeHetFor(hetMutation)) {
                        specimen.traits[trait] = count / totalPosHet
                    }
                }

            }
        }

        /**
         * Calculate greatest common divisor and simplify every odd.
         */
        private fun simplifyOdds(
            offspringMap: MutableMap<Specimen, Int>
        ) {
            val gcd = offspringMap.values.toList().gcd
            // A temporary map is created to avoid concurrentModifications
            val tmpOffspringMap: MutableMap<Specimen, Int> = mutableMapOf()
            offspringMap.forEach { (key, incidence) ->
                tmpOffspringMap[key] = incidence / gcd
            }
            // Clear the old list and put the new pairings in.
            offspringMap.clear()
            offspringMap.putAll(tmpOffspringMap)

            for (offspring in offspringMap.keys) {
                if (offspring.traits.isEmpty()) {
                    offspring.traits[Trait.NORMAL] = 1f
                }
            }
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