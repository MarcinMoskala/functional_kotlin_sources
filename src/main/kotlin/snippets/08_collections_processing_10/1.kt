package f_08_collections_processing_10.s_1

fun main() {
    val names = listOf("Maja", "Norbert", "Ola")
    println(names.joinToString())
    // Maja, Norbert, Ola
    println(names.joinToString { it.uppercase() })
    // MAJA, NORBERT, OLA
    println(names.joinToString(separator = "; "))
    // Maja; Norbert; Ola
    println(names.joinToString(limit = 2))
    // Maja, Norbert, ...
    println(names.joinToString(limit = 2, truncated = "etc."))
    // Maja, Norbert, etc.
    println(
        names.joinToString(
            prefix = "{names=[",
            postfix = "]}"
        )
    )
    // {names=[Maja, Norbert, Ola]}
}
