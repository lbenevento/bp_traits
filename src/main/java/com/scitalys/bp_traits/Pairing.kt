package com.scitalys.bp_traits

import com.scitalys.bp_traits.utils.gcd
import java.util.*

/**
 * The Pairing() class is responsible of calling [PunnettSquare], calculating the odds,
 * removing duplicates and refactoring hets.
 */

data class Pairing(
    val male: Specimen,
    val female: Specimen,
    var offspringMap: Map<Specimen, Int>? = null
) {

    private val hets: MutableMap<Trait, Float> = mutableMapOf()

    private val _offspringMap: MutableMap<Specimen, Int> = offspringMap?.toMutableMap() ?: mutableMapOf()

    val totalPossibilities: Int

    init {

        // _offspringList being empty means Pairing should calculate the offspring list itself
        // because it was not provided.
        if (_offspringMap.isEmpty()) {
            val rawResult =
                PunnettSquare.calculate(male.traits.keys.toList(), female.traits.keys.toList())
            refine(rawResult.map { it.toTraitsSet() })
        }
        totalPossibilities = _offspringMap.map { it.value }.sum()

    }

    /**
     * Calls [handleHets] and then if it has reached the
     * end of the list calls [insertHets] and [simplifyOdds]
     */
    private fun refine(rawResult: List<Set<Trait>>) {

        rawResult.forEachIndexed { index, traitSet ->

            handleHets(traitSet)

            // If it is the last offspring added to the clutch calls [insertHets] and
            // simplify the odds.
            if (index == rawResult.size - 1) {
                insertHets()
                simplifyOdds()
            }
        }
    }

    /**
     * Counts how many times a het appears in the set and keeps track of
     * how many times it appears in the whole clutch, then removes it.
     * offspring val holds the new set without hets
     */
    private fun handleHets(rawTraitList: Set<Trait>) {

        val setOfTraits = rawTraitList.toMutableSet()

        for (trait in rawTraitList) {
            if (trait.geneLG1 == null && trait.geneLG2 != null) {
                if (hets[trait] != null) {
                    hets[trait] = hets[trait]!! + 1f
                } else {
                    hets[trait] = 1f
                }
                setOfTraits -= trait
            }
        }

        val traitAsForSpecimentSpecs =
            mutableMapOf(*setOfTraits.map { Pair(it, 1f) }.toTypedArray())
        val speciment = _offspringMap.keys.find { it.traits == traitAsForSpecimentSpecs }

        if (speciment != null) {
            val incidence = _offspringMap[speciment]?.plus(1) ?: 1
            _offspringMap[speciment] = incidence
        } else {
            _offspringMap[Specimen(traitAsForSpecimentSpecs)] = 1
        }
    }

    /**
     * For each hets calculates the total number of offspring that could be hets and add that
     * in form of percentage (since you can't see hets visually) into all the non visual offsprings.
     */
    private fun insertHets() {

        hets.forEach { (trait, count) ->

            val hetMutation = trait.geneLG2
            //val hetTrait: Trait = Trait.fromValue(null, hetMutation)!!

            var totalPosHet = 0
            _offspringMap.forEach { (specimen, incidence) ->

                // If the specimen can't be het for the specified mutation it means that
                // it is a visual or has another mutation coallelic to the het.
                if (specimen.canBeHetFor(hetMutation)) {
                    totalPosHet += incidence
                }
            }

            _offspringMap.forEach { (specimen, _) ->
                if (specimen.canBeHetFor(hetMutation)) {
                    specimen.traits[trait] = count / totalPosHet
                }
            }
        }
    }

    /**
     * Calculate greatest common divisor and simplify every odd.
     */
    private fun simplifyOdds() {
        val gcd = _offspringMap.values.toList().gcd
        val tmpOffspringMap: MutableMap<Specimen, Int> = mutableMapOf()
        _offspringMap.forEach { (key, incidence) ->
            tmpOffspringMap[key] = incidence / gcd
        }
        _offspringMap.clear()
        _offspringMap.putAll(tmpOffspringMap)

        for (offspring in _offspringMap.keys) {
            if (offspring.traits.isEmpty()) {
                offspring.traits[Trait.NORMAL] = 1f
            }
        }

        offspringMap = _offspringMap

    }

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