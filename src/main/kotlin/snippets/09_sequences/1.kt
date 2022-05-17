package f_09_sequences.s_1

fun main() {
    val seq = sequenceOf(1, 2, 3)
    val filtered = seq.filter { print("f$it "); it % 2 == 1 }
    println(filtered)  // FilteringSequence@...

    val asList = filtered.toList()
    // f1 f2 f3
    println(asList) // [1, 3]

    val list = listOf(1, 2, 3)
    val listFiltered = list
        .filter { print("f$it "); it % 2 == 1 }
    // f1 f2 f3
    println(listFiltered) // [1, 3]
}
