package f_08_collections_processing_7_associating.s_6

fun main() {
    val numbers = listOf(1, 2, 4, 2, 3, 1)
    println(numbers) // [1, 2, 4, 2, 3, 1]
    println(numbers.distinct()) // [1, 2, 4, 3]

    val names = listOf("Marta", "Maciek", "Marta", "Daniel")
    println(names) // [Marta, Maciek, Marta, Daniel]
    println(names.distinct()) // [Marta, Maciek, Daniel]
}
