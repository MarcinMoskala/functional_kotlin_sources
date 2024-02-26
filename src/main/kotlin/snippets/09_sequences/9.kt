package f_09_sequences.s_9

import java.math.BigInteger

val fibonacci: Sequence<BigInteger> = sequence {
    var current = 1.toBigInteger()
    var prev = 0.toBigInteger()
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
