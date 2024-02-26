package f_01_fp_intro_2.s_5

fun sum(a: Int, b: Int) = (a..b).sum()

fun product(a: Int, b: Int) = (a..b).fold(1, Int::times)
