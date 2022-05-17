package f_09_sequences.s_7

import java.math.BigDecimal

val fibonacci: Sequence<BigDecimal> = sequence {
    var current = 0.toBigDecimal()
    var prev = 1.toBigDecimal()
    yield(prev)
    while (true) {
        yield(current)
        val temp = prev
        prev = current
        current += temp
    }
}

fun main() {
    print(fibonacci.take(10).toList())
    // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
}
