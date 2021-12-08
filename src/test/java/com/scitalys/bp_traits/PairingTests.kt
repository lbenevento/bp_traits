package com.scitalys.bp_traits

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class PairingTests {

    @Test
    fun pairing1() {

        val male = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.ENCHI) to 1f,
                LociPair(null, Mutation.HET_PIED) to 1f
            )
        )
        val female = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.PASTEL) to 1f,
                LociPair(Mutation.ENCHI) to 1f
            )
        )

        val calculatedPairing = Pairing.fromParents(parent1 = male, parent2 = female)
        val correctPairing = Pairing(
            male = male,
            female = female,
            offspringMap = sortedMapOf(
                compareBy({ it.mutationsCount }, { it.formattedString }),
                // 1
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.PASTEL) to 1f,
                        LociPair(Mutation.ENCHI, Mutation.ENCHI) to 1f,
                        LociPair(null, Mutation.HET_PIED) to .5f
                    )
                ) to 1,
                // 2
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.PASTEL) to 1f,
                        LociPair(Mutation.ENCHI) to 1f,
                        LociPair(null, Mutation.HET_PIED) to .5f
                    )
                ) to 2,
                // 3
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.ENCHI, Mutation.ENCHI) to 1f,
                        LociPair(null, Mutation.HET_PIED) to .5f
                    )
                ) to 1,
                // 4
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.ENCHI) to 1f,
                        LociPair(null, Mutation.HET_PIED) to .5f
                    )
                ) to 2,
                // 5
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.PASTEL) to 1f,
                        LociPair(null, Mutation.HET_PIED) to .5f
                    )
                ) to 1,
                // 6
                Specimen(
                    loci = mutableMapOf(
                        LociPair(null, Mutation.HET_PIED) to .5f
                    )
                ) to 1,
            )
        )

        assertEquals(correctPairing, calculatedPairing)
    }

    @Test
    fun pairing2() {

        val male = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.PASTEL) to 1f,
                LociPair(null, Mutation.HET_CRYPTIC) to 1f
            )
        )
        val female = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.ENCHI, Mutation.ENCHI) to 1f,
                LociPair(null, Mutation.HET_CLOWN) to 1f
            )
        )

        val calculatedPairing = Pairing.fromParents(parent1 = male, parent2 = female)
        val correctPairing = Pairing(
            male = male,
            female = female,
            offspringMap = sortedMapOf(
                compareByDescending<Specimen>
                { it.mutationsCount }.thenBy { it.formattedString },
                // 1
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.PASTEL) to 1f,
                        LociPair(Mutation.ENCHI) to 1f,
                        LociPair(Mutation.HET_CRYPTIC, Mutation.HET_CLOWN) to 1f
                    )
                ) to 1,
                // 2
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.ENCHI) to 1f,
                        LociPair(Mutation.HET_CLOWN, Mutation.HET_CRYPTIC) to 1f
                    )
                ) to 1,
                // 3
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.PASTEL) to 1f,
                        LociPair(Mutation.ENCHI) to 1f,
                        LociPair(null, Mutation.HET_CLOWN) to .33333334f,
                        LociPair(null, Mutation.HET_CRYPTIC) to .33333334f
                    )
                ) to 3,
                // 4
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.ENCHI) to 1f,
                        LociPair(null, Mutation.HET_CLOWN) to .33333334f,
                        LociPair(null, Mutation.HET_CRYPTIC) to .33333334f
                    )
                ) to 3,
            )
        )

        assertEquals(correctPairing, calculatedPairing)
    }

    @Test
    fun pairing3() {

        val male = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.PASTEL) to 1f
            )
        )
        val female = Specimen(
            loci = mutableMapOf(
                LociPair(Mutation.ENCHI) to 1f,
                LociPair(Mutation.HET_CLOWN, Mutation.HET_CRYPTIC) to 1f
            )
        )

        val calculatedPairing = Pairing.fromParents(parent1 = male, parent2 = female)
        val correctPairing = Pairing(
            male = male,
            female = female,
            offspringMap = sortedMapOf(
                compareBy({ it.mutationsCount }, { it.formattedString }),
                // 1
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.PASTEL) to 1f,
                        LociPair(Mutation.ENCHI) to 1f,
                        LociPair(null, Mutation.HET_CLOWN) to .5f,
                        LociPair(null, Mutation.HET_CRYPTIC) to .5f
                    )
                ) to 1,
                // 2
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.ENCHI) to 1f,
                        LociPair(null, Mutation.HET_CLOWN) to .5f,
                        LociPair(null, Mutation.HET_CRYPTIC) to .5f
                    )
                ) to 1,
                // 3
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.PASTEL) to 1f,
                        LociPair(null, Mutation.HET_CLOWN) to .5f,
                        LociPair(null, Mutation.HET_CRYPTIC) to .5f
                    )
                ) to 1,
                // 4
                Specimen(
                    loci = mutableMapOf(
                        LociPair(null, Mutation.HET_CLOWN) to .5f,
                        LociPair(null, Mutation.HET_CRYPTIC) to .5f
                    )
                ) to 1
            )
        )

        assertEquals(correctPairing, calculatedPairing)
    }

    @Test
    fun equalsAndHashCode() {
        val pairing1 = Pairing.fromParents(
            parent1 = Specimen(
                loci = mutableMapOf(
                    LociPair(Mutation.ENCHI) to 1f,
                    LociPair(Mutation.PASTEL) to 1f
                )
            ),
            parent2 = Specimen(
                loci = mutableMapOf(
                    LociPair(Mutation.PASTEL, Mutation.PASTEL) to 1f,
                    LociPair(null, Mutation.HET_GHOST) to 1f
                )
            )
        )
        val pairing2 = Pairing(
            male = Specimen(
                loci = mutableMapOf(
                    LociPair(Mutation.PASTEL) to 1f,
                    LociPair(Mutation.ENCHI) to 1f
                )
            ),
            female = Specimen(
                loci = mutableMapOf(
                    LociPair(Mutation.PASTEL, Mutation.PASTEL) to 1f,
                    LociPair(null, Mutation.HET_GHOST) to 1f
                )
            ),
            offspringMap = sortedMapOf(
                compareBy(
                    { it.mutationsCount },
                    { it.formattedString }
                ),
                // 1
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.PASTEL, Mutation.PASTEL) to 1f,
                        LociPair(Mutation.ENCHI) to 1f,
                        LociPair(null, Mutation.HET_GHOST) to .5f
                    )
                ) to 1,
                // 2
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.ENCHI) to 1f,
                        LociPair(Mutation.PASTEL) to 1f,
                        LociPair(null, Mutation.HET_GHOST) to .5f
                    )
                ) to 1,
                // 3
                Specimen(
                    loci = mutableMapOf(
                        LociPair(null, Mutation.HET_GHOST) to .5f,
                        LociPair(Mutation.PASTEL) to 1f
                    )
                ) to 1,
                // 4
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.PASTEL, Mutation.PASTEL) to 1f,
                        LociPair(null, Mutation.HET_GHOST) to .5f
                    )
                ) to 1,
            )
        )

        val pairing3 = Pairing.fromParents(
            parent1 = Specimen(
                loci = mutableMapOf(
                    LociPair(Mutation.PASTEL) to 1f,
                    LociPair(Mutation.ENCHI) to 1f
                )
            ),
            parent2 = Specimen(
                loci = mutableMapOf(
                    LociPair(Mutation.PASTEL, Mutation.PASTEL) to 1f,
                    LociPair(Mutation.HET_GHOST, Mutation.HET_GHOST) to 1f
                )
            )
        )

        val pairing4 = Pairing(
            male = Specimen(
                loci = mutableMapOf(
                    LociPair(Mutation.PASTEL) to 1f,
                    LociPair(Mutation.ENCHI) to 1f
                )
            ),
            female = Specimen(
                loci = mutableMapOf(
                    LociPair(Mutation.PASTEL, Mutation.PASTEL) to 1f,
                    LociPair(null, Mutation.HET_GHOST) to 1f
                )
            ),
            offspringMap = sortedMapOf(
                compareBy(
                    { it.mutationsCount },
                    { it.formattedString }
                ),
                // 1
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.PASTEL, Mutation.PASTEL) to 1f,
                        LociPair(Mutation.ENCHI) to 1f
                    )
                ) to 1,
                // 2
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.ENCHI) to 1f,
                        LociPair(Mutation.PASTEL) to 1f,
                        LociPair(null, Mutation.HET_GHOST) to .5f
                    )
                ) to 1,
                // 3
                Specimen(
                    loci = mutableMapOf(
                        LociPair(null, Mutation.HET_GHOST) to .5f,
                        LociPair(Mutation.PASTEL) to 1f
                    )
                ) to 1,
                // 4
                Specimen(
                    loci = mutableMapOf(
                        LociPair(Mutation.PASTEL, Mutation.PASTEL) to 1f,
                        LociPair(null, Mutation.HET_GHOST) to .5f
                    )
                ) to 1,
            )
        )

        // Test equals results
        assertEquals(pairing1, pairing2)
        assertNotEquals(pairing1, null)
        assertNotEquals(pairing2, pairing3)
        assertNotEquals(pairing1, pairing4)
        assertNotEquals(pairing2, pairing4)
        assertNotEquals(pairing3, pairing4)

        // Test hashCode results
        assertEquals(pairing1.hashCode(), pairing2.hashCode())
        assertNotEquals(pairing1.hashCode(), pairing3.hashCode())
        assertNotEquals(pairing2.hashCode(), pairing3.hashCode())
        assertNotEquals(pairing1.hashCode(), pairing4.hashCode())
        assertNotEquals(pairing2.hashCode(), pairing4.hashCode())
        assertNotEquals(pairing3.hashCode(), pairing4.hashCode())
    }

}