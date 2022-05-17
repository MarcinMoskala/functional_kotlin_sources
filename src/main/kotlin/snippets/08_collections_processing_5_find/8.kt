package f_08_collections_processing_5_find.s_8

fun main() {
    val emptyList = emptyList<String>()
    println(emptyList.any { error("Ignored") }) // false
    println(emptyList.all { error("Ignored") }) // true
    println(emptyList.none { error("Ignored") }) // true
}
