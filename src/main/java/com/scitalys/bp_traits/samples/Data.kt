package com.scitalys.bp_traits.samples

import com.scitalys.bp_traits.*

val pairing1 = Pairing.fromParents(
    parent1 = Specimen(
        loci = mutableMapOf(
            LociPair(Mutation.ENCHI) to 1f,
            LociPair(Mutation.PASTEL, Mutation.PASTEL) to 1f
        )
    ),
    parent2 = Specimen(
        loci = mutableMapOf(
            LociPair(Mutation.CYPRESS, Mutation.CYPRESS) to 1f,
            LociPair(Mutation.HET_PIED, Mutation.HET_PIED) to 1f,
            LociPair(Mutation.HET_CLOWN, Mutation.HET_CLOWN) to 1f,
            LociPair(null, Mutation.HET_GHOST) to .5f
        )
    )
)