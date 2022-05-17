package f_07_inline_functions.s_7

fun main() {
    for (index in 0 until 10) {
        if (index == 4) return // Returns from main
        print(index)
    }
}
// 0123
