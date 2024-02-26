package f_08_collections_processing_8_sorting.s_5

fun main() {
    val names = listOf("Ben", "Bob", "Bass", "Alex")
    val sorted = names.sortedBy { it.first() }
    println(sorted) // [Alex, Ben, Bob, Bass]
}
