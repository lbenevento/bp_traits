package com.scitalys.bp_traits

import org.junit.Assert.assertEquals
import org.junit.Test

class PairingExtensionsTests {

    @Test
    fun toLociPairSetTest() {
        val list1: List<Mutation?> = listOf(Mutation.ENCHI, Mutation.FIRE)
        val expected1 = setOf(
            LociPair(Mutation.ENCHI),
            LociPair(Mutation.FIRE)
        )
        assertEquals(
            expected1,
            list1.toLociPairSet()
        )
        val list2: List<Mutation?> = listOf(null)
        val expected2 = setOf<LociPair>()
        assertEquals(
            expected2,
            list2.toLociPairSet()
        )
    }
}