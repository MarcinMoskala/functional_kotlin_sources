package f_08_collections_processing_1_basic.s_11

fun main() {
   val old = listOf(1, 2, 3)
   val new = old.flatMap { listOf(it, it + 10) }
   println(new) // [1, 11, 2, 12, 3, 13]
}
