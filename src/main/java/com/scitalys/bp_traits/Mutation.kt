package com.scitalys.bp_traits

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