package f_08_collections_processing_7_associating.s_1

fun main() {
    val names = listOf("Alex", "Ben", "Cal")
    println(names.associate { it.first() to it.drop(1) })
    // {A=lex, B=en, C=al}
    println(names.associateWith { it.length })
    // {Alex=4, Ben=3, Cal=3}
    println(names.associateBy { it.first() })
    // {A=Alex, B=Ben, C=Cal}
}
