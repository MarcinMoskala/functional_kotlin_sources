package f_09_sequences.s_6

fun main() {
    (1..10).asSequence()
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
        .find { it > 5 }
    // Prints: F1, M1, F2, F3, M3,

    (1..10)
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
        .find { it > 5 }
    // Prints: F1, F2, F3, F4, F5, F6, F7, F8, F9, F10,
    // M1, M3, M5, M7, M9,
}
