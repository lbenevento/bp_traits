package com.scitalys.bp_traits

enum class Description(
    val description: String,
    val author: String
) {
    /**
     * Codominant
     */
    ENCHI("Patter and colour mutation. Enchis have usually cleaner pattern and orange to yellow colour.", "Scitalys"),
    GHI("GHIs have clear belly, a lot of speckling and are usually darker than normals.", "Scitalys"),
    PASTEL("Intensifies the yellow pigmentation. Pastels have white lips and a lot of blushing.", "Scitalys"),

    /**
     * Dominant
     */

    /**
     * Recessives
     */
}