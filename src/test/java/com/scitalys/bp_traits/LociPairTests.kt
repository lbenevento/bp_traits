package com.scitalys.bp_traits

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class LociPairTests {

    @Test
    fun equalsTest() {
        val loci1a = LociPair(
            l1 = Mutation.HET_ULTRAMEL,
            l2 = null
        )
        val loci1b = LociPair(
            l1 = null,
            l2 = Mutation.HET_ULTRAMEL
        )
        assertNotEquals(loci1a, loci1b)
        val loci2a = LociPair(
            l1 = Mutation.YELLOW_BELLY,
            l2 = Mutation.ASPHALT
        )
        val loci2b = LociPair(
            l1 = Mutation.ASPHALT,
            l2 = Mutation.YELLOW_BELLY
        )
        assertEquals(loci2a, loci2b)
        val loci3a = LociPair(
            l1 = Mutation.HET_CLOWN,
            l2 = Mutation.HET_CLOWN
        )
        val loci3b = LociPair(
            l1 = Mutation.HET_CLOWN,
            l2 = Mutation.HET_CLOWN
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
                    l1 = Mutation.HET_GHOST,
                    l2 = Mutation.SPIDER
                )
            )
        )
        assertEquals(lociSet1, lociSet2)
        assertNotEquals(lociSet1, lociSet3)
    }

}