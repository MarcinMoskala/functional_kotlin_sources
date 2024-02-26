package f_08_collections_processing_3_index.s_3

fun main() {
    val chars = listOf("A", "B", "C", "D")

    val r1 = chars.withIndex()
        .filter { (index, value) -> index % 2 == 0 }
        .map { (index, value) -> "[$index] $value" }
    println(r1) // [[0] A, [2] C]

    val r2 = chars
        .filterIndexed { index, value -> index % 2 == 0 }
        .mapIndexed() { index, value -> "[$index] $value" }
    println(r2) // [[0] A, [1] C]
}
