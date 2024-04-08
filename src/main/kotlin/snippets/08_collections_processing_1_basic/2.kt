package f_08_collections_processing_1_basic.s_2

inline fun <T> Iterable<T>.filter(
   predicate: (T) -> Boolean
): List<T> {
   val destination = ArrayList<T>()
   for (element in this) {
       if (predicate(element)) {
           destination.add(element)
       }
   }
   return destination
}
