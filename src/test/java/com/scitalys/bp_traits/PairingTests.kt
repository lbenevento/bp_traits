package com.scitalys.bp_traits

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class PairingTests {

    @Test
    fun pairing1() {

        val male = Specimen(
            traits = mutableMapOf(
                Pair(Trait.ENCHI, 1f),
                Pair(Trait.HET_PIED, 1f),
            )
        )
        val female = Specimen(
            traits = mutableMapOf(
                Pair(Trait.PASTEL, 1f),
                Pair(Trait.ENCHI, 1f),
            )
        )

        val calculatedPairing = Pairing.fromParents(parent1 = male, parent2 = female)
        val correctPairing = Pairing(
            male = male,
            female = female,
            offspringMap = mutableMapOf(
                // 1
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.PASTEL, 1f),
                        Pair(Trait.SUPER_ENCHI, 1f),
                        Pair(Trait.HET_PIED, .5f)
                    )
                ) to 1,
                // 2
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.PASTEL, 1f),
                        Pair(Trait.ENCHI, 1f),
                        Pair(Trait.HET_PIED, .5f)
                    )
                ) to 2,
                // 3
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.PASTEL, 1f),
                        Pair(Trait.HET_PIED, .5f)
                    )
                ) to 1,
                // 4
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.SUPER_ENCHI, 1f),
                        Pair(Trait.HET_PIED, .5f)
                    )
                ) to 1,
                // 5
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.ENCHI, 1f),
                        Pair(Trait.HET_PIED, .5f)
                    )
                ) to 2,
                // 6
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.HET_PIED, .5f)
                    )
                ) to 1,
            )
        )

        assertEquals(correctPairing.male, calculatedPairing.male)
        assertEquals(correctPairing.female, calculatedPairing.female)
        assertEquals(correctPairing.offspringMap, calculatedPairing.offspringMap)
        assertEquals(8, calculatedPairing.totalPossibilities)
    }

    @Test
    fun pairing2() {

        val male = Specimen(
            traits = mutableMapOf(
                Pair(Trait.PASTEL, 1f),
                Pair(Trait.HET_CRYPTIC, 1f),
            )
        )
        val female = Specimen(
            traits = mutableMapOf(
                Pair(Trait.SUPER_ENCHI, 1f),
                Pair(Trait.HET_CLOWN, 1f),
            )
        )

        val calculatedPairing = Pairing.fromParents(parent1 = male, parent2 = female)
        val correctPairing = Pairing(
            male = male,
            female = female,
            offspringMap = mutableMapOf(
                // 1
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.PASTEL, 1f),
                        Pair(Trait.ENCHI, 1f),
                        Pair(Trait.HET_CLOWN, .33333334f),
                        Pair(Trait.HET_CRYPTIC, .33333334f)
                    )
                ) to 3,
                // 2
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.ENCHI, 1f),
                        Pair(Trait.HET_CLOWN, .33333334f),
                        Pair(Trait.HET_CRYPTIC, .33333334f)
                    )
                ) to 3,
                // 3
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.PASTEL, 1f),
                        Pair(Trait.ENCHI, 1f),
                        Pair(Trait.CRYPTON, 1f)
                    )
                ) to 1,
                // 4
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.ENCHI, 1f),
                        Pair(Trait.CRYPTON, 1f)
                    )
                ) to 1
            )
        )

        assertEquals(correctPairing.male, calculatedPairing.male)
        assertEquals(correctPairing.female, calculatedPairing.female)
        assertEquals(correctPairing.offspringMap, calculatedPairing.offspringMap)
        assertEquals(8, calculatedPairing.totalPossibilities)
    }

    @Test
    fun pairing3() {

        val male = Specimen(
            traits = mutableMapOf(
                Pair(Trait.PASTEL, 1f),
            )
        )
        val female = Specimen(
            traits = mutableMapOf(
                Pair(Trait.ENCHI, 1f),
                Pair(Trait.CRYPTON, 1f),
            )
        )

        val calculatedPairing = Pairing.fromParents(parent1 = male, parent2 = female)
        val correctPairing = Pairing(
            male = male,
            female = female,
            offspringMap = mutableMapOf(
                // 1
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.PASTEL, 1f),
                        Pair(Trait.ENCHI, 1f),
                        Pair(Trait.HET_CLOWN, .5f),
                        Pair(Trait.HET_CRYPTIC, .5f)
                    )
                ) to 1,
                // 2
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.ENCHI, 1f),
                        Pair(Trait.HET_CLOWN, .5f),
                        Pair(Trait.HET_CRYPTIC, .5f)
                    )
                ) to 1,
                // 3
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.PASTEL, 1f),
                        Pair(Trait.HET_CLOWN, .5f),
                        Pair(Trait.HET_CRYPTIC, .5f)
                    )
                ) to 1,
                // 4
                Specimen(
                    traits = mutableMapOf(
                        Pair(Trait.HET_CLOWN, .5f),
                        Pair(Trait.HET_CRYPTIC, .5f)
                    )
                ) to 1
            )
        )

        assertEquals(correctPairing.male, calculatedPairing.male)
        assertEquals(correctPairing.female, calculatedPairing.female)
        assertEquals(correctPairing.offspringMap, calculatedPairing.offspringMap)
        assertEquals(4, calculatedPairing.totalPossibilities)
    }

    @Test
    fun equalsAndHashCode() {
        val pairing1 = Pairing.fromParents(
            parent1 = Specimen(
                traits = mutableMapOf(
                    Trait.ENCHI to 1f,
                    Trait.PASTEL to 1f
                )
            ),
            parent2 = Specimen(
                traits = mutableMapOf(
                    Trait.SUPER_PASTEL to 1f,
                    Trait.HET_GHOST to 1f
                )
            )
        )
        val pairing2 = Pairing(
            male = Specimen(
                traits = mutableMapOf(
                    Trait.PASTEL to 1f,
                    Trait.ENCHI to 1f,
                )
            ),
            female = Specimen(
                traits = mutableMapOf(
                    Trait.SUPER_PASTEL to 1f,
                    Trait.HET_GHOST to 1f
                )
            ),
            offspringMap = mutableMapOf(
                Specimen(
                    traits = mutableMapOf(Trait.HET_GHOST to .5f, Trait.PASTEL to 1f)
                ) to 1,
                Specimen(
                    traits = mutableMapOf(Trait.ENCHI to 1f, Trait.PASTEL to 1f, Trait.HET_GHOST to .5f)
                ) to 1,
                Specimen(
                    traits = mutableMapOf(Trait.SUPER_PASTEL to 1f, Trait.ENCHI to 1f, Trait.HET_GHOST to .5f)
                ) to 1,
                Specimen(
                    traits = mutableMapOf(Trait.SUPER_PASTEL to 1f, Trait.HET_GHOST to .5f)
                ) to 1
            )
        )

        val pairing3 = Pairing.fromParents(
            parent1 = Specimen(
                traits = mutableMapOf(
                    Trait.PASTEL to 1f,
                    Trait.ENCHI to 1f
                )
            ),
            parent2 = Specimen(
                traits = mutableMapOf(
                    Trait.SUPER_PASTEL to 1f,
                    Trait.GHOST to 1f
                )
            )
        )

        // Test equals results
        assertEquals(pairing1, pairing2)
        assertNotEquals(pairing1, null)
        assertNotEquals(pairing2, pairing3)

        // Test hashCode results
        assertEquals(pairing1.hashCode(), pairing2.hashCode())
        assertNotEquals(pairing1.hashCode(), pairing3.hashCode())
        assertNotEquals(pairing2.hashCode(), pairing3.hashCode())
    }

}