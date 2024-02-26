package f_08_collections_processing_2_fold.s_6

import java.math.BigDecimal

data class Player(
    val name: String,
    val points: Int,
    val money: BigDecimal,
)

fun main() {
    val players = listOf(
        Player("Jake", 234, BigDecimal("2.30")),
        Player("Megan", 567, BigDecimal("1.50")),
        Player("Beth", 123, BigDecimal("0.00")),
    )

    println(players.map { it.points }.sum()) // 924
    println(players.sumOf { it.points }) // 924

    // Works for `BigDecimal` as well
    println(players.sumOf { it.money }) // 3.80
}
