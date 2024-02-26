package f_05_function_references.s_4

data class Number(val num: Int) {
   fun toFloat(): Float = num.toFloat()
   fun times(n: Int): Number = Number(num * n)
}

fun main() {
   val numberObject = Number(10)
   // member function reference
   val float: (Number) -> Float = Number::toFloat
   // `toFloat` has no parameters, but its function type
   // needs a receiver of type `Number`
   println(float(numberObject)) // 10.0
   val multiply: (Number, Int) -> Number = Number::times
   println(multiply(numberObject, 4)) // Number(num = 40.0)
   // `times` has one parameter of type `Int`, but its
   // function type also needs a receiver of type `Number`
}
