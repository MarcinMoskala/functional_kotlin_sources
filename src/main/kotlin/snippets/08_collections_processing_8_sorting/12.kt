package f_08_collections_processing_8_sorting.s_12

data class FullName(val name: String, val surname: String)

fun main() {
    val names = listOf(
        FullName("B", "B"),
        FullName("B", "A"),
        FullName("A", "A"),
        FullName("A", "B"),
    )

    println(
        names
            .maxWithOrNull(compareBy(
                { it.surname },
                { it.name }
            ))
    )
    // FullName(name=B, surname=B)
    println(
        names
            .minWithOrNull(compareBy(
                { it.surname },
                { it.name }
            ))
    )
    // FullName(name=A, surname=A)
}
