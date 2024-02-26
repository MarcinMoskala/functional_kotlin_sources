package f_05_function_references.s_12

data class Complex(val real: Double, val imaginary: Double)

fun main() {
  // constructor reference
  val produce: (Double, Double) -> Complex = ::Complex
  println(produce(1.0, 2.0))
  // Complex(real=1.0, imaginary=2.0)
}
