package f_07_inline_functions.s_8

fun main() {
    (0 until 19).forEach { index ->
        if (index == 4) return // Returns from main
        print(index)
    }
}
// 0123
