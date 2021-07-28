package com.scitalys.bp_traits

data class Specimen(
    val traits: MutableMap<Trait, Float>
) {

    val formattedString: String

    // If the specimen was initialized with an empty map add the NORMAL trait
    // since that's what a specimen with no mutations is.
    init {
        if (traits.isEmpty()) {
            traits[Trait.NORMAL] = 1f
        }

        // Calculate formattedString
        var tmpFormattedString = ""
        traits.toList().forEachIndexed { index, (trait, probability) ->
            if (index != 0) {
                tmpFormattedString += " "
            }
            tmpFormattedString += if (probability != 1f) {
                "%1\$d%% %2\$s".format((probability * 100).toInt(), trait)
            } else {
                trait.formattedString
            }
        }
        formattedString = tmpFormattedString

    }

    override fun equals(other: Any?): Boolean {
        if (other !is Specimen) return false
        val thisSortedMap = traits.toSortedMap(compareBy { it.ordinal })
        val otherSortedMap = other.traits.toSortedMap(compareBy { it.ordinal })
        if (thisSortedMap == otherSortedMap) return true
        return false
    }

    override fun hashCode(): Int {
        return traits.hashCode()
    }
}

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