package com.scitalys.bp_traits

enum class Trait(
    val geneLG1: Mutation? = null,
    val geneLG2: Mutation? = null,
    val geneType: GeneType? = GeneType.CODOMINANT,
    val firstAppearance: Int? = null,
    val description: Description? = null,
    val formattedString: String,
) {
    /**
     * Supers and coallelics.
     */
    FREEWAY(
        geneLG1 = Mutation.YELLOW_BELLY,
        geneLG2 = Mutation.ASPHALT,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2009,
        formattedString = "Freeway"
    ),
    HIGHWAY(
        geneLG1 = Mutation.YELLOW_BELLY,
        geneLG2 = Mutation.GRAVEL,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Highway"
    ),
    IVORY(
        geneLG1 = Mutation.YELLOW_BELLY,
        geneLG2 = Mutation.YELLOW_BELLY,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2003,
        formattedString = "Ivory"
    ),
    RIO(
        geneLG1 = Mutation.ARROYO,
        geneLG2 = Mutation.ARROYO,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2010,
        formattedString = "Rio"
    ),
    SOLAR_FLARE(
        geneLG1 = Mutation.FLARE,
        geneLG2 = Mutation.FLARE,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2010,
        formattedString = "Solar Flare"
    ),
    SUPER_ASPHALT(
        geneLG1 = Mutation.ASPHALT,
        geneLG2 = Mutation.ASPHALT,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Asphalt"
    ),
    SUPER_BAMBOO(
        geneLG1 = Mutation.BAMBOO,
        geneLG2 = Mutation.BAMBOO,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Bamboo"
    ),
    SUPER_BANANA(
        geneLG1 = Mutation.BANANA,
        geneLG2 = Mutation.BANANA,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Banana"
    ),
    SUPER_BLACK_HEAD(
        geneLG1 = Mutation.BLACK_HEAD,
        geneLG2 = Mutation.BLACK_HEAD,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2008,
        formattedString = "Super Black Head"
    ),
    SUPER_BLACK_PASTEL(
        geneLG1 = Mutation.BLACK_PASTEL,
        geneLG2 = Mutation.BLACK_PASTEL,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Black Pastel"
    ),
    SUPER_BLADE(
        geneLG1 = Mutation.BLADE,
        geneLG2 = Mutation.BLADE,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Blade"
    ),
    SUPER_BONGO(
        geneLG1 = Mutation.BONGO,
        geneLG2 = Mutation.BONGO,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2013,
        formattedString = "Super Bongo"
    ),
    SUPER_BUTTER(
        geneLG1 = Mutation.BUTTER,
        geneLG2 = Mutation.BUTTER,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "BEL (Super Butter)"
    ),
    SUPER_CHOCOLATE(
        geneLG1 = Mutation.CHOCOLATE,
        geneLG2 = Mutation.CHOCOLATE,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Chocolate"
    ),
    SUPER_CINNAMON(
        geneLG1 = Mutation.CINNAMON,
        geneLG2 = Mutation.CINNAMON,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2002,
        formattedString = "Super Cinnamon"
    ),
    SUPER_CORAL_GLOW(
        geneLG1 = Mutation.CORAL_GLOW,
        geneLG2 = Mutation.CORAL_GLOW,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2012,
        formattedString = "Super Coral Glow"
    ),
    SUPER_DISCO(
        geneLG1 = Mutation.DISCO,
        geneLG2 = Mutation.DISCO,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2009,
        formattedString = "Super Disco"
    ),
    SUPER_ENCHI(
        geneLG1 = Mutation.ENCHI,
        geneLG2 = Mutation.ENCHI,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2003,
        formattedString = "Super Enchi"
    ),
    SUPER_FIRE(
        geneLG1 = Mutation.FIRE,
        geneLG2 = Mutation.FIRE,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2002,
        formattedString = "BEL (Super Fire)"
    ),
    SUPER_FLAME(
        geneLG1 = Mutation.FLAME,
        geneLG2 = Mutation.FLAME,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "BEL (Super Flame)"
    ),
    SUPER_GHI(
        geneLG1 = Mutation.GHI,
        geneLG2 = Mutation.GHI,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2010,
        formattedString = "Super GHI"
    ),
    SUPER_GRANITE(
        geneLG1 = Mutation.GRANITE,
        geneLG2 = Mutation.GRANITE,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Granite"
    ),
    SUPER_LEMONBACK(
        geneLG1 = Mutation.LEMONBACK,
        geneLG2 = Mutation.LEMONBACK,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super LemonBack"
    ),
    SUPER_LESSER(
        geneLG1 = Mutation.LESSER,
        geneLG2 = Mutation.LESSER,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2004,
        formattedString = "BEL (Super Lesser)"
    ),
    SUPER_MAHOGANY(
        geneLG1 = Mutation.MAHOGANY,
        geneLG2 = Mutation.MAHOGANY,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Suma"
    ),
    SUPER_MOJAVE(
        geneLG1 = Mutation.MOJAVE,
        geneLG2 = Mutation.MOJAVE,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2003,
        formattedString = "BEL (Super Mojave)"
    ),
    SUPER_MOCHA(
        geneLG1 = Mutation.MOCHA,
        geneLG2 = Mutation.MOCHA,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Mocha"
    ),
    SUPER_MYSTIC(
        geneLG1 = Mutation.MYSTIC,
        geneLG2 = Mutation.MYSTIC,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2009,
        formattedString = "Super Mystic"
    ),
    SUPER_ORANGE_BELLY(
        geneLG1 = Mutation.ORANGE_BELLY,
        geneLG2 = Mutation.ORANGE_BELLY,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Graphite Ivory"
    ),
    SUPER_ORANGE_DREAM(
        geneLG1 = Mutation.ORANGE_DREAM,
        geneLG2 = Mutation.ORANGE_DREAM,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2011,
        formattedString = "Super OD"
    ),
    SUPER_PASTEL(
        geneLG1 = Mutation.PASTEL,
        geneLG2 = Mutation.PASTEL,
        geneType = GeneType.COALLELIC,
        firstAppearance = 1999,
        formattedString = "Super Pastel"
    ),
    SUPER_PHANTOM(
        geneLG1 = Mutation.PHANTOM,
        geneLG2 = Mutation.PHANTOM,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2005,
        formattedString = "Super Phantom"
    ),
    SUPER_RUSSO(
        geneLG1 = Mutation.RUSSO,
        geneLG2 = Mutation.RUSSO,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2002,
        formattedString = "BEL (Super Russo)"
    ),
    SUPER_SAUCE(
        geneLG1 = Mutation.SAUCE,
        geneLG2 = Mutation.SAUCE,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "BEL (Super Sauce)"
    ),
    SUPER_SPARK(
        geneLG1 = Mutation.SPARK,
        geneLG2 = Mutation.SPARK,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2011,
        formattedString = "Super Spark"
    ),
    SUPER_SPECIAL(
        geneLG1 = Mutation.SPECIAL,
        geneLG2 = Mutation.SPECIAL,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Special"
    ),
    SUPER_SPECTER(
        geneLG1 = Mutation.SPECTER,
        geneLG2 = Mutation.SPECTER,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2012,
        formattedString = "Super Specter"
    ),
    SUPER_SPOTNOSE(
        geneLG1 = Mutation.SPOTNOSE,
        geneLG2 = Mutation.SPOTNOSE,
        geneType = GeneType.COALLELIC,
        firstAppearance = 2005,
        formattedString = "Power Ball"
    ),
    SUPER_SULFUR(
        geneLG1 = Mutation.SULFUR,
        geneLG2 = Mutation.SULFUR,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Sulfur"
    ),

    /**
     * Codominant.
     */
    ASPHALT(
        geneLG1 = Mutation.ASPHALT,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2009,
        formattedString = "Asphalt"
    ),
    ARROYO(
        geneLG1 = Mutation.ARROYO,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2010,
        formattedString = "Arroyo"
    ),
    BAMBOO(
        geneLG1 = Mutation.BAMBOO,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2013,
        formattedString = "Bamboo"
    ),
    BANANA(
        geneLG1 = Mutation.BANANA,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2003,
        formattedString = "Banana"
    ),
    BLACK_HEAD(
        geneLG1 = Mutation.BLACK_HEAD,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Black Head"
    ),
    BLACK_PASTEL(
        geneLG1 = Mutation.BLACK_PASTEL,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Black Pastel"
    ),
    BLADE(
        geneLG1 = Mutation.BLADE,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Blade"
    ),
    BONGO(
        geneLG1 = Mutation.BONGO,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2012,
        formattedString = "Bongo"
    ),
    BUTTER(
        geneLG1 = Mutation.BUTTER,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2001,
        formattedString = "Butter"
    ),
    CHAMPAGNE(
        geneLG1 = Mutation.CHAMPAGNE,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2005,
        formattedString = "Champagne"
    ),
    CHOCOLATE(
        geneLG1 = Mutation.CHOCOLATE,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 1999,
        formattedString = "Chocolate"
    ),
    CINNAMON(
        geneLG1 = Mutation.CINNAMON,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Cinnamon"
    ),
    CORAL_GLOW(
        geneLG1 = Mutation.CORAL_GLOW,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Coral Glow"
    ),
    DISCO(
        geneLG1 = Mutation.DISCO,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2004,
        formattedString = "Disco"
    ),
    ENCHI(
        geneLG1 = Mutation.ENCHI,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Enchi",
        description = Description.ENCHI
    ),
    FIRE(
        geneLG1 = Mutation.FIRE,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2003,
        formattedString = "Fire"
    ),
    FLAME(
        geneLG1 = Mutation.FLAME,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Flame"
    ),
    FLARE(
        geneLG1 = Mutation.FLARE,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2010,
        formattedString = "Flare"
    ),
    GHI(
        geneLG1 = Mutation.GHI,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2007,
        formattedString = "GHI",
        description = Description.GHI
    ),
    GRANITE(
        geneLG1 = Mutation.GRANITE,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2003,
        formattedString = "Granite"
    ),
    GRAVEL(
        geneLG1 = Mutation.GRAVEL,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Gravel"
    ),
    HIDDEN_GENE_WOMA(
        geneLG1 = Mutation.HIDDEN_GENE_WOMA,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null ,
        formattedString = "Hidden Gene Woma"
    ),
    LEMONBACK(
        geneLG1 = Mutation.LEMONBACK,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "LemonBack"
    ),
    LESSER(
        geneLG1 = Mutation.LESSER,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2001,
        formattedString = "Lesser"
    ),
    LEOPARD(
        geneLG1 = Mutation.LEOPARD,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Leopard"
    ),
    MAHOGANY(
        geneLG1 = Mutation.MAHOGANY,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Mahogany"
    ),
    MOCHA(
        geneLG1 = Mutation.MOCHA,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Mocha"
    ),
    MOJAVE(
        geneLG1 = Mutation.MOJAVE,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2000,
        formattedString = "Mojave"
    ),
    MYSTIC(
        geneLG1 = Mutation.MYSTIC,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2005,
        formattedString = "Mystic"
    ),
    ORANGE_BELLY(
        geneLG1 = Mutation.ORANGE_BELLY,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Orange Belly"
    ),
    ORANGE_DREAM(
        geneLG1 = Mutation.ORANGE_DREAM,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2004,
        formattedString = "Orange Dream"
    ),
    PHANTOM(
        geneLG1 = Mutation.PHANTOM,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2005,
        formattedString = "Phantom"
    ),
    PASTEL(
        geneLG1 = Mutation.PASTEL,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 1997,
        formattedString = "Pastel",
        description = Description.PASTEL
    ),
    RUSSO(
        geneLG1 = Mutation.RUSSO,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 1998,
        formattedString = "Russo"
    ),
    SAUCE(
        geneLG1 = Mutation.SAUCE,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Sauce"
    ),
    SPARK(
        geneLG1 = Mutation.SPARK,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Spark"
    ),
    SPECIAL(
        geneLG1 = Mutation.SPECIAL,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Special"
    ),
    SPECTER(
        geneLG1 = Mutation.SPECTER,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Specter"
    ),
    SPIDER(
        geneLG1 = Mutation.SPIDER,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 1999,
        formattedString = "Spider"
    ),
    SPOTNOSE(
        geneLG1 = Mutation.SPOTNOSE,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 2005,
        formattedString = "Spotnose"
    ),
    SULFUR(
        geneLG1 = Mutation.SULFUR,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Sulfur"
    ),
    VANILLA(
        geneLG1 = Mutation.VANILLA,
        geneType = GeneType.CODOMINANT,
        firstAppearance = null ,
        formattedString = "Vanilla"
    ),
    YELLOW_BELLY(
        geneLG1 = Mutation.YELLOW_BELLY,
        geneType = GeneType.CODOMINANT,
        firstAppearance = 1999,
        formattedString = "Yellow Belly"
    ),

    /**
     * Dominant.
     */
    ACID(
        geneLG1 = Mutation.ACID,
        geneType = GeneType.DOMINANT,
        firstAppearance = 2014,
        formattedString = "Acid"
    ),
    BINGO(
        geneLG1 = Mutation.BINGO,
        geneType = GeneType.DOMINANT,
        firstAppearance = 2012,
        formattedString = "Bingo"
    ),
    BLAZE(
        geneLG1 = Mutation.BLAZE,
        geneType = GeneType.DOMINANT,
        firstAppearance = null,
        formattedString = "Blaze"
    ),
    BRITE(
        geneLG1 = Mutation.BRITE,
        geneType = GeneType.DOMINANT,
        firstAppearance = 2009,
        formattedString = "Brite"
    ),
    CALICO(
        geneLG1 = Mutation.CALICO,
        geneType = GeneType.DOMINANT,
        firstAppearance = 2002,
        formattedString = "Calico"
    ),
    CONFUSION(
        geneLG1 = Mutation.CONFUSION,
        geneType = GeneType.DOMINANT,
        firstAppearance = 2012,
        formattedString = "Confusion"
    ),
    PINSTRIPE(
        geneLG1 = Mutation.PINSTRIPE,
        geneType = GeneType.DOMINANT,
        firstAppearance = 2001,
        formattedString = "Pinstripe"
    ),
    WOMA(
        geneLG1 = Mutation.WOMA,
        geneType = GeneType.DOMINANT,
        firstAppearance = null,
        formattedString = "Woma"
    ),

    /**
     * Recessives
     */
    HET_ALBINO(
        geneLG1 = null,
        geneLG2 = Mutation.HET_ALBINO,
        geneType = GeneType.RECESSIVE,
        firstAppearance = 1992,
        formattedString = "Het Albino"
    ),
    HET_AXANTHIC_JOLLIFF(
        geneLG1 = null,
        geneLG2 = Mutation.HET_AXANTHIC_JOLLIFF,
        geneType = GeneType.RECESSIVE,
        firstAppearance = 1997,
        formattedString = "Het Axanthic (Jolliff)"
    ),
    HET_AXANTHIC_TSK(
        geneLG1 = null,
        geneLG2 =  Mutation.HET_AXANTHIC_TSK,
        geneType = GeneType.RECESSIVE,
        firstAppearance = null,
        formattedString = "Het Axanthic (TSK)"
    ),
    HET_AXANTHIC_VPI(
        geneLG1 = null,
        geneLG2 = Mutation.HET_AXANTHIC_VPI,
        geneType = GeneType.RECESSIVE,
        firstAppearance = 1997,
        formattedString = "Het Axanthic (VPI)"
    ),
    HET_CANDY(
        geneLG1 = null,
        geneLG2 = Mutation.HET_CANDY,
        geneType = GeneType.RECESSIVE,
        firstAppearance = null,
        formattedString = "Het Candy"
    ),
    HET_CLOWN(
        geneLG1 = null,
        geneLG2 = Mutation.HET_CLOWN,
        geneType = GeneType.RECESSIVE,
        firstAppearance = 1999,
        formattedString = "Het Clown"
    ),
    HET_CRYPTIC(
        geneLG1 = null,
        geneLG2 = Mutation.HET_CRYPTIC,
        geneType = GeneType.RECESSIVE,
        firstAppearance = null,
        formattedString = "Het Cryptic"
    ),
    HET_DADDY(
        geneLG1 = null,
        geneLG2 = Mutation.HET_CRYPTIC,
        geneType = GeneType.RECESSIVE,
        firstAppearance = null,
        formattedString = "Het Daddy"
    ),
    HET_DESERT_GHOST(
        geneLG1 = null,
        geneLG2 = Mutation.HET_DESERT_GHOST,
        geneType = GeneType.RECESSIVE,
        firstAppearance = 2003,
        formattedString = "Het Desert Ghost"
    ),
    HET_GENETIC_STRIPE(
        geneLG1 = null,
        geneLG2 = Mutation.HET_GENETIC_STRIPE,
        geneType = GeneType.RECESSIVE,
        firstAppearance = 1999,
        formattedString = "Het Genetic Stripe"
    ),
    HET_GHOST(
        geneLG1 = null,
        geneLG2 = Mutation.HET_GHOST,
        geneType = GeneType.RECESSIVE,
        firstAppearance = 1994,
        formattedString = "Het Ghost"
    ),
    HET_MONSOON(
        geneLG1 = null,
        geneLG2 = Mutation.HET_MONSOON,
        geneType = GeneType.RECESSIVE,
        firstAppearance = 2017,
        formattedString = "Het Monsoon"
    ),
    HET_PIED(
        geneLG1 = null,
        geneLG2 = Mutation.HET_PIED,
        geneType = GeneType.RECESSIVE,
        firstAppearance = 1997,
        formattedString = "Het Pied"
    ),
    HET_SUNSET(
        geneLG1 = null,
        geneLG2 = Mutation.HET_SUNSET,
        geneType = GeneType.RECESSIVE,
        firstAppearance = 2012,
        formattedString = "Het Sunset"
    ),
    HET_TOFFEE(
        geneLG1 = null,
        geneLG2 = Mutation.HET_TOFFEE,
        geneType = GeneType.RECESSIVE,
        firstAppearance = 2009,
        formattedString = "Het Toffee"
    ),
    HET_ULTRAMEL(
        geneLG1 = null,
        geneLG2 = Mutation.HET_ULTRAMEL,
        geneType = GeneType.RECESSIVE,
        firstAppearance = null,
        formattedString = "Het Ultramel"
    ),


    /**
     * Visual recessives.
     */
    ALBINO(
        geneLG1 = Mutation.HET_ALBINO,
        geneLG2 = Mutation.HET_ALBINO,
        geneType = HET_ALBINO.geneType,
        firstAppearance = HET_ALBINO.firstAppearance,
        formattedString = "Albino"
    ),
    AXANTHIC_JOLLIFF(
        geneLG1 = Mutation.HET_AXANTHIC_JOLLIFF,
        geneLG2 = Mutation.HET_AXANTHIC_JOLLIFF,
        geneType = HET_AXANTHIC_JOLLIFF.geneType,
        firstAppearance = HET_AXANTHIC_JOLLIFF.firstAppearance,
        formattedString = "Axanthic (Jolliff)"
    ),
    AXANTHIC_TSK(
        geneLG1 = Mutation.HET_AXANTHIC_TSK,
        geneLG2 = Mutation.HET_AXANTHIC_TSK,
        geneType = HET_AXANTHIC_TSK.geneType,
        firstAppearance = HET_AXANTHIC_TSK.firstAppearance,
        formattedString = "Axanthic (TSK)"
    ),
    AXANTHIC_VPI(
        geneLG1 = Mutation.HET_AXANTHIC_VPI,
        geneLG2 = Mutation.HET_AXANTHIC_VPI,
        geneType = HET_AXANTHIC_VPI.geneType,
        firstAppearance = HET_AXANTHIC_VPI.firstAppearance,
        formattedString = "Axanthic (VPI)"
    ),
    CANDY(
        geneLG1 = Mutation.HET_CANDY,
        geneLG2 = Mutation.HET_CANDY,
        geneType = HET_CANDY.geneType,
        firstAppearance = HET_CANDY.firstAppearance,
        formattedString = "Candy"
    ),
    CLOWN(
        geneLG1 = Mutation.HET_CLOWN,
        geneLG2 = Mutation.HET_CLOWN,
        geneType = HET_CLOWN.geneType,
        firstAppearance = HET_CLOWN.firstAppearance,
        formattedString = "Clown"
    ),
    CRYPTIC(
        geneLG1 = Mutation.HET_CRYPTIC,
        geneLG2 = Mutation.HET_CRYPTIC,
        geneType = HET_CRYPTIC.geneType,
        firstAppearance = HET_CRYPTIC.firstAppearance,
        formattedString = "Cryptic"
    ),
    CRYPTON(
        geneLG1 = Mutation.HET_CRYPTIC,
        geneLG2 = Mutation.HET_CLOWN,
        geneType = GeneType.COALLELIC,
        firstAppearance = null,
        formattedString = "Crypton"
    ),
    DESERT_GHOST(
        geneLG1 = Mutation.HET_DESERT_GHOST,
        geneLG2 = Mutation.HET_DESERT_GHOST,
        geneType = HET_DESERT_GHOST.geneType,
        firstAppearance = HET_DESERT_GHOST.firstAppearance,
        formattedString = "Desert Ghost"
    ),
    GENETIC_STRIPE(
        geneLG1 = Mutation.HET_GENETIC_STRIPE,
        geneLG2 = Mutation.HET_GENETIC_STRIPE,
        geneType = HET_GENETIC_STRIPE.geneType,
        firstAppearance = HET_GENETIC_STRIPE.firstAppearance,
        formattedString = "Genetic Stripe"
    ),
    GHOST(
        geneLG1 = Mutation.HET_GHOST,
        geneLG2 = Mutation.HET_GHOST,
        geneType = HET_GHOST.geneType,
        firstAppearance = HET_GHOST.firstAppearance,
        formattedString = "Ghost"
    ),
    MONSOON(
        geneLG1 = Mutation.HET_MONSOON,
        geneLG2 = Mutation.HET_MONSOON,
        geneType = HET_MONSOON.geneType,
        firstAppearance = HET_MONSOON.firstAppearance,
        formattedString = "Monsoon"
    ),
    PIED(
        geneLG1 = Mutation.HET_PIED,
        geneLG2 = Mutation.HET_PIED,
        geneType = HET_PIED.geneType,
        firstAppearance = HET_PIED.firstAppearance,
        formattedString = "Pied"
    ),
    SUNSET(
        geneLG1 = Mutation.HET_SUNSET,
        geneLG2 = Mutation.HET_SUNSET,
        geneType = HET_SUNSET.geneType,
        firstAppearance = HET_SUNSET.firstAppearance,
        formattedString = "Sunset"
    ),
    TOFFEE(
        geneLG1 = Mutation.HET_TOFFEE,
        geneLG2 = Mutation.HET_TOFFEE,
        geneType = HET_TOFFEE.geneType,
        firstAppearance = HET_TOFFEE.firstAppearance,
        formattedString = "Toffee"
    ),
    ULTRAMEL(
        geneLG1 = Mutation.HET_ULTRAMEL,
        geneLG2 = Mutation.HET_ULTRAMEL,
        geneType = HET_ULTRAMEL.geneType,
        firstAppearance = HET_ULTRAMEL.firstAppearance,
        formattedString = "Ultramel"
    ),


    NORMAL(formattedString = "Normal"),
    ;

    companion object {

        /**
         * Returns the Trait corresponding to the given Mutations combo.
         */
        fun fromValue(
            geneLG1: Mutation? = null,
            geneLG2: Mutation? = null,
        ): Trait? {
            if (geneLG1 != null && geneLG2 != null) {
                values().find { trait ->
                    trait.geneLG1 == geneLG1 && trait.geneLG2 == geneLG2
                }?.let { return it }

                values().find { trait ->
                    trait.geneLG1 == geneLG2 && trait.geneLG2 == geneLG1
                }?.let { return it }

            } else {

                return values().find {
                    it.geneLG1 == geneLG1 && it.geneLG2 == geneLG2
                }

            }
            return null
        }

        /**
         * Returns the Trait corresponding to the formatted string.
         */
        fun getTraitFromString(formattedString: String): Trait? {
            return values().find {
                it.formattedString.equals(formattedString, ignoreCase = true)
            }
        }

        /**
         * Returns all the Traits made with that het.
         * E.G. HET_CLOWN -> CLOWN, CRYPTON
         */
        fun findByHet(
            mutation: Mutation? = null
        ): List<Trait> {
            return if (mutation == null){
                listOf(NORMAL)
            } else {
                values().filter { trait ->
                    (trait.geneLG1 == mutation || trait.geneLG2 == mutation) && trait.geneLG1 != null
                }
            }
        }
    }
}

/**
 * Return the number of mutation count.
 * E.G. CRYPTON = 2
 *      CLOWN = 2
 *      PASTEL = 1
 */
fun Trait.getMutationCount() : Int {
    if (this.geneLG1 == null || this.geneLG2 == null) {
        return 1
    }
    if (this.geneLG1 != this.geneLG2) {
        return 2
    }
    return 1
}

enum class GeneType {
    DOMINANT,
    CODOMINANT,
    RECESSIVE,
    COALLELIC,
}