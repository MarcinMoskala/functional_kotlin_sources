package f_11_scope_functions.s_10

// `with` implementation without contract
inline fun <T, R> with(receiver: T, block: T.() -> R): R =
    receiver.block()
