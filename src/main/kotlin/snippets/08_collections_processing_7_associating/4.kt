package f_08_collections_processing_7_associating.s_4

fun <T> Iterable<T>.distinct(): List<T> {
    return this.toMutableSet().toList()
}

inline fun <T, K> Iterable<T>.distinctBy(
    selector: (T) -> K
): List<T> {
    val set = HashSet<K>()
    val list = ArrayList<T>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}
