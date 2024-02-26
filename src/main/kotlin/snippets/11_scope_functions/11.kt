package f_11_scope_functions.s_11

// `run` implementation without contract
inline fun <R> run(block: () -> R): R = block()

// `run` implementation without contract
inline fun <T, R> T.run(block: T.() -> R): R = block()
