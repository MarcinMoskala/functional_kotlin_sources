package f_11_scope_functions.s_5

inline fun <T> T.also(block: (T) -> Unit): T {
    block(this)
    return this
}
