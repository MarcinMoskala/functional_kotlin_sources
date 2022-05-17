package f_08_collections_processing_6_grouping.s_3

fun main() {
    val names = listOf("Marcin", "Maja", "Cookie")

    val byCapital = names.groupBy { it.first() }
    println(byCapital)
    // {M=[Marcin, Maja], C=[Cookie]}

    val byLength = names.groupBy { it.length }
    println(byLength)
    // {6=[Marcin, Cookie], 4=[Maja]}
}
