package f_08_collections_processing_8_sorting.s_13

data class Player(val name: String, val score: Int)

fun main() {
    val players = listOf(
        Player("Jake", 234),
        Player("Megan", 567),
        Player("Beth", 123),
    )

    println(players.map { it.score }.maxOrNull()) // 567
    println(players.maxByOrNull { it.score }?.score) // 567
    println(players.maxOfOrNull { it.score }) // 567
    println(players.maxOf { it.score }) // 567

    println(players.map { it.score }.minOrNull()) // 123
    println(players.minByOrNull { it.score }?.score) // 123
    println(players.minOfOrNull { it.score }) // 123
    println(players.minOf { it.score }) // 123
}
