package f_05_function_references.s_16

fun foo(i: Int) = 1
fun foo(str: String) = "AAA"

fun main() {
  println(foo(123)) // 1
  println(foo("")) // AAA
}
