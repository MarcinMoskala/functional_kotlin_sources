package f_04_lambda_expressions.s_8

fun call(before: () -> Unit = {}, after: () -> Unit = {}) {
    before()
    println("A")
    after()
}

fun main() {
    call({ println("C") })
    call { println("B") }
}
