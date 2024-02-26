package f_08_collections_processing_7_associating.s_8

fun main() {
    val names = listOf("Marta", "Maciek", "Daniel")
    println(names)
    // [Marta, Maciek, Daniel]
    println(names.distinctBy { it.length })
    // [Marta, Maciek]
    println(names.associateBy { it.length }.values)
    // [Marta, Daniel]
}
