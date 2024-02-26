package f_08_collections_processing_7_associating.s_2

fun main() {
    val names = listOf("Alex", "Aaron", "Ada")
    println(names.associateBy { it.first() })
    // {A=Ada}
    println(names.groupBy { it.first() })
    // {A=[Alex, Aaron, Ada]}
}
