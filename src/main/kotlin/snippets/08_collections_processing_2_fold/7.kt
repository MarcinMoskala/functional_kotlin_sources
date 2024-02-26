package f_08_collections_processing_2_fold.s_7

// simplified reduce implementation from Kotlin stdlib
public inline fun <S, T : S> Iterable<T>.reduce(
    operation: (acc: S, T) -> S
): S {
    val iterator = this.iterator()
    if (!iterator.hasNext())
        throw UnsupportedOperationException(
            "Empty collection can't be reduced."
        )
    var accumulator: S = iterator.next()
    while (iterator.hasNext()) {
        accumulator = operation(accumulator, iterator.next())
    }
    return accumulator
}
