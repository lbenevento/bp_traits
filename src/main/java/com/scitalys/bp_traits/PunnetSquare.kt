package com.scitalys.bp_traits

object PunnettSquare {

    fun calculate(parent1: List<Trait>, parent2: List<Trait>): List<List<Mutation?>> {

        /**
         * Calculate the table headers using generatePermutations()
         */
        val tableHeadersMale = mutableSetOf<List<Mutation?>>()
        val tableHeadersFemale = mutableSetOf<List<Mutation?>>()

        generatePermutations(parent1, tableHeadersMale, 0, mutableListOf())
        generatePermutations(parent2, tableHeadersFemale, 0, mutableListOf())

        /**
         * Calculate the raw mutation per offspring with duplicates and no super or coallelic.
         */
        val rawMutationsLists = mutableListOf<List<Mutation?>>()

        tableHeadersMale.forEach { tableHeaderMale ->
            tableHeadersFemale.forEach { tableHeaderFemale ->
                rawMutationsLists.add(tableHeaderMale + tableHeaderFemale)
            }
        }

        return rawMutationsLists
    }

    /**
     * Recursive function used to generate permutations
     */
    private fun generatePermutations(
        lists: List<Trait>,
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

fun Set<Trait>.toMutableMapOfTraits(): MutableMap<Trait, Float> {

    if (this.isNullOrEmpty()) {
        return mutableMapOf(Trait.NORMAL to 1f)
    }

    return mutableMapOf(*this.map { it to 1f }.toTypedArray())

}