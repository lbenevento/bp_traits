package com.scitalys.bp_traits

import java.io.Serializable

/**
 * Represents a generic pair of mutations onthe same genetic loci.
 *
 * Loci exhibits value semantics, i.e. two loci are equal if both components and their order are equal.
 *
 * @property l1 Locus value on one of the alleles.
 * @property l2 Locus value on the other allele.
 * @constructor Creates a new instance of Loci.
 */
data class LociPair(
    private val l1: Mutation? = null,
    private val l2: Mutation? = null
): Serializable {

    val locus1: Mutation?
    val locus2: Mutation?

    // This is supposed to sort each locus mutation according to it's name everytime
    init {
        if (l1 == l2 || l1 == null || l2 == null) {
            locus1 = l1
            locus2 = l2
        } else if (l1.name >= l2.name) {
            locus1 = l1
            locus2 = l2
        } else {
            locus1 = l2
            locus2 = l1
        }
    }
    /**
     * Returns string representation of the [LociPair] including its [locus1] and [locus2] values.
     */
    override fun toString(): String = "($locus1, $locus2)"

    override fun equals(other: Any?): Boolean {
        if (other !is LociPair) {
            return false
        }
        if (this.locus1 == other.locus1 && this.locus2 == other.locus2) {
            return true
        }
        return false
    }

    /**
     * This implementation differs from a standard hashCode() implementation slightly.
     * It indeed doesn't care about the order of the two variables. So two Loci with inverted
     * locus1 and locus2 will have the same hashCode. This is needed since some comparisons use
     * the hashCode in order to establish equality.
     */
    override fun hashCode(): Int {
        var result = locus1?.hashCode() ?: 0
        result = 31 * (result + (locus2?.hashCode() ?: 0))
        return result
    }
}

/**
 * Creates a Loci in the same way you can create a pair (a.to(b)).
 */
infix fun <A: Mutation?, B: Mutation?> A.to(that: B) = LociPair(l1 = this, l2 = that)

fun LociPair.isHetRecessive() : Boolean {
    if (locus1 == null && locus2 != null) {
        return true
    }
    return false
}
//
//fun LociPair.isHomoRecessive() : Boolean {
//    if (this.locus1 != null && this.locus2 != null && this.geneType == GeneType.RECESSIVE) {
//        return true
//    }
//    return false
//}
//
//fun Trait.isHomoCodominant() : Boolean {
//    if (this.geneLG1 != null && this.geneLG2 != null && this.geneType == GeneType.COALLELIC) {
//        return true
//    }
//    return false
//}
//
//fun Trait.isHetCodominant() : Boolean {
//    if (this.geneLG1 != null && this.geneLG2 == null) {
//        return true
//    }
//    return false
//}