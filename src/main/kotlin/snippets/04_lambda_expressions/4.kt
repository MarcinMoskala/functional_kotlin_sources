package f_04_lambda_expressions.s_4

fun produceFun() = { 42 }
fun produceNum() = 42

fun main() {
    val f = produceFun()
    println(f()) // 42

    println(produceNum()) // 42
}
