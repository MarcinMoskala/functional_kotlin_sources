package f_08_collections_processing_8_sorting.s_15

data class Character(val name: String, val surname: String)

fun main() {
    val characters = listOf(
        Character("Tamara", "Kurczak"),
        Character("Earl", "Gey"),
        Character("Ryba", "Luna"),
        Character("Cookie", "DePies"),
    )
    println(characters.random())
    // A random character,
    // like Character(name=Ryba, surname=Luna)
    println(characters.shuffled())
    // List with characters in a random order
}
