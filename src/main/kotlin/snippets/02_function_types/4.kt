package f_02_function_types.s_4

class View
var listeners = listOf<(Int, Int, View, View) -> Unit>()

fun setListItemListener(
    listener: (Int, Int, View, View) -> Unit
) {
    listeners = listeners + listener
}
