package f_09_sequences.s_9

fun main() {
    generateSequence(1) { it + 1 }
        .map { it * 2 }
        .take(10)
        .forEach { print("$it, ") }
    // Prints: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20,
}
