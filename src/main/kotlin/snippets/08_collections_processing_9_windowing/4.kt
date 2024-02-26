package f_08_collections_processing_9_windowing.s_4

fun main() {
    val person = listOf("A", "B", "C", "D", "E")
    println(person.zipWithNext { prev, next -> "$prev$next" })
    // [AB, BC, CD, DE]
}
