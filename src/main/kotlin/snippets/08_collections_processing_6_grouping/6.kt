package f_08_collections_processing_6_grouping.s_6

data class Player(val name: String, val team: String)

fun main() {
    val players = listOf(
        Player("Alex", "A"),
        Player("Ben", "B"),
        Player("Cal", "A"),
    )
    val grouped = players.groupBy { it.team }
    println(grouped)
    // {A=[Player(name=Alex, team=A),
    //     Player(name=Cal, team=A)],
    // B=[Player(name=Ben, team=B)]}
    println(grouped.flatMap { it.value })
    // [Player(name=Alex, team=A), Player(name=Cal, team=A),
    // Player(name=Ben, team=B)]
}
