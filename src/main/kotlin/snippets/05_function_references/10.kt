package f_05_function_references.s_10

data class Number(val num: Int) {
   fun toFloat(): Float = num.toFloat()
   fun times(n: Int): Number = Number(num * n)
}

fun main() {
   val num = Number(10)
   // bounded function reference
   val getNumAsFloat: () -> Float = num::toFloat
   // There is no need for receiver type in function type,
   // because reference is already bound to an object
   println(getNumAsFloat()) // 10.0
   val multiplyNum: (Int) -> Number = num::times
   println(multiplyNum(4)) // Number(num = 40.0)
}
