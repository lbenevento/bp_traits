package com.scitalys.bp_traits

import org.junit.Assert.assertEquals
import org.junit.Test

class SpecimenTests {

    @Test
    fun geneCount_1() {
        val specimen = Specimen(
            morphMap = mutableMapOf(
                LociPair(Mutation.PASTEL) to 1f,
                LociPair(Mutation.HET_PIED, Mutation.HET_PIED) to 1f,
                LociPair(null, Mutation.HET_ALBINO) to .5f,
                LociPair(null, Mutation.HET_AXANTHIC_JOLLIFF) to 1f
            )
        )
        val geneCount = specimen.mutationsCount
        assertEquals(4.5f, geneCount)
    }

    @Test
    fun geneCount_2() {
        val specimen = Specimen(
            morphMap = mutableMapOf(
                LociPair(Mutation.HET_PIED, Mutation.HET_PIED) to 1f,
                LociPair(Mutation.HET_ALBINO, Mutation.HET_ALBINO) to 1f,
                LociPair(Mutation.FIRE) to 1f
            )
        )
        val geneCount = specimen.mutationsCount
        assertEquals(5f, geneCount)
    }

    @Test
    fun geneCount_3() {
        val specimen = Specimen(
            morphMap = mutableMapOf()
        )
        val geneCount = specimen.mutationsCount
        assertEquals(0f, geneCount)
    }

    @Test
    fun canBeHetFor_1() {
        val specimen = Specimen(
            morphMap = mutableMapOf()
        )
        assertEquals(true, specimen.canBeHetFor(Mutation.HET_ALBINO))
    }

    @Test
    fun canBeHetFor_2() {
        val specimen = Specimen(
            morphMap = mutableMapOf(
                LociPair(Mutation.HET_PIED, Mutation.HET_PIED) to 1f
            )
        )
        assertEquals(false, specimen.canBeHetFor(Mutation.HET_PIED))
        assertEquals(true, specimen.canBeHetFor(Mutation.HET_ALBINO))
    }

    @Test
    fun canBeHetFor_3() {
        val specimen = Specimen(
            morphMap = mutableMapOf(
                LociPair(Mutation.HET_CLOWN, Mutation.HET_CRYPTIC) to 1f
            )
        )
        assertEquals(false, specimen.canBeHetFor(Mutation.HET_CLOWN))
        assertEquals(false, specimen.canBeHetFor(Mutation.HET_CRYPTIC))
        assertEquals(true, specimen.canBeHetFor(Mutation.HET_DESERT_GHOST))
    }

    @Test
    fun nullInit() {
        val specimen = Specimen(
            morphMap = mutableMapOf()
        )
        val expectedSpecimen = Specimen(
            morphMap = mutableMapOf(LociPair() to 1f)
        )
        assertEquals(specimen, expectedSpecimen)
    }

}