package f_08_collections_processing_2_fold.s_9

fun Iterable<Int>.sum(): Int {
    var sum: Int = 0
    for (element in this) {
        sum += element
    }
    return sum
}

inline fun <T> Iterable<T>.sumOf(
    selector: (T) -> Int
): Int {
    var sum: Int = 0.toInt()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}
