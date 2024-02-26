package f_09_sequences.s_5

fun main() {
    val resI = (1..10).asIterable()
        .map { print("M$it "); it * it }
        .find { print("F$it "); it > 3 }
    println(resI) // M1 M2 M3 M4 M5 M6 M7 M8 M9 M10 F1 F4 4

    val resS = (1..10).asSequence()
        .map { print("M$it "); it * it }
        .find { print("F$it "); it > 3 }
    println(resS) // M1 F1 M2 F4 4
}
