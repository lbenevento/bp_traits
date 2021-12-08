package com.scitalys.bp_traits

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class SpecimenTests {

    @Test
    fun geneCount_1() {
        val specimen = Specimen(
            loci = mutableMapOf(
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
            loci = mutableMapOf(
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
            loci = mutableMapOf()
        )
        val geneCount = specimen.mutationsCount
        assertEquals(0f, geneCount)
    }

    @Test
    fun canBeHetFor_1() {
        val specimen = Specimen(
            loci = mutableMapOf()
        )
        assertEquals(true, specimen.canBeHetFor(Mutation.HET_ALBINO))
    }

    @Test
    fun canBeHetFor_2() {
        val specimen = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.HET_PIED, Mutation.HET_PIED) to 1f
            )
        )
        assertEquals(false, specimen.canBeHetFor(Mutation.HET_PIED))
        assertEquals(true, specimen.canBeHetFor(Mutation.HET_ALBINO))
    }

    @Test
    fun canBeHetFor_3() {
        val specimen = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.HET_CLOWN, Mutation.HET_CRYPTIC) to 1f
            )
        )
        assertEquals(false, specimen.canBeHetFor(Mutation.HET_CLOWN))
        assertEquals(false, specimen.canBeHetFor(Mutation.HET_CRYPTIC))
        assertEquals(true, specimen.canBeHetFor(Mutation.HET_DESERT_GHOST))
    }

    @Test
    fun init() {
        val specimen1 = Specimen(
            loci = mutableMapOf()
        )
        val loci2 = mutableMapOf(
            LociPair(Mutation.PASTEL) to 1f,
            LociPair(Mutation.ENCHI) to 1f,
            LociPair(null, Mutation.HET_GHOST) to 1f,
            LociPair(null, Mutation.HET_CLOWN) to 1f
        )
        val specimen2 = Specimen(
            loci = loci2
        )
        assertEquals(specimen1.loci, mutableMapOf<LociPair, Float>())
        assertEquals(specimen2.loci, loci2)
    }

    @Test
    fun equals() {
        val specimen1a = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.ENCHI, Mutation.ENCHI) to 1f,
                LociPair(null, Mutation.HET_PIED) to 1f
            )
        )
        val specimen1b = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.ENCHI, Mutation.ENCHI) to 1f,
                LociPair(null, Mutation.HET_PIED) to 1f
            )
        )
        val specimen2a = Specimen(
            loci = mutableMapOf(
                LociPair(null, Mutation.HET_PIED) to .3f
            )
        )
        val specimen2b = Specimen(
            loci = mutableMapOf(
                LociPair(null, Mutation.HET_PIED) to .34f
            )
        )
        val specimen3a = Specimen(
            loci = mutableMapOf()
        )
        val specimen3b = Specimen(
            loci = mutableMapOf(
                LociPair() to 1f
            )
        )
        val specimen3c = Specimen(
            loci = mutableMapOf(
                LociPair(null, null) to 1f
            )
        )
        val specimen4a = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.ENCHI) to 1f,
                LociPair(null, Mutation.HET_CLOWN) to 1f
            )
        )
        val specimen4b = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.ENCHI) to 1f
            )
        )
        assertEquals(specimen1a, specimen1b)
        assertNotEquals(specimen2a, specimen2b)
        assertEquals(specimen3a, specimen3b)
        assertEquals(specimen3b, specimen3c)
        assertNotEquals(specimen4a, specimen4b)
    }

}