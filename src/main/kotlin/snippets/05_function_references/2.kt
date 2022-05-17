package f_05_function_references.s_2

fun add(a: Int, b: Int) = a + b

fun main() {
    val f = ::add // function reference
    println(f.visibility) // PUBLIC
}
