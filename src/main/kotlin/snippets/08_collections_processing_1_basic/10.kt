package f_08_collections_processing_1_basic.s_10

inline fun <T, R> Iterable<T>.flatMap(
   transform: (T) -> Iterable<R>
): List<R> {
   val size = if (this is Collection<*>) this.size else 10
   val destination = ArrayList<R>(size)
   for (element in this) {
       destination.addAll(transform(element))
   }
   return destination
}
