package f_11_scope_functions.s_1

fun main() {
    println(listOf("a", "b", "c").map { it.uppercase() })
    // [A, B, C]
    println("a".let { it.uppercase() }) // A
}
