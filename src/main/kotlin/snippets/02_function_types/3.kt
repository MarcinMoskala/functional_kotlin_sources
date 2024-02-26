package f_02_function_types.s_3

fun someOperations(
    onStart: (() -> Unit)? = null,
    onCompletion: (() -> Unit)? = null,
) {
    onStart?.invoke()
    // ...
    onCompletion?.invoke()
}
