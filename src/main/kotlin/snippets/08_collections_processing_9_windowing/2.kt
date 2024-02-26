package f_08_collections_processing_9_windowing.s_2

fun main() {
    // zip can be used with infix notation
    val zipped = (1..4) zip ('a'..'d')
    println(zipped) // [(1, a), (2, b), (3, c), (4, d)]
    val (numbers, letters) = zipped.unzip()
    println(numbers) // [1, 2, 3, 4]
    println(letters) // [a, b, c, d]
}
