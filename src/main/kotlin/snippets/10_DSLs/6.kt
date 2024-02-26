package f_10_DSLs.s_6

fun main() {
    val list = buildList {
        add(1)
        add(2)
        add(3)
    }
    println(list) // [1, 2, 3]
}
