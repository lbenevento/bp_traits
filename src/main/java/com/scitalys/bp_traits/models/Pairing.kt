package com.scitalys.bp_traits.models

import com.scitalys.bp_traits.Mutation
import com.scitalys.bp_traits.Trait
import com.scitalys.bp_traits.utils.gcd

class Pairing(
    val id: Int? = null,
    val male: Speciment,
    val female: Speciment,
    private var _offspringList: MutableList<Speciment> = mutableListOf(),
    private val _totalPossibilities: Int = 0,
) {

    private val hets = mutableMapOf<Trait, Float>()

    val offspringList: List<Speciment>
        get() {
            return _offspringList.sortedByDescending { it.getGeneCount() }
        }

    val totalPossibilities: Int
        get() {
            var total = 0
            _offspringList.forEach {
                total += it.incidence
            }
            return total
        }

    fun add(_offspring: Set<Trait>) {

        val setOfTraits = _offspring.toMutableSet()
        /**
         * Counts how many times a het appears in the set and keeps track of
         * how many times it appears in the whole clutch, then removes it.
         * offspring val holds the new set without hets
         */
        for (trait in _offspring) {
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
        val speciment = _offspringList.find { it.traits == traitAsForSpecimentSpecs }

        if (speciment != null) {
            speciment.incidence += 1
        } else {
            _offspringList.add(Speciment(traits = traitAsForSpecimentSpecs, incidence = 1))
        }

        /**
         * If it is the last offspring added to the clutch calls [insertHets] and
         * simplify the odds.
         */
        if (_offspringList.map { it.incidence }.sum() == _totalPossibilities) {

            insertHets()

            /**
             * Calculate greatest common divisor and simplify every odd.
             */
            val gcd = _offspringList.map { it.incidence }.gcd
            _offspringList.forEach {
                it.incidence /= gcd
            }

            for (offspring in _offspringList) {
                if (offspring.traits.isEmpty()) {
                    offspring.traits[Trait.NORMAL] = 1f
                }
            }
        }
    }

    private fun insertHets() {

        /**
         * For each hets calculates the total number of offspring that could be hets and add that
         * in form of percentage (since you can't see hets visually) into all the non visual offsprings.
         */

        hets.forEach { (trait, count) ->

            val hetMutation = trait.geneLG2
            val hetTrait: Trait = Trait.fromValue(null, hetMutation)!!

            var totalPosHet = 0
            _offspringList.forEach {
                /**
                 * If the speciment can't be het for the specified mutation it means that
                 * it is a visual or has another mutation coallelic to the het.
                 */
                if (it.canBeHetFor(hetMutation)) {
                    totalPosHet += it.incidence
                }
            }

            _offspringList.forEach {
                if (it.canBeHetFor(hetMutation)) {
                    it.traits[hetTrait] = count / totalPosHet
                }
            }
        }


    }
}

/**
 * Function to know if a speciment can be het for a specified mutation.
 */
private fun Speciment.canBeHetFor(mutation: Mutation?): Boolean {
    this.traits.forEach { (trait, incidence) ->
        if (trait.geneLG1 != null && trait.geneLG2 != null){
            if (
                Trait.fromValue(trait.geneLG1, mutation) != null || Trait.fromValue(trait.geneLG2, mutation) != null
            ) {
                if (incidence == 1f) {
                    return false
                }
            }
        }
    }
    return true
}