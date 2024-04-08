package f_02_function_types.s_4

typealias Minutes = Int
typealias Seconds = Int

fun decideAboutTime(): Minutes = 10
fun setupTimer(time: Seconds) { 
    /*...*/
}

fun main() {
    val time = decideAboutTime()
    setupTimer(time)
}
