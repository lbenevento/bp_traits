package com.scitalys.bp_traits

data class Specimen(
    var traits: MutableMap<Trait, Float>,
    var incidence: Int
) {

    fun getGeneCount(): Float {
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

}