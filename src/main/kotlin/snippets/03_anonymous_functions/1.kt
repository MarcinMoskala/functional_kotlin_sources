package f_03_anonymous_functions.s_1

import kotlin.*

fun main() {
    val cheer: () -> Unit = fun() {
        println("Hello")
    }
    cheer.invoke() // Hello
    cheer() // Hello

    val printNumber: (Int) -> Unit = fun(i: Int) {
        println(i)
    }
    printNumber.invoke(10) // 10
    printNumber(20) // 20

    val log: (String, String) -> Unit =
        fun(ctx: String, message: String) {
            println("[$ctx] $message")
        }
    log.invoke("UserService", "Name changed")
    // [UserService] Name changed
    log("UserService", "Surname changed")
    // [UserService] Surname changed

    data class User(val id: Int)

    val makeAdmin: () -> User = fun() = User(id = 0)
    println(makeAdmin()) // User(id=0)

    val add: (String, String) -> String =
        fun(s1: String, s2: String): String {
            return s1 + s2
        }
    println(add.invoke("A", "B")) // AB
    println(add("C", "D")) // CD

    data class Name(val name: String)

    val toName: (String) -> Name =
        fun(name: String) = Name(name)
    val name: Name = toName("Cookie")
    println(name) // Name(name=Cookie)
}
