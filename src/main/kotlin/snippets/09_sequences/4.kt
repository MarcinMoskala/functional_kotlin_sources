package f_09_sequences.s_4

fun main() {
    for (e in listOf(1, 2, 3)) {
        print("F$e, ")
        if (e % 2 == 1) {
            print("M$e, ")
            val mapped = e * 2
            print("E$mapped, ")
        }
    }
    // Prints: F1, M1, E2, F2, F3, M3, E6,
}
