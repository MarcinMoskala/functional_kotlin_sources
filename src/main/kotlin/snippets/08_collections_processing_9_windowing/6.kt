package f_08_collections_processing_9_windowing.s_6

fun <T> Iterable<T>.chunked(size: Int): List<List<T>> =
    windowed(size, size, partialWindows = true)
