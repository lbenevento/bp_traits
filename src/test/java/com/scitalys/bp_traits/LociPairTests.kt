package com.scitalys.bp_traits

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class LociPairTests {

    @Test
    fun equalsTest() {
        val loci1a = LociPair(
            locus1 = Mutation.HET_ULTRAMEL,
            locus2 = null
        )
        val loci1b = LociPair(
            locus1 = null,
            locus2 = Mutation.HET_ULTRAMEL
        )
        assertEquals(loci1a, loci1b)
        val loci2a = LociPair(
            locus1 = Mutation.YELLOW_BELLY,
            locus2 = Mutation.ASPHALT
        )
        val loci2b = LociPair(
            locus1 = Mutation.ASPHALT,
            locus2 = Mutation.YELLOW_BELLY
        )
        assertEquals(loci2a, loci2b)
        val loci3a = LociPair(
            locus1 = Mutation.HET_CLOWN,
            locus2 = Mutation.HET_CLOWN
        )
        val loci3b = LociPair(
            locus1 = Mutation.HET_CLOWN,
            locus2 = Mutation.HET_CLOWN
        )
        assertEquals(loci3a, loci3b)
        assertNotEquals(loci1a, loci2a)
        assertNotEquals(loci1b, loci3b)
        assertNotEquals(loci2a, loci3b)

        val lociSet1 = setOf(
            loci1a, loci2a, loci3b
        )
        val lociSet2 = setOf(
            loci3a, loci2b, loci1a
        )
        val lociSet3 = setOf(
            loci3a, loci2a, setOf(
                LociPair(
                    locus1 = Mutation.HET_GHOST,
                    locus2 = Mutation.SPIDER
                )
            )
        )
        assertEquals(lociSet1, lociSet2)
        assertNotEquals(lociSet1, lociSet3)
    }

}