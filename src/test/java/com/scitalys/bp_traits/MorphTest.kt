package com.scitalys.bp_traits

import org.junit.Assert.assertEquals
import org.junit.Test

class MorphTest {

    @Test
    fun fromValue() {
        val normal1 = Morph.fromValue()
        val normal2 = Morph.fromValue(LociPair())
        val normal3 = Morph.fromValue(LociPair(null, null))
        val pastel = Morph.fromValue(LociPair(Mutation.PASTEL, null))
        val superPastel = Morph.fromValue(LociPair(Mutation.PASTEL, Mutation.PASTEL))
        val hetGhost = Morph.fromValue(LociPair(null, Mutation.HET_GHOST))
        val crypton1 = Morph.fromValue(LociPair(Mutation.HET_CLOWN, Mutation.HET_CRYPTIC))
        val crypton2 = Morph.fromValue(LociPair(Mutation.HET_CRYPTIC, Mutation.HET_CLOWN))
        assertEquals(Morph.NORMAL, normal1)
        assertEquals(Morph.NORMAL, normal2)
        assertEquals(Morph.NORMAL, normal3)
        assertEquals(Morph.PASTEL, pastel)
        assertEquals(Morph.SUPER_PASTEL, superPastel)
        assertEquals(Morph.HET_GHOST, hetGhost)
        assertEquals(Morph.CRYPTON, crypton1)
        assertEquals(Morph.CRYPTON, crypton2)
        assertEquals(crypton1, crypton2)
    }

    @Test
    fun getMorphFromString() {
        val normal = Morph.getMorphFromString("Normal")
        val superOrangeDream = Morph.getMorphFromString("Super OD")
        val pied = Morph.getMorphFromString("Pied")
        val orangeGhost = Morph.getMorphFromString("Orange Ghost")
        val hetAxanthicJolliff = Morph.getMorphFromString("Het Axanthic (Jolliff)")
        assertEquals(Morph.NORMAL, normal)
        assertEquals(Morph.SUPER_ORANGE_DREAM, superOrangeDream)
        assertEquals(Morph.PIED, pied)
        assertEquals(Morph.ORANGE_GHOST, orangeGhost)
        assertEquals(Morph.HET_AXANTHIC_JOLLIFF, hetAxanthicJolliff)
    }

    @Test
    fun findBySingleAlleleMutation() {
        val hetClownList = Morph.findBySingleAlleleMutation(Mutation.HET_CLOWN)
        val hetCryptic = Morph.findBySingleAlleleMutation(Mutation.HET_CRYPTIC)
        val hetPied = Morph.findBySingleAlleleMutation(Mutation.HET_PIED)
        val pastel = Morph.findBySingleAlleleMutation(Mutation.PASTEL)
        assertEquals(
            setOf(
                Morph.CLOWN, Morph.CRYPTON
            ),
            hetClownList
        )
        assertEquals(
            setOf(
                Morph.CRYPTON, Morph.CRYPTIC
            ),
            hetCryptic
        )
        assertEquals(
            setOf(
                Morph.PIED
            ),
            hetPied
        )
        assertEquals(
            setOf(Morph.PASTEL, Morph.SUPER_PASTEL),
            pastel
        )
    }

    @Test
    fun getMutationCount() {
        assertEquals(0, Morph.NORMAL.getMutationCount())
        assertEquals(2, Morph.SUPER_PASTEL.getMutationCount())
        assertEquals(2, Morph.PIED.getMutationCount())
        assertEquals(1, Morph.HET_PIED.getMutationCount())
    }

    @Test
    fun valuesFind() {
        val normal = Morph.values().find { it.mutations == setOf<LociPair>() }
        assertEquals(Morph.NORMAL, normal)
    }
}