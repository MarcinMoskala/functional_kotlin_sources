package f_05_function_references.s_4

fun zeroComplex(): Complex = Complex(0.0, 0.0)

fun makeComplex(
    real: Double = 0.0,
    imaginary: Double = 0.0
) = Complex(real, imaginary)

data class Complex(val real: Double, val imaginary: Double)

fun main() {
    val f1: () -> Complex = ::zeroComplex
    println(f1()) // Complex(real=0.0, imaginary=0.0)

    val f2: (Double, Double) -> Complex = ::makeComplex
    println(f2(1.0, 2.0)) // Complex(real=1.0, imaginary=2.0)
}
