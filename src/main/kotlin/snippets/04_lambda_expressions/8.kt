package f_04_lambda_expressions.s_8

fun sum(a: Int, b: Int) = (a..b).fold(0) { acc, i -> acc + i }

fun product(a: Int, b: Int) = (a..b).fold(1) { acc, i -> acc * i }
