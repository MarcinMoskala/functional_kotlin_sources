package f_02_function_types.s_4

// DON'T DO THAT! Misleading and false type safety
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
