package com.scitalys.bp_traits.samples

import com.scitalys.bp_traits.Pairing
import com.scitalys.bp_traits.Specimen
import com.scitalys.bp_traits.Trait

val pairing1 = Pairing.fromParents(
    parent1 = Specimen(
        traits = mutableMapOf(
            Pair(Trait.ENCHI, 1f),
            Pair(Trait.SUPER_PASTEL, 1f)
        )
    ),
    parent2 = Specimen(
        traits = mutableMapOf(
            Pair(Trait.SUPER_CYPRESS, 1f),
            Pair(Trait.PIED, 1f),
            Pair(Trait.CLOWN, 1f),
            Pair(Trait.HET_GHOST, 0.5f)
        )
    )
)