package f_08_collections_processing_2_fold.s_3

inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T> = fold(emptyList()) { acc, e ->
    if (predicate(e)) acc + e else acc
}

inline fun <T, R> Iterable<T>.map(
    transform: (T) -> R
): List<R> = fold(emptyList()) { acc, e -> acc + transform(e) }

inline fun <T, R> Iterable<T>.flatMap(
    transform: (T) -> Iterable<R>
): List<R> = fold(emptyList()) { acc, e -> acc + transform(e) }
