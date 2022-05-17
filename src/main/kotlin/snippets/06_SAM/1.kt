package f_06_SAM.s_1

class View
interface OnClick {
    fun onClick(view: View)
}

fun setOnClickListener(listener: OnClick) {
    //...
}

fun main() {
    setOnClickListener(object : OnClick {
        override fun onClick(view: View) {
            // ...
        }
    })
}
