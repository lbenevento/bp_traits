package com.scitalys.bp_traits

import java.lang.IllegalStateException

enum class Morph(
    val mutations: Set<LociPair> = setOf(),
    val morphType: MorphType? = null,
    val firstAppearance: Int? = null,
    val description: Description? = null,
    val formattedString: String
) {
    /**
     * Supers and coallelics.
     */
    FREEWAY(
        mutations = setOf(
            LociPair(
                Mutation.YELLOW_BELLY,
                Mutation.ASPHALT
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2009,
        formattedString = "Freeway"
    ),
    HIGHWAY(
        mutations = setOf(
            LociPair(
                Mutation.YELLOW_BELLY,
                Mutation.GRAVEL
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Highway"
    ),
    IVORY(
        mutations = setOf(
            LociPair(
                Mutation.YELLOW_BELLY,
                Mutation.YELLOW_BELLY
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2003,
        formattedString = "Ivory"
    ),
    RIO(
        mutations = setOf(
            LociPair(
                Mutation.ARROYO,
                Mutation.ARROYO
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2010,
        formattedString = "Rio"
    ),
    SOLAR_FLARE(
        mutations = setOf(
            LociPair(
                Mutation.FLARE,
                Mutation.FLARE
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2010,
        formattedString = "Solar Flare"
    ),
    SUPER_ASPHALT(
        mutations = setOf(
            LociPair(
                Mutation.ASPHALT,
                Mutation.ASPHALT
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Asphalt"
    ),
    SUPER_BAMBOO(
        mutations = setOf(
            LociPair(
                Mutation.BAMBOO,
                Mutation.BAMBOO
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Bamboo"
    ),
    SUPER_BANANA(
        mutations = setOf(
            LociPair(
                Mutation.BANANA,
                Mutation.BANANA
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Banana"
    ),
    SUPER_BLACK_HEAD(
        mutations = setOf(
            LociPair(
                Mutation.BLACK_HEAD,
                Mutation.BLACK_HEAD
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2008,
        formattedString = "Super Black Head"
    ),
    SUPER_BLACK_PASTEL(
        mutations = setOf(
            LociPair(
                Mutation.BLACK_PASTEL,
                Mutation.BLACK_PASTEL
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Black Pastel"
    ),
    SUPER_BLADE(
        mutations = setOf(
            LociPair(
                Mutation.BLADE,
                Mutation.BLADE
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Blade"
    ),
    SUPER_BONGO(
        mutations = setOf(
            LociPair(
                Mutation.BONGO,
                Mutation.BONGO
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2013,
        formattedString = "Super Bongo"
    ),
    SUPER_BUTTER(
        mutations = setOf(
            LociPair(
                Mutation.BUTTER,
                Mutation.BUTTER
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "BEL (Super Butter)"
    ),
    SUPER_CHOCOLATE(
        mutations = setOf(
            LociPair(
                Mutation.CHOCOLATE,
                Mutation.CHOCOLATE
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Chocolate"
    ),
    SUPER_CINNAMON(
        mutations = setOf(
            LociPair(
                Mutation.CINNAMON,
                Mutation.CINNAMON
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2002,
        formattedString = "Super Cinnamon"
    ),
    SUPER_CORAL_GLOW(
        mutations = setOf(
            LociPair(
                Mutation.CORAL_GLOW,
                Mutation.CORAL_GLOW
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2012,
        formattedString = "Super Coral Glow"
    ),
    SUPER_CYPRESS(
        mutations = setOf(
            LociPair(
                Mutation.CYPRESS,
                Mutation.CYPRESS
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2013,
        formattedString = "Super Cypress"
    ),
    SUPER_DISCO(
        mutations = setOf(
            LociPair(
                Mutation.DISCO,
                Mutation.DISCO,
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2009,
        formattedString = "Super Disco"
    ),
    SUPER_ENCHI(
        mutations = setOf(
            LociPair(
                Mutation.ENCHI,
                Mutation.ENCHI
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2003,
        formattedString = "Super Enchi"
    ),
    SUPER_FIRE(
        mutations = setOf(
            LociPair(
                Mutation.FIRE,
                Mutation.FIRE
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2002,
        formattedString = "BEL (Super Fire)"
    ),
    SUPER_FLAME(
        mutations = setOf(
            LociPair(
                Mutation.FLAME,
                Mutation.FLAME
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "BEL (Super Flame)"
    ),
    SUPER_GHI(
        mutations = setOf(
            LociPair(
                Mutation.GHI,
                Mutation.GHI
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2010,
        formattedString = "Super GHI"
    ),
    SUPER_GRANITE(
        mutations = setOf(
            LociPair(
                Mutation.GRANITE,
                Mutation.GRANITE
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Granite"
    ),
    SUPER_LEMONBACK(
        mutations = setOf(
            LociPair(
                Mutation.LEMONBACK,
                Mutation.LEMONBACK
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super LemonBack"
    ),
    SUPER_LESSER(
        mutations = setOf(
            LociPair(
                Mutation.LESSER,
                Mutation.LESSER
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2004,
        formattedString = "BEL (Super Lesser)"
    ),
    SUPER_MAHOGANY(
        mutations = setOf(
            LociPair(
                Mutation.MAHOGANY,
                Mutation.MAHOGANY
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Suma"
    ),
    SUPER_MOJAVE(
        mutations = setOf(
            LociPair(
                Mutation.MOJAVE,
                Mutation.MOJAVE
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2003,
        formattedString = "BEL (Super Mojave)"
    ),
    SUPER_MOCHA(
        mutations = setOf(
            LociPair(
                Mutation.MOCHA,
                Mutation.MOCHA
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Mocha"
    ),
    SUPER_MYSTIC(
        mutations = setOf(
            LociPair(
                Mutation.MYSTIC,
                Mutation.MYSTIC
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2009,
        formattedString = "Super Mystic"
    ),
    SUPER_ORANGE_BELLY(
        mutations = setOf(
            LociPair(
                Mutation.ORANGE_BELLY,
                Mutation.ORANGE_BELLY
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Graphite Ivory"
    ),
    SUPER_ORANGE_DREAM(
        mutations = setOf(
            LociPair(
                Mutation.ORANGE_DREAM,
                Mutation.ORANGE_DREAM
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2011,
        formattedString = "Super OD"
    ),
    SUPER_PASTEL(
        mutations = setOf(
            LociPair(
                Mutation.PASTEL,
                Mutation.PASTEL
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 1999,
        formattedString = "Super Pastel"
    ),
    SUPER_PHANTOM(
        mutations = setOf(
            LociPair(
                Mutation.PHANTOM,
                Mutation.PHANTOM
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2005,
        formattedString = "Super Phantom"
    ),
    SUPER_RUSSO(
        mutations = setOf(
            LociPair(
                Mutation.RUSSO,
                Mutation.RUSSO
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2002,
        formattedString = "BEL (Super Russo)"
    ),
    SUPER_SAUCE(
        mutations = setOf(
            LociPair(
                Mutation.SAUCE,
                Mutation.SAUCE
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "BEL (Super Sauce)"
    ),
    SUPER_SPARK(
        mutations = setOf(
            LociPair(
                Mutation.SPARK,
                Mutation.SPARK
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2011,
        formattedString = "Super Spark"
    ),
    SUPER_SPECIAL(
        mutations = setOf(
            LociPair(
                Mutation.SPECIAL,
                Mutation.SPECIAL
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Special"
    ),
    SUPER_SPECTER(
        mutations = setOf(
            LociPair(
                Mutation.SPECTER,
                Mutation.SPECTER
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2012,
        formattedString = "Super Specter"
    ),
    SUPER_SPOTNOSE(
        mutations = setOf(
            LociPair(
                Mutation.SPOTNOSE,
                Mutation.SPOTNOSE
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = 2005,
        formattedString = "Power Ball"
    ),
    SUPER_SULFUR(
        mutations = setOf(
            LociPair(
                Mutation.SULFUR,
                Mutation.SULFUR
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Super Sulfur"
    ),

    /**
     * Codominant.
     */
    ASPHALT(
        mutations = setOf(
            LociPair(
                Mutation.ASPHALT
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2009,
        formattedString = "Asphalt"
    ),
    ARROYO(
        mutations = setOf(
            LociPair(
                Mutation.ARROYO
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2010,
        formattedString = "Arroyo"
    ),
    BAMBOO(
        mutations = setOf(
            LociPair(
                Mutation.BAMBOO
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2013,
        formattedString = "Bamboo"
    ),
    BANANA(
        mutations = setOf(
            LociPair(
                Mutation.BANANA
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2003,
        formattedString = "Banana"
    ),
    BLACK_HEAD(
        mutations = setOf(
            LociPair(
                Mutation.BLACK_HEAD
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Black Head"
    ),
    BLACK_PASTEL(
        mutations = setOf(
            LociPair(
                Mutation.BLACK_PASTEL
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Black Pastel"
    ),
    BLADE(
        mutations = setOf(
            LociPair(
                Mutation.BLADE
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Blade"
    ),
    BONGO(
        mutations = setOf(
            LociPair(
                Mutation.BONGO
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2012,
        formattedString = "Bongo"
    ),
    BUTTER(
        mutations = setOf(
            LociPair(
                Mutation.BUTTER
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2001,
        formattedString = "Butter"
    ),
    CHAMPAGNE(
        mutations = setOf(
            LociPair(
                Mutation.CHAMPAGNE
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2005,
        formattedString = "Champagne"
    ),
    CHOCOLATE(
        mutations = setOf(
            LociPair(
                Mutation.CHOCOLATE
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 1999,
        formattedString = "Chocolate"
    ),
    CINNAMON(
        mutations = setOf(
            LociPair(
                Mutation.CINNAMON
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Cinnamon"
    ),
    CORAL_GLOW(
        mutations = setOf(
            LociPair(
                Mutation.CORAL_GLOW
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Coral Glow"
    ),
    CYPRESS(
        mutations = setOf(
            LociPair(
                Mutation.CYPRESS
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2012,
        formattedString = "Cypress"
    ),
    DISCO(
        mutations = setOf(
            LociPair(
                Mutation.DISCO
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2004,
        formattedString = "Disco"
    ),
    ENCHI(
        mutations = setOf(
            LociPair(
                Mutation.ENCHI
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2002,
        formattedString = "Enchi",
        description = Description.ENCHI
    ),
    FIRE(
        mutations = setOf(
            LociPair(
                Mutation.FIRE
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2003,
        formattedString = "Fire"
    ),
    FLAME(
        mutations = setOf(
            LociPair(
                Mutation.FLAME
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Flame"
    ),
    FLARE(
        mutations = setOf(
            LociPair(
                Mutation.FLARE
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2010,
        formattedString = "Flare"
    ),
    GHI(
        mutations = setOf(
            LociPair(
                Mutation.GHI
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2007,
        formattedString = "GHI",
        description = Description.GHI
    ),
    GRANITE(
        mutations = setOf(
            LociPair(
                Mutation.GRANITE
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2003,
        formattedString = "Granite"
    ),
    GRAVEL(
        mutations = setOf(
            LociPair(
                Mutation.GRAVEL
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Gravel"
    ),
    HIDDEN_GENE_WOMA(
        mutations = setOf(
            LociPair(
                Mutation.HIDDEN_GENE_WOMA
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Hidden Gene Woma"
    ),
    LEMONBACK(
        mutations = setOf(
            LociPair(
                Mutation.LEMONBACK
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "LemonBack"
    ),
    LESSER(
        mutations = setOf(
            LociPair(
                Mutation.LESSER
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2001,
        formattedString = "Lesser"
    ),
    LEOPARD(
        mutations = setOf(
            LociPair(
                Mutation.LESSER
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Leopard"
    ),
    MAHOGANY(
        mutations = setOf(
            LociPair(
                Mutation.MAHOGANY
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Mahogany"
    ),
    MOCHA(
        mutations = setOf(
            LociPair(
                Mutation.MOCHA
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Mocha"
    ),
    MOJAVE(
        mutations = setOf(
            LociPair(
                Mutation.MOJAVE
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2000,
        formattedString = "Mojave"
    ),
    MYSTIC(
        mutations = setOf(
            LociPair(
                Mutation.MYSTIC
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2005,
        formattedString = "Mystic"
    ),
    ORANGE_BELLY(
        mutations = setOf(
            LociPair(
                Mutation.ORANGE_BELLY
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Orange Belly"
    ),
    ORANGE_DREAM(
        mutations = setOf(
            LociPair(
                Mutation.ORANGE_DREAM
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2004,
        formattedString = "Orange Dream"
    ),
    PHANTOM(
        mutations = setOf(
            LociPair(
                Mutation.PHANTOM
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2005,
        formattedString = "Phantom"
    ),
    PASTEL(
        mutations = setOf(
            LociPair(
                Mutation.PASTEL
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 1997,
        formattedString = "Pastel",
        description = Description.PASTEL
    ),
    RUSSO(
        mutations = setOf(
            LociPair(
                Mutation.RUSSO
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 1998,
        formattedString = "Russo"
    ),
    SAUCE(
        mutations = setOf(
            LociPair(
                Mutation.SAUCE
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Sauce"
    ),
    SPARK(
        mutations = setOf(
            LociPair(
                Mutation.SPARK
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Spark"
    ),
    SPECIAL(
        mutations = setOf(
            LociPair(
                Mutation.SPECIAL
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Special"
    ),
    SPECTER(
        mutations = setOf(
            LociPair(
                Mutation.SPECTER
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Specter"
    ),
    SPIDER(
        mutations = setOf(
            LociPair(
                Mutation.SPIDER
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 1999,
        formattedString = "Spider"
    ),
    SPOTNOSE(
        mutations = setOf(
            LociPair(
                Mutation.SPOTNOSE
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 2005,
        formattedString = "Spotnose"
    ),
    SULFUR(
        mutations = setOf(
            LociPair(
                Mutation.SULFUR
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Sulfur"
    ),
    VANILLA(
        mutations = setOf(
            LociPair(
                Mutation.VANILLA
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = null,
        formattedString = "Vanilla"
    ),
    YELLOW_BELLY(
        mutations = setOf(
            LociPair(
                Mutation.YELLOW_BELLY
            )
        ),
        morphType = MorphType.CODOMINANT,
        firstAppearance = 1999,
        formattedString = "Yellow Belly"
    ),

    /**
     * Dominant.
     */
    ACID(
        mutations = setOf(
            LociPair(
                Mutation.ACID
            )
        ),
        morphType = MorphType.DOMINANT,
        firstAppearance = 2014,
        formattedString = "Acid"
    ),
    BINGO(
        mutations = setOf(
            LociPair(
                Mutation.BINGO
            )
        ),
        morphType = MorphType.DOMINANT,
        firstAppearance = 2012,
        formattedString = "Bingo"
    ),
    BLAZE(
        mutations = setOf(
            LociPair(
                Mutation.BLAZE
            )
        ),
        morphType = MorphType.DOMINANT,
        firstAppearance = null,
        formattedString = "Blaze"
    ),
    BRITE(
        mutations = setOf(
            LociPair(
                Mutation.BRITE
            )
        ),
        morphType = MorphType.DOMINANT,
        firstAppearance = 2009,
        formattedString = "Brite"
    ),
    CALICO(
        mutations = setOf(
            LociPair(
                Mutation.CALICO
            )
        ),
        morphType = MorphType.DOMINANT,
        firstAppearance = 2002,
        formattedString = "Calico"
    ),
    CONFUSION(
        mutations = setOf(
            LociPair(
                Mutation.CONFUSION
            )
        ),
        morphType = MorphType.DOMINANT,
        firstAppearance = 2012,
        formattedString = "Confusion"
    ),
    PINSTRIPE(
        mutations = setOf(
            LociPair(
                Mutation.PINSTRIPE
            )
        ),
        morphType = MorphType.DOMINANT,
        firstAppearance = 2001,
        formattedString = "Pinstripe"
    ),
    WOMA(
        mutations = setOf(
            LociPair(
                Mutation.WOMA
            )
        ),
        morphType = MorphType.DOMINANT,
        firstAppearance = null,
        formattedString = "Woma"
    ),

    /**
     * Recessives
     */
    HET_ALBINO(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_ALBINO
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = 1992,
        formattedString = "Het Albino"
    ),
    HET_AXANTHIC_JOLLIFF(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_AXANTHIC_JOLLIFF
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = 1997,
        formattedString = "Het Axanthic (Jolliff)"
    ),
    HET_AXANTHIC_TSK(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_AXANTHIC_TSK
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = null,
        formattedString = "Het Axanthic (TSK)"
    ),
    HET_AXANTHIC_VPI(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_AXANTHIC_VPI
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = 1997,
        formattedString = "Het Axanthic (VPI)"
    ),
    HET_CANDY(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_CANDY
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = null,
        formattedString = "Het Candy"
    ),
    HET_CLOWN(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_CLOWN
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = 1999,
        formattedString = "Het Clown"
    ),
    HET_CRYPTIC(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_CRYPTIC
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = null,
        formattedString = "Het Cryptic"
    ),
    HET_DADDY(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_DADDY
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = null,
        formattedString = "Het Daddy"
    ),
    HET_DESERT_GHOST(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_DESERT_GHOST
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = 2003,
        formattedString = "Het Desert Ghost"
    ),
    HET_GENETIC_STRIPE(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_GENETIC_STRIPE
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = 1999,
        formattedString = "Het Genetic Stripe"
    ),
    HET_GHOST(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_GHOST
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = 1994,
        formattedString = "Het Ghost"
    ),
    HET_MONSOON(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_MONSOON
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = 2017,
        formattedString = "Het Monsoon"
    ),
    HET_ORANGE_GHOST(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_ORANGE_GHOST
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = null,
        formattedString = "Het Orange Ghost"
    ),
    HET_PIED(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_PIED
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = 1997,
        formattedString = "Het Pied"
    ),
    HET_SUNSET(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_SUNSET
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = 2012,
        formattedString = "Het Sunset"
    ),
    HET_TOFFEE(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_TOFFEE
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = 2009,
        formattedString = "Het Toffee"
    ),
    HET_ULTRAMEL(
        mutations = setOf(
            LociPair(
                null,
                Mutation.HET_ULTRAMEL
            )
        ),
        morphType = MorphType.RECESSIVE,
        firstAppearance = null,
        formattedString = "Het Ultramel"
    ),


    /**
     * Visual recessives.
     */
    ALBINO(
        mutations = setOf(
            LociPair(
                Mutation.HET_ALBINO,
                Mutation.HET_ALBINO
            )
        ),
        morphType = HET_ALBINO.morphType,
        firstAppearance = HET_ALBINO.firstAppearance,
        formattedString = "Albino"
    ),
    AXANTHIC_JOLLIFF(
        mutations = setOf(
            LociPair(
                Mutation.HET_AXANTHIC_JOLLIFF,
                Mutation.HET_AXANTHIC_JOLLIFF
            )
        ),
        morphType = HET_AXANTHIC_JOLLIFF.morphType,
        firstAppearance = HET_AXANTHIC_JOLLIFF.firstAppearance,
        formattedString = "Axanthic (Jolliff)"
    ),
    AXANTHIC_TSK(
        mutations = setOf(
            LociPair(
                Mutation.HET_AXANTHIC_TSK,
                Mutation.HET_AXANTHIC_TSK
            )
        ),
        morphType = HET_AXANTHIC_TSK.morphType,
        firstAppearance = HET_AXANTHIC_TSK.firstAppearance,
        formattedString = "Axanthic (TSK)"
    ),
    AXANTHIC_VPI(
        mutations = setOf(
            LociPair(
                Mutation.HET_AXANTHIC_VPI,
                Mutation.HET_AXANTHIC_VPI
            )
        ),
        morphType = HET_AXANTHIC_VPI.morphType,
        firstAppearance = HET_AXANTHIC_VPI.firstAppearance,
        formattedString = "Axanthic (VPI)"
    ),
    CANDY(
        mutations = setOf(
            LociPair(
                Mutation.HET_CANDY,
                Mutation.HET_CANDY
            )
        ),
        morphType = HET_CANDY.morphType,
        firstAppearance = HET_CANDY.firstAppearance,
        formattedString = "Candy"
    ),
    CLOWN(
        mutations = setOf(
            LociPair(
                Mutation.HET_CLOWN,
                Mutation.HET_CLOWN
            )
        ),
        morphType = HET_CLOWN.morphType,
        firstAppearance = HET_CLOWN.firstAppearance,
        formattedString = "Clown"
    ),
    CRYPTIC(
        mutations = setOf(
            LociPair(
                Mutation.HET_CRYPTIC,
                Mutation.HET_CRYPTIC
            )
        ),
        morphType = HET_CRYPTIC.morphType,
        firstAppearance = HET_CRYPTIC.firstAppearance,
        formattedString = "Cryptic"
    ),
    CRYPTON(
        mutations = setOf(
            LociPair(
                Mutation.HET_CRYPTIC,
                Mutation.HET_CLOWN
            )
        ),
        morphType = MorphType.COALLELIC,
        firstAppearance = null,
        formattedString = "Crypton"
    ),
    DESERT_GHOST(
        mutations = setOf(
            LociPair(
                Mutation.HET_DESERT_GHOST,
                Mutation.HET_DESERT_GHOST
            )
        ),
        morphType = HET_DESERT_GHOST.morphType,
        firstAppearance = HET_DESERT_GHOST.firstAppearance,
        formattedString = "Desert Ghost"
    ),
    GENETIC_STRIPE(
        mutations = setOf(
            LociPair(
                Mutation.HET_GENETIC_STRIPE,
                Mutation.HET_GENETIC_STRIPE
            )
        ),
        morphType = HET_GENETIC_STRIPE.morphType,
        firstAppearance = HET_GENETIC_STRIPE.firstAppearance,
        formattedString = "Genetic Stripe"
    ),
    GHOST(
        mutations = setOf(
            LociPair(
                Mutation.HET_GHOST,
                Mutation.HET_GHOST
            )
        ),
        morphType = HET_GHOST.morphType,
        firstAppearance = HET_GHOST.firstAppearance,
        formattedString = "Ghost"
    ),
    MONSOON(
        mutations = setOf(
            LociPair(
                Mutation.HET_MONSOON,
                Mutation.HET_MONSOON
            )
        ),
        morphType = HET_MONSOON.morphType,
        firstAppearance = HET_MONSOON.firstAppearance,
        formattedString = "Monsoon"
    ),
    ORANGE_GHOST(
        mutations = setOf(
            LociPair(
                Mutation.HET_ORANGE_GHOST,
                Mutation.HET_ORANGE_GHOST
            )
        ),
        morphType = HET_ORANGE_GHOST.morphType,
        firstAppearance = HET_ORANGE_GHOST.firstAppearance,
        formattedString = "Orange Ghost"
    ),
    PIED(
        mutations = setOf(
            LociPair(
                Mutation.HET_PIED,
                Mutation.HET_PIED
            )
        ),
        morphType = HET_PIED.morphType,
        firstAppearance = HET_PIED.firstAppearance,
        formattedString = "Pied"
    ),
    SUNSET(
        mutations = setOf(
            LociPair(
                Mutation.HET_SUNSET,
                Mutation.HET_SUNSET
            )
        ),
        morphType = HET_SUNSET.morphType,
        firstAppearance = HET_SUNSET.firstAppearance,
        formattedString = "Sunset"
    ),
    TOFFEE(
        mutations = setOf(
            LociPair(
                Mutation.HET_TOFFEE,
                Mutation.HET_TOFFEE
            )
        ),
        morphType = HET_TOFFEE.morphType,
        firstAppearance = HET_TOFFEE.firstAppearance,
        formattedString = "Toffee"
    ),
    ULTRAMEL(
        mutations = setOf(
            LociPair(
                Mutation.HET_ULTRAMEL,
                Mutation.HET_ULTRAMEL
            )
        ),
        morphType = HET_ULTRAMEL.morphType,
        firstAppearance = HET_ULTRAMEL.firstAppearance,
        formattedString = "Ultramel"
    ),

    /**
     * Combos
     */
    FIRE_ENCHI(
        mutations = combo(FIRE, ENCHI),
        morphType = MorphType.COMBO,
        firstAppearance = null,
        formattedString = "Fire Enchi"
    ),
    PASTEL_CALICO(
        mutations = combo(PASTEL, CALICO),
        morphType = MorphType.COMBO,
        firstAppearance = null,
        formattedString = "Pastel Calico"
    ),
    PASTEL_ENCHI(
        mutations = combo(PASTEL, ENCHI),
        morphType = MorphType.COMBO,
        firstAppearance = null,
        formattedString = "Pastel Enchi"
    ),
    PASTEL_GHI(
        mutations = combo(PASTEL, GHI),
        morphType = MorphType.COMBO,
        firstAppearance = null,
        formattedString = "Pastel GHI"
    ),

    SUPER_INFERNO(
        mutations = combo(GRANITE, HIDDEN_GENE_WOMA, SUPER_PASTEL, YELLOW_BELLY),
        morphType = MorphType.COMBO,
        firstAppearance = null,
        formattedString = "Super Inferno"
    ),

    NORMAL(formattedString = "Normal"),
    ;

    override fun toString(): String {
        return formattedString
    }

    companion object {

        /**
         * Returns the Morph corresponding to the given loci combo.
         * Any duplicate Locus will be ignored.
         */
        fun fromValue(
            vararg loci: LociPair
        ): Morph? {
            val lociSet = loci.toSet()
            if (lociSet.isEmpty() || (lociSet.size == 1 && lociSet.first() == LociPair())) {
                return NORMAL
            }
            values().find { morph ->
                morph.mutations == lociSet
            }?.let { return it }
            return null
        }

        /**
         * Returns the Trait corresponding to the formatted string.
         */
        fun getMorphFromString(formattedString: String): Morph? {
            return values().find {
                it.formattedString.equals(formattedString, ignoreCase = true)
            }
        }

        /**
         * Returns all the Morph made with that het or codominant trait.
         * E.G. HET_CLOWN -> CLOWN, CRYPTON
         *      PASTEL -> PASTEL, SUPER_PASTEL
         */
        fun findBySingleAlleleMutation(
            mutation: Mutation? = null
        ): Set<Morph> {
            return if (mutation == null) {
                setOf(NORMAL)
            } else {
                values().filter{
                    it.morphType != MorphType.COMBO && it != NORMAL
                }.filter { morph ->
                    if (morph.mutations.toList().size > 1) {
                        throw IllegalStateException("Morphs should be filtered to non combos morph only at this point. Instead it was: $morph")
                    }
                    val firstLoci = morph.mutations.toList()[0]
                    (firstLoci.locus1 == mutation || firstLoci.locus2 == mutation) && firstLoci.locus1 != null
                }.toSet()
            }
        }
    }
}

internal fun combo(vararg morphs: Morph): Set<LociPair> {
    val lociPairSet = mutableSetOf<LociPair>()
    morphs.forEach { morph ->
        morph.mutations.forEach { lociPair ->
            lociPairSet.add(lociPair)
        }
    }
    return lociPairSet
}

fun Morph.getMutationCount(): Int {
    var mutationCount = 0
    mutations.forEach {
        if (it.locus1 != null) {
            mutationCount++
        }
        if (it.locus2 != null) {
            mutationCount ++
        }
    }
    return mutationCount
}


fun Morph.isHetRecessive() : Boolean {
    if (morphType == MorphType.RECESSIVE) {
        if (mutations.first().locus1 == null && mutations.first().locus2 != null) {
            return true
        }
    }
    return false
}

fun Morph.isHomoRecessive() : Boolean {
    if (morphType == MorphType.RECESSIVE) {
        if (mutations.first().locus1 != null && mutations.first().locus2 != null) {
            return true
        }
    }
    return false
}

fun Morph.isHomoCodominant() : Boolean {
    if (morphType == MorphType.COALLELIC) {
        if (mutations.first().locus1 != null && mutations.first().locus2 != null) {
            return true
        }
    }
    return false
}

fun Morph.isHetCodominant() : Boolean {
    if (morphType == MorphType.CODOMINANT) {
        if (mutations.first().locus1 != null && mutations.first().locus2 == null) {
            return true
        }
    }
    return false
}

enum class MorphType {
    DOMINANT,
    CODOMINANT,
    RECESSIVE,
    COALLELIC,
    COMBO
}