package f_11_scope_functions.s_6

inline fun <T> T.takeIf(predicate: (T) -> Boolean): T? {
    return if (predicate(this)) this else null
}

inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T? {
    return if (!predicate(this)) this else null
}
