package f_08_collections_processing_8_sorting.s_1

fun main() {
    println(listOf(4, 1, 3, 2).sorted())
    // [1, 2, 3, 4]

    println(listOf('b', 'A', 'a', ' ', 'B').sorted())
    // [ , A, B, a, b]

    println(listOf("Bab", "AAZ", "Bza", "A").sorted())
    // [A, AAZ, Bab, Bza]

    println(listOf(true, false, true).sorted())
    // [false, true, true]
}
