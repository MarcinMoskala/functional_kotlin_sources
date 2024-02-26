package f_08_collections_processing_1_basic.s_7

fun main() {
   val names: List<String> = listOf("Alex", "Bob", "Carol")
   val nameSizes: List<Int> = names.map { it.length }
   println(nameSizes) // [4, 3, 5]
}
