package f_11_scope_functions.s_11

inline fun <R> run(block: () -> R): R = block()

inline fun <T, R> T.run(block: T.() -> R): R = block()
