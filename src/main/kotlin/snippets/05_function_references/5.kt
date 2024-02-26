package f_05_function_references.s_5

data class Complex(val real: Double, val imaginary: Double) {
   fun doubled(): Complex =
       Complex(this.real * 2, this.imaginary * 2)
   fun times(num: Int) =
       Complex(real * num, imaginary * num)
}

fun main() {
   val c1 = Complex(1.0, 2.0)

   val f1: (Complex) -> Complex = Complex::doubled
   println(f1(c1)) // Complex(real=2.0, imaginary=4.0)

   val f2: (Complex, Int) -> Complex = Complex::times
   println(f2(c1, 4)) // Complex(real=4.0, imaginary=8.0)
}
