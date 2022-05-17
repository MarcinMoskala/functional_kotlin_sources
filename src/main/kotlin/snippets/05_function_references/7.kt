package f_05_function_references.s_7

fun foo(i: Int) = 1
fun foo(str: String) = "AAA"

fun main() {
    val fooInt: (Int) -> Int = ::foo
    println(fooInt(123)) // 1
    val fooStr: (String) -> String = ::foo
    println(fooStr("")) // AAA
}
