package f_08_collections_processing_2_fold.s_5

fun Iterable<Int>.product(): Int =
    fold(1) { acc, i -> acc * i }
