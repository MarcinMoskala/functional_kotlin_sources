package f_08_collections_processing_7_associating.s_4

fun main() {
    val list: List<Int> = listOf(1, 2, 4, 2, 3, 1)
    val set: Set<Int> = list.toSet()
    println(set) // [1, 2, 4, 3]
}
