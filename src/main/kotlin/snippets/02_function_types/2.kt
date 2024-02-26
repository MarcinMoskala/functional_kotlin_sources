package f_02_function_types.s_2

fun fetchText(
    onSuccess: (String) -> Unit,
    onFailure: (Throwable) -> Boolean
) {
    // ...
    onSuccess("Some text") // returns Unit
    // or
    val handled: Boolean = onFailure(Error("Some error"))
}
