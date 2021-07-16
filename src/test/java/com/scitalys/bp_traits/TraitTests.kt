package com.scitalys.bp_traits

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * Test class for Trait companion and extension functions.
 */

class TraitTests {

    @Test
    fun fromValue() {
        assertEquals(
            Trait.CRYPTON,
            Trait.fromValue(Mutation.HET_CLOWN, Mutation.HET_CRYPTIC)
        )
        assertEquals(
            Trait.CRYPTON,
            Trait.fromValue(Mutation.HET_CRYPTIC, Mutation.HET_CLOWN)
        )
        assertEquals(
            null,
            Trait.fromValue(Mutation.CINNAMON, Mutation.PASTEL)
        )
        assertEquals(
            Trait.HET_PIED,
            Trait.fromValue(null, Mutation.HET_PIED)
        )
        assertNotEquals(
            Trait.HET_PIED,
            Trait.fromValue(Mutation.HET_PIED, null)
        )
    }

    @Test
    fun findByHetTest() {
        assertEquals(
            listOf(Trait.CLOWN, Trait.CRYPTON),
            Trait.findByHet(Mutation.HET_CLOWN)
        )
        assertEquals(
            listOf(Trait.PIED),
            Trait.findByHet(Mutation.HET_PIED)
        )
    }

    @Test
    fun isHetRecessive() {
        assertEquals(
            false,
            Trait.ACID.isHetRecessive()
        )
        assertEquals(
            false,
            Trait.BINGO.isHomoRecessive()
        )
        assertEquals(
            true,
            Trait.HET_ALBINO.isHetRecessive()
        )
        assertEquals(
            true,
            Trait.PIED.isHomoRecessive()
        )
        assertEquals(
            false,
            Trait.PIED.isHetRecessive()
        )
    }

    @Test
    fun isHomoRecessive() {
        assertEquals(
            true,
            Trait.PIED.isHomoRecessive()
        )
        assertEquals(
            false,
            Trait.CRYPTON.isHomoRecessive()
        )
        assertEquals(
            true,
            Trait.ALBINO.isHomoRecessive()
        )
    }

    @Test
    fun isHetCodominant() {
        assertEquals(
            true,
            Trait.PASTEL.isHetCodominant()
        )
        assertEquals(
            false,
            Trait.SUPER_PASTEL.isHetCodominant()
        )
    }

    @Test
    fun isHomoCodominant() {
        assertEquals(
            false,
            Trait.SUPER_PASTEL.isHomoRecessive()
        )
        assertEquals(
            true,
            Trait.SUPER_PASTEL.isHomoCodominant()
        )
    }

}