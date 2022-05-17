package f_08_collections_processing_9_windowing.s_3

fun main() {
    val person = listOf(
        "Ashley",
        "Barbara",
        "Cyprian",
        "David",
    )
    println(person.windowed(size = 1, step = 1))
    // [[Ashley], [Barbara], [Cyprian], [David]]
    // so similar to map { listOf(it) }

    println(person.windowed(size = 2, step = 1))
    // [[Ashley, Barbara], [Barbara, Cyprian], 
    // [Cyprian, David]]
    // so similar to zipWithNext().map { it.toList() }

    println(person.windowed(size = 1, step = 2))
    // [[Ashley], [Cyprian]]

    println(person.windowed(size = 2, step = 2))
    // [[Ashley, Barbara], [Cyprian, David]]

    println(person.windowed(size = 3, step = 1))
    // [[Ashley, Barbara, Cyprian], [Barbara, Cyprian, David]]

    println(person.windowed(size = 3, step = 2))
    // [[Ashley, Barbara, Cyprian]]

    println(
        person.windowed(
            size = 3,
            step = 1,
            partialWindows = true
        )
    )
    // [[Ashley, Barbara, Cyprian], [Barbara, Cyprian, David],
    // [Cyprian, David], [David]]

    println(
        person.windowed(
            size = 3,
            step = 2,
            partialWindows = true
        )
    )
    // [[Ashley, Barbara, Cyprian], [Cyprian, David]]
}
