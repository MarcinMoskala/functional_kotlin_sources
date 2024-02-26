package f_08_collections_processing_4_drop_take.s_4

fun main() {
    val letters = listOf("a", "b", "c")
    println(letters.take(100)) // [a, b, c]
    println(letters.takeLast(100)) // [a, b, c]
    println(letters.drop(100)) // []
    println(letters.dropLast(100)) // []
    letters.subList(0, 4) // throws IndexOutOfBoundsException
}
