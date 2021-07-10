package com.scitalys.bp_traits

import com.scitalys.bp_traits.Mutation
import com.scitalys.bp_traits.Specimen
import com.scitalys.bp_traits.Trait

class PunnettSquare {

    fun calculate(maleTraits: Set<Trait>, femaleTraits: Set<Trait>): Pairing {

        /**
         * Calculate the table headers using generatePermutations()
         */
        val tableHeadersMale = mutableSetOf<List<Mutation?>>()
        val tableHeadersFemale = mutableSetOf<List<Mutation?>>()

        generatePermutations(maleTraits, tableHeadersMale, 0, mutableListOf())
        generatePermutations(femaleTraits, tableHeadersFemale, 0, mutableListOf())

        /**
         * Calculate the raw mutation per offspring with duplicates and no super or coallelic.
         */
        val rawMutationsLists = mutableListOf<List<Mutation?>>()

        tableHeadersMale.forEach { tableHeaderMale ->
            tableHeadersFemale.forEach { tableHeaderFemale ->
                rawMutationsLists.add(tableHeaderMale + tableHeaderFemale)
            }
        }

        val traitsSetList = rawMutationsLists.map {
            it.toTraitsSet()
        }.toMutableList()

        /**
         * Init a Pairing() instance and add every offspring to it.
         * The Pairing() class will remove duplicate, calculate the odds, find out if there
         * are supers or coallelics.
         */
        val pairing = Pairing(
            male = Specimen(
                maleTraits.toMutableMapOfTraits(),
                1
            ),
            female = Specimen(
                femaleTraits.toMutableMapOfTraits(),
                1
            ),
            _totalPossibilities = traitsSetList.size
        )

        for (traitsSet in traitsSetList) {
            pairing.add(traitsSet)
        }

        return pairing
    }

    /**
     * Recursive function used to generate permutations
     */
    private fun generatePermutations(
        lists: Set<Trait>,
        result: MutableSet<List<Mutation?>>,
        depth: Int,
        current: List<Mutation?>
    ) {

        if (depth == lists.size) {
            result.add(current)
            return
        }

        val gene1 = lists.elementAt(depth).geneLG1
        val gene2 = lists.elementAt(depth).geneLG2


        generatePermutations(lists, result, depth + 1, current + gene1)

        if (gene2 != null) {
            generatePermutations(lists, result, depth + 1, current + gene2)
        } else {
            generatePermutations(lists, result, depth + 1, current)
        }

    }
}

/**
 * Inline function to convert a list of Mutation to a set of Trait
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

fun Set<Trait>.toMutableMapOfTraits(): MutableMap<Trait, Float> {

    if (this.isNullOrEmpty()) {
        return mutableMapOf(Trait.NORMAL to 1f)
    }

    return mutableMapOf(*this.map { it to 1f }.toTypedArray())

}