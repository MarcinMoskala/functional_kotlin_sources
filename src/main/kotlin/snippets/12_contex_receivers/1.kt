package f_12_contex_receivers.s_1

fun String.capitalize() = this
    .replaceFirstChar(Char::uppercase)

fun Iterable<Int>.product() = this
    .fold(1, Int::times)

fun main() {
    println("alex".capitalize()) // Alex
    println("this is text".capitalize()) // This is text
    println((1..5).product()) // 120
    println(listOf(1, 3, 5).product()) // 15
}
