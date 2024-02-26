package f_08_collections_processing_5_find.s_3

fun main() {
    val names = listOf("Cookie", "Figa")

    println(names.find { it.first() == 'A' }) // null
    println(names.firstOrNull { it.first() == 'A' }) // null
    println(names.find { it.first() == 'C' }) // Cookie
    println(names.firstOrNull { it.first() == 'C' }) // Cookie

    println(listOf(1, 2, 6, 11).find { it in 2..10 }) // 2
}
