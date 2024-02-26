package f_08_collections_processing_2_fold.s_9

// simplified sample sum implementation from Kotlin stdlib
fun Iterable<Int>.sum(): Int {
    var sum: Int = 0
    for (element in this) {
        sum += element
    }
    return sum
}

// simplified sample sumOf implementation from Kotlin stdlib
inline fun <T> Iterable<T>.sumOf(
    selector: (T) -> Int
): Int {
    var sum: Int = 0.toInt()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}
