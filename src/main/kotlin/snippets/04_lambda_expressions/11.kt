package f_04_lambda_expressions.s_11

import kotlin.*

fun main() {
    val cheer: () -> Unit = {
        println("Hello")
    }
    cheer.invoke() // Hello
    cheer() // Hello

    val printNumber: (Int) -> Unit = { i: Int ->
        println(i)
    }
    printNumber.invoke(10) // 10
    printNumber(20) // 20

    val log: (String, String) -> Unit =
        { ctx: String, message: String ->
            println("[$ctx] $message")
        }
    log.invoke("UserService", "Name changed")
    // [UserService] Name changed
    log("UserService", "Surname changed")
    // [UserService] Surname changed

    data class User(val id: Int)

    val makeAdmin: () -> User = { User(id = 0) }
    println(makeAdmin()) // User(id=0)

    val add: (String, String) -> String =
        { s1: String, s2: String -> s1 + s2 }
    println(add.invoke("A", "B")) // AB
    println(add("C", "D")) // CD

    data class Name(val name: String)

    val toName: (String) -> Name =
        { name: String -> Name(name) }
    val name: Name = toName("Cookie")
    println(name) // Name(name=Cookie)
}
