package f_08_collections_processing_5_find.s_5

fun main() {
    val names = listOf("C1", "C2")

    println(names.find { it.first() == 'C' }) // C1
    println(names.firstOrNull { it.first() == 'C' }) // C1
    println(names.findLast { it.first() == 'C' }) // C2
    println(names.lastOrNull { it.first() == 'C' }) // C2
}
