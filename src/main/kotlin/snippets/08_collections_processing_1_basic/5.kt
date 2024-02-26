package f_08_collections_processing_1_basic.s_5

// simplified map implementation from Kotlin stdlib
inline fun <T, R> Iterable<T>.map(
   transform: (T) -> R
): List<R> {
   val size = if (this is Collection<*>) this.size else 10
   val destination = ArrayList<R>(size)
   for (element in this) {
       destination.add(transform(element))
   }
   return destination
}
