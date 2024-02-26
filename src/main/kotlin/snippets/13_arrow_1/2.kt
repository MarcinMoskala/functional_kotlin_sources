package f_13_arrow_1.s_2

val fibonacci = DeepRecursiveFunction<Int, Int> { x ->
    when {
        x < 0 -> 0
        x == 1 -> 1
        else -> callRecursive(x - 1) + callRecursive(x - 2)
    }
}
