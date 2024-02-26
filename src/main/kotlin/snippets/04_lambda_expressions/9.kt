package f_04_lambda_expressions.s_9

fun call(before: () -> Unit = {}, after: () -> Unit = {}) {
    before()
    print("A")
    after()
}

fun main() {
    call({ print("C") })
    call { print("B") }
}
