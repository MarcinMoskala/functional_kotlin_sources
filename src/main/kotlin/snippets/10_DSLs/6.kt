package f_10_DSLs.s_6

fun main() {
    val string = buildString {
        append("A")
        append("B")
        append("C")
    }
    println(string) // ABC
}
