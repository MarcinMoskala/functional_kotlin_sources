package f_08_collections_processing_2_fold.s_6

fun main() {
    val numbers = listOf(1, 2, 3, 4)
    println(numbers.fold(0) { acc, i -> acc + i }) 
    // 10
    println(numbers.scan(0) { acc, i -> acc + i })
    // [0, 1, 3, 6, 10]
    println(numbers.runningFold(0) { acc, i -> acc + i })
    // [0, 1, 3, 6, 10]

    println(numbers.fold("") { acc, i -> acc + i }) 
    // 1234
    println(numbers.scan("") { acc, i -> acc + i })
    // [, 1, 12, 123, 1234]
    println(numbers.runningFold("") { acc, i -> acc + i })
    // [, 1, 12, 123, 1234]

    println(numbers.fold(1) { acc, i -> acc * i }) 
    // 24
    println(numbers.scan(1) { acc, i -> acc * i })
    // [1, 1, 2, 6, 24]
    println(numbers.runningFold(1) { acc, i -> acc * i })
    // [1, 1, 2, 6, 24]
}
