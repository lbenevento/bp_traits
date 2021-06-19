package com.scitalys.bp_traits

import com.scitalys.bp_traits.models.PunnettSquare
import com.scitalys.bp_traits.models.Speciment
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

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

    @Test
    fun pairing() {
        val male = setOf(Trait.SUPER_PASTEL, Trait.PIED)
        val female = setOf(Trait.ALBINO, Trait.HET_PIED)
        val pairing = PunnettSquare().calculate(male, female)

        assertEquals(
            2,
            pairing.totalPossibilities
        )
        assertEquals(
            listOf(
                Speciment(
                    mutableMapOf(
                        Trait.PASTEL to 1f,
                        Trait.PIED to 1f,
                        Trait.HET_ALBINO to 1f
                    ),
                    1
                ),
                Speciment(
                    mutableMapOf(
                        Trait.PASTEL to 1f,
                        Trait.HET_ALBINO to 1f,
                        Trait.HET_PIED to 1f
                    ),
                    1
                )
            ),
            pairing.offspringList
        )
        assertEquals(
            Speciment(
                traits = mutableMapOf(Trait.SUPER_PASTEL to 1f, Trait.PIED to 1f),
                1
            ),
            pairing.male
        )
        assertEquals(
            Speciment(
                traits = mutableMapOf(Trait.ALBINO to 1f, Trait.HET_PIED to 1f),
                1
            ),
            pairing.female
        )
    }
}