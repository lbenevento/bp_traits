package com.scitalys.bp_traits

import android.util.Log
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class PunnetSquareTests {

    @Test
    fun calculate1() {

        val male = listOf(
            Trait.PASTEL,
            Trait.ENCHI
        )
        val female = listOf(
            Trait.ENCHI,
            Trait.HET_PIED
        )

        val calculatedList = PunnettSquare.calculate(male, female)
        val correctList = listOf(
            // 1
            listOf(
                Mutation.PASTEL,
                Mutation.ENCHI,
                Mutation.ENCHI,
                Mutation.HET_PIED
            ),
            // 2
            listOf(
                Mutation.PASTEL,
                Mutation.ENCHI,
                Mutation.HET_PIED
            ),
            // 3
            listOf(
                Mutation.PASTEL,
                Mutation.ENCHI,
                Mutation.ENCHI
            ),
            // 4
            listOf(
                Mutation.PASTEL,
                Mutation.ENCHI
            ),


            // 5
            listOf(
                Mutation.PASTEL,
                Mutation.ENCHI,
                Mutation.HET_PIED
            ),
            // 6
            listOf(
                Mutation.PASTEL,
                Mutation.HET_PIED
            ),
            // 7
            listOf(
                Mutation.PASTEL,
                Mutation.ENCHI
            ),
            // 8
            listOf(
                Mutation.PASTEL
            ),


            // 9
            listOf(
                Mutation.ENCHI,
                Mutation.ENCHI,
                Mutation.HET_PIED
            ),
            // 10
            listOf(
                Mutation.ENCHI,
                Mutation.HET_PIED
            ),
            // 11
            listOf(
                Mutation.ENCHI,
                Mutation.ENCHI
            ),
            // 12
            listOf(
                Mutation.ENCHI
            ),


            // 13
            listOf(
                Mutation.ENCHI,
                Mutation.HET_PIED
            ),
            // 14
            listOf(
                Mutation.HET_PIED
            ),
            // 15
            listOf(
                Mutation.ENCHI
            ),
            // 16
            listOf(
            ),
        )


        assertEquals(
            calculatedList.map { it.filterNotNull().sortedBy { it.name } }
                .sortedWith(compareBy({ it.size }, { it[0].name }, { it.getOrNull(1)?.name })),
            correctList.map { it.sortedBy { it.name } }
                .sortedWith(compareBy({ it.size }, { it[0].name }, { it.getOrNull(1)?.name }))
        )

    }

    @Test
    fun calculate2() {

        val male = listOf(
            Trait.PASTEL,
            Trait.HET_CRYPTIC
        )
        val female = listOf(
            Trait.SUPER_ENCHI,
            Trait.HET_CLOWN
        )

        val calculatedList = PunnettSquare.calculate(male, female)
        val correctList = listOf(
            // 1
            listOf(
                Mutation.PASTEL,
                Mutation.ENCHI,
                Mutation.HET_CRYPTIC
            ),
            // 2
            listOf(
                Mutation.PASTEL,
                Mutation.ENCHI
            ),
            // 3
            listOf(
                Mutation.ENCHI,
                Mutation.HET_CRYPTIC
            ),
            // 4
            listOf(
                Mutation.ENCHI
            ),


            // 5
            listOf(
                Mutation.PASTEL,
                Mutation.ENCHI,
                Mutation.HET_CRYPTIC,
                Mutation.HET_CLOWN
            ),
            // 6
            listOf(
                Mutation.PASTEL,
                Mutation.ENCHI,
                Mutation.HET_CLOWN
            ),
            // 7
            listOf(
                Mutation.ENCHI,
                Mutation.HET_CRYPTIC,
                Mutation.HET_CLOWN
            ),
            // 8
            listOf(
                Mutation.ENCHI,
                Mutation.HET_CLOWN
            ),
        )


        assertEquals(
            calculatedList.map { it.filterNotNull().sortedBy { it.name } }
                .sortedWith(compareBy({ it.size }, { it[0].name }, { it.getOrNull(1)?.name })),
            correctList.map { it.sortedBy { it.name } }
                .sortedWith(compareBy({ it.size }, { it[0].name }, { it.getOrNull(1)?.name }))
        )
    }

}