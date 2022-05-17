package f_02_function_types.s_1

fun fetchText(
    onSuccess: (String) -> Unit,
    onFailure: (Throwable) -> Boolean
) {
    // ...
    onSuccess.invoke("Some text") // returns Unit
    // or
    val handled: Boolean =
        onFailure.invoke(Error("Some error"))
}
