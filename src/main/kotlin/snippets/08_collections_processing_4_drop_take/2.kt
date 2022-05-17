package f_08_collections_processing_4_drop_take.s_2

fun main() {
    val c = ('a'..'z').toList()

    println(c.take(10) == c.dropLast(c.size - 10)) // true
    println(c.takeLast(10) == c.drop(c.size - 10)) // true
    println(c.drop(10) == c.takeLast(c.size - 10)) // true
    println(c.dropLast(10) == c.take(c.size - 10)) // true
}
