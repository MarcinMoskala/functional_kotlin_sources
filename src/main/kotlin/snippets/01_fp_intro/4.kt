package f_01_fp_intro.s_4

fun sum(a: Int, b: Int) = (a..b).fold(0, Int::plus)

fun product(a: Int, b: Int) = (a..b).fold(1, Int::times)
