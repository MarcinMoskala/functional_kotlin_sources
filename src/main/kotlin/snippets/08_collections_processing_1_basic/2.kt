package f_08_collections_processing_1_basic.s_2

fun main() {
    val old = listOf(1, 2, 6, 11)
    val new = old.filterNot { it in 2..10 }
    println(new) // [1, 11]
}
