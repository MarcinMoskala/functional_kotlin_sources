package f_08_collections_processing_7_associating.s_3

fun main() {
    val names = listOf("Alex", "Ben", "Cal")
    val aW = names.associateWith { it.length }
    println(aW.keys.toList() == names) // true
    val aB = names.associateBy { it.first() }
    println(aB.values.toList() == names) // true
}
