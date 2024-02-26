package f_11_scope_functions.s_6

// `takeIf` implementation without contract
inline fun <T> T.takeIf(predicate: (T) -> Boolean): T? {
    return if (predicate(this)) this else null
}

// `takeUnless` implementation without contract
inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T? {
    return if (!predicate(this)) this else null
}
