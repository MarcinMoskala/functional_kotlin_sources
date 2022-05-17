package f_05_function_references.s_3

fun add(a: Int, b: Int) = a + b

fun main() {
    val f: (Int, Int) -> Int = ::add
    // an alternative to:
    // val f: (Int, Int) -> Int = { a, b -> add(a, b) }
    println(f(10, 20)) // 30
}
