package f_01_fp_intro.s_3

fun sum(a: Int, b: Int) =
    (a..b).fold(0) { acc, i -> acc + i }

fun product(a: Int, b: Int) =
    (a..b).fold(1) { acc, i -> acc * i }
