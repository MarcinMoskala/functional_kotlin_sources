package f_11_scope_functions.s_1

inline fun <T, R> T.let(block: (T) -> R): R = block(this)
