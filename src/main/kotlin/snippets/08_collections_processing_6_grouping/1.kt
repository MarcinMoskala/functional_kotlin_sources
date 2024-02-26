package f_08_collections_processing_6_grouping.s_1

// partition implementation from Kotlin stdlib
inline fun <T> Iterable<T>.partition(
    predicate: (T) -> Boolean
): Pair<List<T>, List<T>> {
    val first = ArrayList<T>()
    val second = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            first.add(element)
        } else {
            second.add(element)
        }
    }
    return Pair(first, second)
}
