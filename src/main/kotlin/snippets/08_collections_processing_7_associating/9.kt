package f_08_collections_processing_7_associating.s_9

data class Person(val id: Int, val name: String) {
    override fun toString(): String = "$id: $name"
}

fun main() {
    val people = listOf(
        Person(0, "Alex"),
        Person(1, "Ben"),
        Person(1, "Carl"),
        Person(2, "Ben"),
        Person(0, "Alex"),
    )
    println(people.distinct())
    // [0: Alex, 1: Ben, 1: Carl, 2: Ben]
    println(people.distinctBy { it.id })
    // [0: Alex, 1: Ben, 2: Ben]
    println(people.distinctBy { it.name })
    // [0: Alex, 1: Ben, 1: Carl]
}
