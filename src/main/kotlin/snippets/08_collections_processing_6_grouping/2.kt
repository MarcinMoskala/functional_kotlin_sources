package f_08_collections_processing_6_grouping.s_2

fun main() {
    val nums = listOf(1, 2, 6, 11)
    val partitioned: Pair<List<Int>, List<Int>> =
        nums.partition { it in 2..10 }
    println(partitioned) // ([2, 6], [1, 11])

    val (inRange, notInRange) = partitioned
    println(inRange) // [2, 6]
    println(notInRange) // [1, 11]
}
