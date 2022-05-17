package f_08_collections_processing_9_windowing.s_1

fun main() {
    val nums = 1..4
    val chars = 'A'..'F'
    println(nums.zip(chars)) 
    // [(1, A), (2, B), (3, C), (4, D)]
    
    val winner = listOf(
        "Ashley",
        "Barbara",
        "Cyprian",
        "David",
    )
    val prices = listOf(5000, 3000, 1000)
    val zipped = winner.zip(prices)
    println(zipped)
    // [(Ashley, 5000), (Barbara, 3000), (Cyprian, 1000)]
    zipped.forEach { (person, price) ->
        println("$person won $price")
    }
    // Ashley won 5000
    // Barbara won 3000
    // Cyprian won 1000
}
