package f_08_collections_processing_8_sorting.s_14

import kotlin.random.Random

fun main() {
    val range = (1..100)
    val list = range.toList()

    // `random` requires a collection
    println(list.random()) // random number from 1 to 100
    println(list.randomOrNull())
    // random number from 1 to 100

    println(list.random(Random(123))) // 7
    println(list.randomOrNull(Random(123))) // 7

    println(range.shuffled())
    // List with numbers in a random order
}
