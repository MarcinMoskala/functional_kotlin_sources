package f_08_collections_processing_8_sorting.s_7

fun interface Comparator<T> {
    fun compare(a: T, b: T): Int
}
