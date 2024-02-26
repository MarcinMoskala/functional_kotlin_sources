package f_05_function_references.s_6

fun sum(a: Int, b: Int) =
   (a..b).fold(0, Int::plus)

fun product(a: Int, b: Int) =
   (a..b).fold(1, Int::times)
