package com.scitalys.bp_traits

import java.io.Serializable

enum class Mutation {
    /**
     * Codominant
     */
    ASPHALT,
    ARROYO,
    BAMBOO,
    BANANA,
    BLACK_HEAD,
    BLACK_PASTEL,
    BLADE,
    BONGO,
    BUTTER,
    CHAMPAGNE,
    CHOCOLATE,
    CINNAMON,
    CORAL_GLOW,
    CYPRESS,
    DISCO,
    ENCHI,
    FIRE,
    FLAME,
    FLARE,
    GHI,
    GRANITE,
    GRAVEL,
    HIDDEN_GENE_WOMA,
    LEMONBACK,
    LEOPARD,
    LESSER,
    MAHOGANY,
    MOCHA,
    MOJAVE,
    MYSTIC,
    ORANGE_BELLY,
    ORANGE_DREAM,
    PASTEL,
    PHANTOM,
    RUSSO,
    SAUCE,
    SPARK,
    SPECIAL,
    SPECTER,
    SPIDER,
    SPOTNOSE,
    SULFUR,
    VANILLA,
    YELLOW_BELLY,

    /**
     * Dominant
     */
    ACID,
    BINGO,
    BLAZE,
    BRITE,
    CALICO,
    CONFUSION,
    PINSTRIPE,
    WOMA,

    /**
     * Recessives
     */
    HET_ALBINO,
    HET_AXANTHIC_JOLLIFF,
    HET_AXANTHIC_TSK,
    HET_AXANTHIC_VPI,
    HET_CANDY,
    HET_CLOWN,
    HET_CRYPTIC,
    HET_DADDY,
    HET_DESERT_GHOST,
    HET_GENETIC_STRIPE,
    HET_GHOST,
    HET_MONSOON,
    HET_ORANGE_GHOST,
    HET_PIED,
    HET_SUNSET,
    HET_TOFFEE,
    HET_ULTRAMEL,

    ;

    companion object {
        private val albinoComplex = setOf(
            HET_ALBINO,
            HET_CANDY,
            HET_TOFFEE
        )
        private val blackELComplex = setOf(
            FIRE,
            BRITE,
            DISCO,
            FLAME,
            LEMONBACK,
            SAUCE,
            SULFUR,
            VANILLA
        )
        private val blueELComplex = setOf(
            BAMBOO,
            HET_DADDY,
            LESSER,
            BUTTER,
            MOCHA,
            MOJAVE,
            PHANTOM,
            MYSTIC,
            RUSSO,
            SPECIAL
        )
        private val clownComplex = setOf(
            HET_CLOWN,
            HET_CRYPTIC
        )
        private val spiderComplex = setOf(
            BLACK_HEAD,
            SPIDER,
            CHAMPAGNE,
            HIDDEN_GENE_WOMA
        )
        private val spotnoseComplex = setOf(
            SPOTNOSE,
            CHOCOLATE
        )
        private val superStripeComplex = setOf(
            ASPHALT,
            FLARE,
            GRAVEL,
            ORANGE_BELLY,
            SPARK,
            SPECTER,
            YELLOW_BELLY
        )

        val complexes = setOf(
            albinoComplex,
            blackELComplex,
            blueELComplex,
            clownComplex,
            spiderComplex,
            spotnoseComplex,
            superStripeComplex,
        )
    }
}

/**
 * Represents a generic pair of mutations onthe same genetic loci.
 *
 * Loci exhibits value semantics, i.e. two loci are equal if both components and their order are equal.
 *
 * @property locus1 Locus value on one of the alleles.
 * @property locus2 Locus value on the other allele.
 * @constructor Creates a new instance of Loci.
 */
data class LociPair(
    val locus1: Mutation? = null,
    val locus2: Mutation? = null
): Serializable {
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
        if (this.locus1 == other.locus2 && this.locus2 == other.locus1) {
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
infix fun <A: Mutation?, B: Mutation?> A.to(that: B) = LociPair(locus1 = this, locus2 = that)

fun LociPair.isHetRecessive() : Boolean {
    if (this.locus1 == null && this.locus2 != null) {
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