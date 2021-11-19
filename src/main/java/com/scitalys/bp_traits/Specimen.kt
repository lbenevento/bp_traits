package com.scitalys.bp_traits

data class Specimen(
    private val morphMap: MutableMap<LociPair, Float>
) {

    val morph: MutableMap<LociPair, Float> = mutableMapOf()
    val formattedString: String

    // If the specimen was initialized with an empty map add the NORMAL trait
    // since that's what a specimen with no mutations is.
    init {
        if (morphMap.isEmpty()) {
            morph[LociPair()] = 1f
        } else {
            morph += morphMap
        }

        // Calculate formattedString
        var tmpFormattedString = ""
        morph.toList().forEachIndexed { index, (morph, probability) ->
            if (index != 0) {
                tmpFormattedString += " "
            }
            tmpFormattedString += if (probability != 1f) {
                "%1\$d%% %2\$s".format((probability * 100).toInt(), morph)
            } else {
                morph.toString()
            }
        }
        formattedString = tmpFormattedString

    }

    override fun equals(other: Any?): Boolean {
        if (other !is Specimen) return false
        val thisSortedMap =
            morph.toSortedMap(compareBy<LociPair> { it.locus1?.ordinal }.thenBy { it.locus2?.ordinal })
        val otherSortedMap =
            other.morph.toSortedMap(compareBy<LociPair> { it.locus1?.ordinal }.thenBy { it.locus2?.ordinal })
        if (thisSortedMap == otherSortedMap) return true
        return false
    }

    override fun hashCode(): Int {
        return morph.hashCode()
    }
}

/**
 * This function is used to sort specimen. It returns the number of mutations of that specimen.
 * A homozygous recessive is worth 2, a not 100% het is worth 1 * it's incidence.
 */
inline val Specimen.mutationsCount: Float
    get() {
        var count = 0f
        morph.forEach {
            if (it.key.locus1 != null && it.key.locus2 != null) {
                count += 2
            } else if (it.key.locus1 != null) {
                count++
            } else if (it.key.locus2 != null) {
                count += it.value
            }
        }
        return count
    }

/**
 * Function to know if a specimen can be het for a specified mutation.
 */
fun Specimen.canBeHetFor(mutation: Mutation?): Boolean {
    morph.forEach { (lociPair, incidence) ->
        if (lociPair.locus1 != null && lociPair.locus2 != null) {
            if (
                Trait.fromValue(
                    lociPair.locus1,
                    mutation
                ) != null || Trait.fromValue(lociPair.locus2, mutation) != null
            ) {
                if (incidence == 1f) {
                    return false
                }
            }
        }
    }
    return true
}