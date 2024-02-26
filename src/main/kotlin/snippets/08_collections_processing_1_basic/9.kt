package f_08_collections_processing_1_basic.s_9

fun main() {
    val old = listOf("1", "A", "2", "3", "B", "4")
    println(old.mapNotNull { it.toIntOrNull() })
    // [1, 2, 3, 4]

    val numbers = listOf(-1, 2, -3, 4)
    println(numbers.mapNotNull { prod(it) })
    // [2, 24]
    println(numbers.mapNotNull { if (it > 0) it else null })
    // [2, 4]
}

fun prod(num: Int): Int? {
    if (num <= 0) return null
    // Can be simplified with fold, that we will learn later
    var res = 1
    for (i in 1..num) {
        res *= i
    }
    return res
}
