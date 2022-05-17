package f_08_collections_processing_2_fold.s_2

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    println(numbers.sum()) // 15
    println(numbers.joinToString(separator = "")) // 12345
}
