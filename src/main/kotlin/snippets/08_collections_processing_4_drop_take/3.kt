package f_08_collections_processing_4_drop_take.s_3

fun main() {
    val c = ('a'..'z').toList()

    val n = 10
    val s = c.size
    println(c.take(n) == c.subList(0, n)) // true
    println(c.takeLast(n) == c.subList(s - n, s)) // true
    println(c.drop(n) == c.subList(n, s)) // true
    println(c.dropLast(n) == c.subList(0, s - n)) // true
}
