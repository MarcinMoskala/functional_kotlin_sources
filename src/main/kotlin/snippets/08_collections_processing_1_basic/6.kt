package f_08_collections_processing_1_basic.s_6

fun main() {
    val names = listOf("Ann", "Bob", "Cale")
    val chars1: List<Char> = names.flatMap { it.toList() }
    println(chars1) // [A, n, n, B, o, b, C, a, l, e]
    val mapRes: List<List<Char>> = names.map { it.toList() }
    println(mapRes) // [[A, n, n], [B, o, b], [C, a, l, e]]
    val chars2 = mapRes.flatten()
    println(chars2) // [A, n, n, B, o, b, C, a, l, e]
    println(chars1 == chars2) // true
}
