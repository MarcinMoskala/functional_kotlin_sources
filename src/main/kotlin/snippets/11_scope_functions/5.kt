package f_11_scope_functions.s_5

// `also` implementation without contract
inline fun <T> T.also(block: (T) -> Unit): T {
    block(this)
    return this
}
