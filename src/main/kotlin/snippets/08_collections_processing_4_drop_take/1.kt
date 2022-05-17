package f_08_collections_processing_4_drop_take.s_1

fun main() {
    val chars = ('a'..'z').toList()

    println(chars.take(10))
    // [a, b, c, d, e, f, g, h, i, j]
    println(chars.takeLast(10))
    // [q, r, s, t, u, v, w, x, y, z]
    println(chars.drop(10))
    // [k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
    println(chars.dropLast(10))
    // [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p]
}
