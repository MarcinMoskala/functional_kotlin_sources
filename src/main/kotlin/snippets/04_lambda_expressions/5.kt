package f_04_lambda_expressions.s_5

fun main() {
    val printTimes = { text: String, times: Int ->
        for (i in 1..times) {
            print(text)
        }
    } // the type is (text: String, times: Int) -> Unit
    printTimes("Na", 7) // NaNaNaNaNaNaNa
    printTimes.invoke("Batman", 2) // BatmanBatman
}
