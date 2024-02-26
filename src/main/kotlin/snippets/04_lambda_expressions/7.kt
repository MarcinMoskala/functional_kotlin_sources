package f_04_lambda_expressions.s_7

inline fun <R> run(block: () -> R): R = block()

inline fun repeat(times: Int, block: (Int) -> Unit) {
    for (i in 0 until times) {
        block(i)
    }
}

fun main() {
    run({ println("A") }) // A
    run() { println("A") } // A
    run { println("A") } // A

    repeat(2, { print("B") }) // BB
    println()
    repeat(2) { print("B") } // BB
}
