package f_05_function_references.s_9

class Box<T>(private val value: T) {
   fun unbox(): T = value
}

fun main() {
   val unbox = Box<String>::unbox
   val box = Box("AAA")
   println(unbox(box)) // AAA
}
