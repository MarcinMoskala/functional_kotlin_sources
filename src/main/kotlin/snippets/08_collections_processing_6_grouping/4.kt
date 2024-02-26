package f_08_collections_processing_6_grouping.s_4

// groupBy implementation from Kotlin stdlib
inline fun <T, K> Iterable<T>.groupBy(
    keySelector: (T) -> K
): Map<K, List<T>> {
    val destination = LinkedHashMap<K, MutableList<T>>()
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { 
            ArrayList<T>() 
        }
        list.add(element)
    }
    return destination
}
