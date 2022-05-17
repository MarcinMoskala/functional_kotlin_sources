package f_07_inline_functions.s_5

fun main() {
    for (i in 0 until 10) {
        if (i == 4) return // Returns from main
        print(i)
    }
}
// 0123
