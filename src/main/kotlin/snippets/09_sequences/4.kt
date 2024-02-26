package f_09_sequences.s_4

fun main() {
    sequenceOf(1, 2, 3)
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
        .forEach { print("E$it, ") }
    // Prints: F1, M1, E2, F2, F3, M3, E6,
}
