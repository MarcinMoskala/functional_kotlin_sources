package f_05_function_references.s_2

fun add(a: Int, b: Int) = a + b

fun main() {
   val f = ::add // function reference
   println(f.isOpen) // false
   println(f.visibility) // PUBLIC
   // The above statements require `kotlin-reflect`
   // dependency
}
