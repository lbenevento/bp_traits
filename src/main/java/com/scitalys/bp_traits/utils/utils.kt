package com.scitalys.bp_traits.utils

import com.scitalys.bp_traits.Mutation
import com.scitalys.bp_traits.Trait


/**
 * Utility that returns a list TODO
 */
fun Trait.getIncompatibilitiesFor(traitList: List<Trait>): Trait? {
    /**
     * If LG1 or LG2 of the trait already in the editText has the
     * same mutation as the newly added trait they can't go together.
     * We need a null check to avoid comparing the empty LG1/LG2 of some traits.
     */
    for (trait in traitList) {
        this.geneLG1?.let {
            if (it == trait.geneLG1 || it == trait.geneLG2) return trait
        }
        this.geneLG2?.let {
            if (it == trait.geneLG1 || it == trait.geneLG2) return trait
        }
    }

    /**
     * Check if any complex contains both LG1 or LG2 from the trait in the editText and
     * LG1 or LG2 from the newly added trait.
     */
    for (complex in Mutation.complexes) {
        val mutationsFromSameComplex = mutableListOf<Mutation>()
        for (trait in traitList) {
            if (complex.contains(trait.geneLG1)) mutationsFromSameComplex.add(trait.geneLG1!!)
            if (complex.contains(trait.geneLG2)) mutationsFromSameComplex.add(trait.geneLG2!!)
        }
        if (complex.contains(this.geneLG1)) mutationsFromSameComplex.add(this.geneLG1!!)
        if (complex.contains(this.geneLG2)) mutationsFromSameComplex.add(this.geneLG2!!)

        if (mutationsFromSameComplex.size > 2) {
            return Trait.GRAVEL
        }
    }

    return null
}