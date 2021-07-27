package com.scitalys.bp_traits

import org.junit.Assert.assertEquals
import org.junit.Test

class SpecimenTests {

    @Test
    fun geneCount_1() {
        val specimen = Specimen(
            traits = mutableMapOf(
                Trait.PASTEL to 1f,
                Trait.PIED to 1f,
                Trait.HET_ALBINO to .5f,
                Trait.HET_AXANTHIC_JOLLIFF to 1f
            )
        )
        val geneCount = specimen.geneCount
        assertEquals(4.5f, geneCount)
    }

    @Test
    fun geneCount_2() {
        val specimen = Specimen(
            traits = mutableMapOf(
                Trait.PIED to 1f,
                Trait.ALBINO to 1f,
                Trait.FIRE to 1f
            )
        )
        val geneCount = specimen.geneCount
        assertEquals(5f, geneCount)
    }

    @Test
    fun geneCount_3() {
        val specimen = Specimen(
            traits = mutableMapOf()
        )
        val geneCount = specimen.geneCount
        assertEquals(0f, geneCount)
    }

    @Test
    fun canBeHetFor_1() {
        val specimen = Specimen(
            traits = mutableMapOf()
        )
        assertEquals(true, specimen.canBeHetFor(Mutation.HET_ALBINO))
    }

    @Test
    fun canBeHetFor_2() {
        val specimen = Specimen(
            traits = mutableMapOf(
                Trait.PIED to 1f
            )
        )
        assertEquals(false, specimen.canBeHetFor(Mutation.HET_PIED))
        assertEquals(true, specimen.canBeHetFor(Mutation.HET_ALBINO))
    }

    @Test
    fun canBeHetFor_3() {
        val specimen = Specimen(
            traits = mutableMapOf(
                Trait.CRYPTON to 1f
            )
        )
        assertEquals(false, specimen.canBeHetFor(Mutation.HET_CLOWN))
        assertEquals(false, specimen.canBeHetFor(Mutation.HET_CRYPTIC))
        assertEquals(true, specimen.canBeHetFor(Mutation.HET_DESERT_GHOST))
    }

    @Test
    fun nullInit() {
        val specimen = Specimen(
            traits = mutableMapOf()
        )
        val expectedSpecimen = Specimen(
            traits = mutableMapOf(Trait.NORMAL to 1f)
        )
        assertEquals(specimen, expectedSpecimen)
    }

}