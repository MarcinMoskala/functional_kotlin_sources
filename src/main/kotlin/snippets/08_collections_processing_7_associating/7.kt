package f_08_collections_processing_7_associating.s_7

fun main() {
    val names = listOf("Marta", "Maciek", "Marta", "Daniel")
    println(names) // [Marta, Maciek, Marta, Daniel]
    println(names.distinctBy { it[0] }) // [Marta, Daniel]
    println(names.distinctBy { it.length }) // [Marta, Maciek]
}
