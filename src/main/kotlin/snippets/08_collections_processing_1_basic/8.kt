package f_08_collections_processing_1_basic.s_8

inline fun <T, R> Iterable<T>.mapNotNull(
    transform: (T) -> R
): List<R> {
    val size = if (this is Collection<*>) this.size else 10
    val destination = ArrayList<R>(size)
    for (element in this) {
        val result = transform(element)
        if (result != null) destination.add(result)
    }
    return destination
}
