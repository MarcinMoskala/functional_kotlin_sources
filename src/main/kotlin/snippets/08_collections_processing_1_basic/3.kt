package f_08_collections_processing_1_basic.s_3

fun main() {
    val old = listOf(1, 2, 3, 4)
    val new = old.map { it * it }
    println(new) // [1, 4, 9, 16]
}
