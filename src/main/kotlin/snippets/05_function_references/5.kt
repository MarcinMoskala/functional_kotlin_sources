package f_05_function_references.s_5

fun sum(a: Int, b: Int) =
    (a..b).fold(0, Int::plus)

fun product(a: Int, b: Int) =
    (a..b).fold(1, Int::times)
