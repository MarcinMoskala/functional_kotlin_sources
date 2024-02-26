package f_08_collections_processing_8_sorting.s_11

data class Player(val name: String, val score: Int)

fun main() {
    val players = listOf(
        Player("Jake", 234),
        Player("Megan", 567),
        Player("Beth", 123),
    )

    println(players.maxByOrNull { it.score })
    // Player(name=Megan, score=567)
    println(players.minByOrNull { it.score })
    // Player(name=Beth, score=123)
}
