package com.scitalys.bp_traits

data class Specimen(
    val loci: Map<LociPair, Float>
) {

    val formattedString: String

    // If the specimen was initialized with an empty map add the NORMAL trait
    // since that's what a specimen with no mutations is.
    init {

        // Calculate formattedString
        var tmpFormattedString = ""
        loci.toList().forEachIndexed { index, (morph, probability) ->
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

        if (other.loci.isEmpty()) {
            if (this.loci.isEmpty()) return true
            if (this.loci == mutableMapOf(LociPair() to 1f)) return true
        }
        if (this.loci.isEmpty()) {
            if (other.loci.isEmpty()) return true
            if (other.loci == mutableMapOf(LociPair() to 1f)) return true
        }

        val thisSortedMap = this.loci.toSortedMap(
            compareBy<LociPair> { it.locus1?.ordinal }.thenBy { it.locus2?.ordinal }
        )
        val otherSortedMap = other.loci.toSortedMap(
            compareBy<LociPair> { it.locus1?.ordinal }.thenBy { it.locus2?.ordinal }
        )
        if (thisSortedMap == otherSortedMap) return true
        return false
    }

    override fun hashCode(): Int {
        return loci.hashCode()
    }
}

/**
 * This function is used to sort specimen. It returns the number of mutations of that specimen.
 * A homozygous recessive is worth 2, a not 100% het is worth 1 * it's incidence.
 */
inline val Specimen.mutationsCount: Float
    get() {
        var count = 0f
        loci.forEach {
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
    loci.forEach { (lociPair, incidence) ->
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