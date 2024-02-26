package f_08_collections_processing_8_sorting.s_7

data class FullName(val name: String, val surname: String) {
    override fun toString(): String = "$name $surname"
}

fun main() {
    val names = listOf(
        FullName("B", "B"),
        FullName("B", "A"),
        FullName("A", "A"),
        FullName("A", "B"),
    )

    println(names.sortedBy { it.name })
    // [A A, A B, B B, B A]
    println(names.sortedBy { it.surname })
    // [B A, A A, B B, A B]
    println(names.sortedWith(compareBy(
        { it.surname },
        { it.name }
    )))
    // [A A, B A, A B, B B]
    println(names.sortedWith(compareBy(
        { it.name },
        { it.surname }
    )))
    // [A A, A B, B A, B B]
}
