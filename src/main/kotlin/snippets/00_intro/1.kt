package f_00_intro.s_1

fun main() {
    val cheer: () -> Unit = fun() {
        println("Hello")
    }
    cheer.invoke() // Hello
    cheer() // Hello
}
