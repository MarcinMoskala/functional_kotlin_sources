package f_02_function_types.s_2

class OnClick : (Int) -> Unit {
    override fun invoke(viewId: Int) {
        // ...
    }
}

fun setListener(l: (Int) -> Unit) { 
    /*...*/
}

fun main() {
    val onClick = OnClick()
    setListener(onClick)
}
