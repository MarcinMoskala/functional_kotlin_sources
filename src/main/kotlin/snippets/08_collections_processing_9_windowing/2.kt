package f_08_collections_processing_9_windowing.s_2

fun main() {
    println((1..4).zipWithNext())
    // [(1, 2), (2, 3), (3, 4)]
    
    val person = listOf(
        "Ashley",
        "Barbara",
        "Cyprian",
    )
    println(person.zipWithNext())
    // [(Ashley, Barbara), (Barbara, Cyprian)]
}
