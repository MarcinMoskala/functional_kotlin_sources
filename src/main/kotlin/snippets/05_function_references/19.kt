package f_05_function_references.s_19

data class Complex(val real: Double, val imaginary: Double)

fun main() {
   val c1 = Complex(1.0, 2.0)
   val c2 = Complex(3.0, 4.0)

   // property reference
   val getter: (Complex) -> Double = Complex::real

   println(getter(c1)) // 1.0
   println(getter(c2)) // 3.0

   // bounded property reference
   val c1ImgGetter: () -> Double = c1::imaginary
   println(c1ImgGetter()) // 2.0
}
