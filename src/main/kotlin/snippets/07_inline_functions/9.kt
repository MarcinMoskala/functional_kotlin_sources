package f_07_inline_functions.s_9

inline fun <reified T> printTypeName() {
    print(T::class.simpleName)
}

fun main() {
    printTypeName<Int>() // Int
    printTypeName<Char>() // Char
    printTypeName<String>() // String
}
