package com.scitalys.bp_traits.models

import com.scitalys.bp_traits.Trait
import com.scitalys.bp_traits.utils.gcd

class Pairing(
    val id: Int? = null,
    val male: Speciment? = null,
    val female: Speciment? = null,
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
         * Counts how many times a het appears in the set and keeps track of how many times it
         * appears in the whole clutch, then removes it.
         * offspring val holds the new set without
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

        val traitAsForSpecimentSpecs = mutableMapOf(*setOfTraits.map { Pair(it, 1f) }.toTypedArray())
        val speciment = _offspringList.find { it.traits == traitAsForSpecimentSpecs }

        if (speciment != null) {
            speciment.incidence += 1
        } else {
            _offspringList.add(Speciment(traits = traitAsForSpecimentSpecs, incidence = 1))
        }
//        }

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
            val visual = Trait.fromValue(hetMutation, hetMutation)
            var totalPosHet = 0

            /**
             * Calculate the probability a non visual offspring is het for the selected gene.
             */
            _offspringList.forEach {
                if (!it.traits.contains(visual)) {
                    totalPosHet += it.incidence
                }
            }

            _offspringList.forEach{
                if (!it.traits.contains(visual)) {
                    it.traits[hetTrait] = count / totalPosHet
                }
            }

        }
    }
}