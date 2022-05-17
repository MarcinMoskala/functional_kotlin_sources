package f_04_lambda_expressions.s_9

import f_04_lambda_expressions.s_8.call

fun main() {
    call(before = { println("C") })
    call(after = { println("B") })
}
