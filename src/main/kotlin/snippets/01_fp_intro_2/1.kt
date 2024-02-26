package f_01_fp_intro_2.s_1

fun sum(a: Int, b: Int): Int {
    var sum = 0
    for (i in a..b) {
        sum += i
    }
    return sum
}

fun product(a: Int, b: Int): Int {
    var product = 1
    for (i in a..b) {
        product *= i
    }
    return product
}

fun main() {
    sum(5, 10) // 45
    product(5, 10) // 151200
}
