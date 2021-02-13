package com.scitalys.bp_traits.utils

inline val List<Int>.gcd: Int
    get() {
        var result = this[0]
        for (number in this){
            result = gcd(number, result)
        }
        return result
    }

fun gcd(a: Int, b: Int): Int{
    return if (a == 0) b
    else gcd(b % a, a)
}