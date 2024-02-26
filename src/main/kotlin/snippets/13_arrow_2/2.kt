package f_13_arrow_2.s_2

fun add(a: String, b: String): Int? {
    val x = a.toIntOrNull() ?: return null
    val y = b.toIntOrNull() ?: return null
    return x + y
}
