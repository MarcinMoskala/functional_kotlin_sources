package f_08_collections_processing_5_find.s_1

fun main() {
    val c = ('a'..'z').toList()

    println(c.first()) // a
    println(c.last()) // z
    println(c.get(3)) // d
    println(c[3]) // d
    val (c1, c2, c3) = c
    println(c1) // a
    println(c2) // b
    println(c3) // c
}
