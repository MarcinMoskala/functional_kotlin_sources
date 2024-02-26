package f_09_sequences.s_2

fun main() {
    listOf(1, 2, 3)
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
        .forEach { print("E$it, ") }
    // Prints: F1, F2, F3, M1, M3, E2, E6,
}
