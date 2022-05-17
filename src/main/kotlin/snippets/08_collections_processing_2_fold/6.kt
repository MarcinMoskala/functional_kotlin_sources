package f_08_collections_processing_2_fold.s_6

fun main() {
    val numbers = listOf(1, 6, 2, 4, 7, 1)
    println(numbers.sum()) // 21

    val doubles = listOf(0.1, 0.6, 0.2, 0.4, 0.7)
    println(doubles.sum()) // 1.9999999999999998
    // It is not 2, due to limited JVM double representation

    val bytes = listOf<Byte>(1, 4, 2, 4, 5)
    println(bytes.sum()) // 16
}
