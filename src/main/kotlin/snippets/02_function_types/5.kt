package f_02_function_types.s_5

class View
var listeners = listOf<(Int, Int, View, View) -> Unit>()

fun setListItemListener(
    listener: (
        position: Int, id: Int, 
        View, parent: View
    ) -> Unit
) {
    listeners = listeners + listener
}
