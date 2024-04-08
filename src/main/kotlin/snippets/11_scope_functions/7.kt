package f_11_scope_functions.s_7

inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}
