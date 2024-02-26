package f_08_collections_processing_9_windowing.s_7

fun main() {
    val person = listOf("Ashley", "Barbara", "Cyprian", "David")
    println(person.chunked(1))
    // [[Ashley], [Barbara], [Cyprian], [David]]

    println(person.chunked(2))
    // [[Ashley, Barbara], [Cyprian, David]]

    println(person.chunked(3))
    // [[Ashley, Barbara, Cyprian], [David]]

    println(person.chunked(4))
    // [[Ashley, Barbara, Cyprian, David]]
}
