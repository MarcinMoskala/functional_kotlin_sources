package f_08_collections_processing_8_sorting.s_9

fun main() {
    val list = listOf(4, 2, 3, 1)
    val sortedRes = list.sorted()
    // list.sort() is illegal
    println(list) // [4, 2, 3, 1]
    println(sortedRes) // [1, 2, 3, 4]

    val mutableList = mutableListOf(4, 2, 3, 1)
    val sortRes = mutableList.sort()
    println(mutableList) // [1, 2, 3, 4]
    println(sortRes) // kotlin.Unit
}
