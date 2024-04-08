package f_11_scope_functions.s_10

inline fun <T, R> with(receiver: T, block: T.() -> R): R =
    receiver.block()
