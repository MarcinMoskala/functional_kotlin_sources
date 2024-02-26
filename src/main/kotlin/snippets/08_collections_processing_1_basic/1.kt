package f_08_collections_processing_1_basic.s_1

// forEach implementation from Kotlin stdlib
inline fun <T> Iterable<T>.forEach(action: (T) -> Unit) {
   for (element in this) action(element)
}

// simplified onEach implementation from Kotlin stdlib
inline fun <T, C : Iterable<T>> C.onEach(
   action: (T) -> Unit
): C {
   for (element in this) action(element)
   return this
}
