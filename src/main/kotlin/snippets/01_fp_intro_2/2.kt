package f_01_fp_intro_2.s_2

fun sum(a: Int, b: Int) = fold(a, b, 0, { acc, i -> acc + i })

fun product(a: Int, b: Int) = fold(a, b, 1, { acc, i -> acc * i })

fun fold(
    a: Int,
    b: Int,
    initial: Int,
    operation: (Int, Int) -> Int
): Int {
    var acc = initial
    for (i in a..b) {
        acc = operation(acc, i)
    }
    return acc
}
