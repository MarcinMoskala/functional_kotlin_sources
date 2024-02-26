package f_08_collections_processing_3_index.s_1

fun main() {
    listOf("A", "B", "C", "D") // List<String>
        .withIndex() // List<IndexedValue<String>>
        .filter { (index, value) -> index % 2 == 0 }
        .map { (index, value) -> "[$index] $value" }
        .forEach { println(it) }
}
// [0] A
// [2] C
