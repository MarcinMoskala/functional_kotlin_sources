package f_08_collections_processing_8_sorting.s_6

fun main() {
    val names = listOf("Alex", "Bob", "Celine")

    // Sort by name length
    println(names.sortedByDescending { it.length })
    // [Celine, Alex, Bob]

    // Sort by last letter
    println(names.sortedByDescending { it.last() })
    // [Alex, Celine, Bob]
}
