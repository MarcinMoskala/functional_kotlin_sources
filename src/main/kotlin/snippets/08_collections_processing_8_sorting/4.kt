package f_08_collections_processing_8_sorting.s_4

fun main() {
    val names = listOf("Alex", "Bob", "Celine")

    // Sort by name length
    println(names.sortedBy { it.length })
    // [Bob, Alex, Celine]

    // Sort by last letter
    println(names.sortedBy { it.last() })
    // [Bob, Celine, Alex]
}
