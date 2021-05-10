package com.scitalys.bp_traits

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Tests {
    @Test
    fun findByHetTest() {
        assertEquals(
            listOf(Trait.CLOWN, Trait.CRYPTON),
            Trait.findByHet(Mutation.HET_CLOWN)
        )
    }

    @Test
    fun findByValue() {
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
}