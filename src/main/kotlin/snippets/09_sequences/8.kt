package f_09_sequences.s_8

fun main() {
    val s = (1..6).asSequence()
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }

    s.find { it > 3 } // F1, M1, F2, F3, M3,
    println()
    s.find { it > 3 } // F1, M1, F2, F3, M3,
    println()
    s.find { it > 3 } // F1, M1, F2, F3, M3,
    println()

    val l = (1..6)
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
    // F1, F2, F3, F4, F5, F6, M1, M3, M5,

    l.find { it > 3 } // prints nothing
    l.find { it > 3 } // prints nothing
    l.find { it > 3 } // prints nothing
}
