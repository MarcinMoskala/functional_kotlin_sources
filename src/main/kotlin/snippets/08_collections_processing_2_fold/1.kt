package f_08_collections_processing_2_fold.s_1

fun main() {
    val numbers = listOf(1, 2, 3, 4)
    val sum = numbers.fold(0) { acc, i -> acc + i }
    println(sum) // 10
    val joinedString = numbers.fold("") { acc, i -> acc + i }
    println(joinedString) // 1234
    val product = numbers.fold(1) { acc, i -> acc * i }
    println(product) // 24
}
