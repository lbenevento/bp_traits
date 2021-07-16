package com.scitalys.bp_traits

data class Specimen(
    var traits: MutableMap<Trait, Float>
)

/**
 * This function is used to sort specimen. It returns the number of mutations of that specimen.
 * A homozygous recessive is worth 2, a not 100% het is worth 1 * it's incidence.
 */
inline val Specimen.geneCount: Float
    get() {

        var count = 0f
        traits.forEach {

            val hasFirstGene = it.key.geneLG1 != null
            val hasSecondGene = it.key.geneLG2 != null

            // Super / Visual Recessive
            if (hasFirstGene && hasSecondGene) {
                count += 2f
            }
            // Codom
            else if (hasFirstGene && !hasSecondGene) {
                count += 1f
            }
            // Het
            else if (!hasFirstGene && hasSecondGene) {
                count += 1f * it.value
            }
        }
        return count
    }

/**
 * Function to know if a speciment can be het for a specified mutation.
 */
fun Specimen.canBeHetFor(mutation: Mutation?): Boolean {
    this.traits.forEach { (trait, incidence) ->
        if (trait.geneLG1 != null && trait.geneLG2 != null){
            if (
                Trait.fromValue(trait.geneLG1, mutation) != null || Trait.fromValue(trait.geneLG2, mutation) != null
            ) {
                if (incidence == 1f) {
                    return false
                }
            }
        }
    }
    return true
}