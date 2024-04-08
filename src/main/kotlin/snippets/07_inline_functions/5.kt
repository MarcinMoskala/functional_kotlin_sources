package f_07_inline_functions.s_5

fun main() {
    repeat(10) { index ->
        if (index == 4) return // Returns from main
        print(index)
    }
}
