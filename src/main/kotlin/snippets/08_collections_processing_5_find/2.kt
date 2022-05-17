package f_08_collections_processing_5_find.s_2

fun main() {
    val c = listOf<Char>()

    println(c.firstOrNull()) // null
    println(c.lastOrNull()) // null
    println(c.getOrNull(3)) // null
}
