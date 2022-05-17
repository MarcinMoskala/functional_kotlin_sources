package f_07_inline_functions.s_6

fun main() {
    repeat(10) { index ->
        if (index == 4) return // Returns from main
        print(index)
    }
}
// 0123
