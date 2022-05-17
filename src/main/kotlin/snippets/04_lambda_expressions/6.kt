package f_04_lambda_expressions.s_6

class View
class Click

fun setOnClickListener(listener: (View, Click) -> Unit) {}

fun main() {
    setOnClickListener({ view, click ->
        println("Clicked")
    })
}
