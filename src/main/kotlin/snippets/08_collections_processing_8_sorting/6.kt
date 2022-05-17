package f_08_collections_processing_8_sorting.s_6

class Person(val id: Int?, val name: String?)

fun main() {
    val people = listOf(
        Person(1, "Alex"),
        Person(null, "Ben"),
        Person(2, null),
    )
    println(people.sortedBy { it.id })
    // [null: Ben, 1: Alex, 2: null]
    println(people.sortedBy { it.name })
    // [2: null, 1: Alex, null: Ben]
}
