package f_04_lambda_expressions.s_11

fun main() {
    val magicSquare = listOf(
        listOf(2, 7, 6),
        listOf(9, 5, 1),
        listOf(4, 3, 8),
    )
    magicSquare.forEach line@ { line ->
        var sum = 0
        line.forEach { elem ->
            sum += elem
            if (sum == 15) {
                return@line
            }
        }
        print("Line $line not correct")
    }
}
