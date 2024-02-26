package f_08_collections_processing_3_index.s_2

fun main() {
    val chars = listOf("A", "B", "C", "D")

    val filtered = chars
        .filterIndexed { index, value -> index % 2 == 0 }
    println(filtered) // [A, C]

    val mapped = chars
        .mapIndexed { index, value -> "[$index] $value" }
    println(mapped) // [[0] A, [1] B, [2] C, [3] D]
}
