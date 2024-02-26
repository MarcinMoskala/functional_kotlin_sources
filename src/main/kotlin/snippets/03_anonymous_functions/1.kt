package f_03_anonymous_functions.s_1

// a regular function named add1
fun add1(a: Int, b: Int) = a + b

// an anonymous function stored in a property named add2
val add2 = fun(a: Int, b: Int): Int {
    return a + b
}
