package f_08_collections_processing_2_fold.s_8

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    println(numbers.fold(0) { acc, i -> acc + i }) // 15
    println(numbers.reduce { acc, i -> acc + i }) // 15

    println(numbers.fold("") { acc, i -> acc + i }) // 12345
    // Here `reduce` cannot be used instead of `fold`

    println(numbers.fold(1) { acc, i -> acc * i }) // 120
    println(numbers.reduce { acc, i -> acc * i }) // 120
}
