```
//1
// a regular function named add1
fun add1(a: Int, b: Int) = a + b

// an anonymous function stored in a property named add2
val add2 = fun(a: Int, b: Int): Int {
    return a + b
}
```


```
//2
val add2 = fun(a: Int, b: Int) = a + b
```


```
// Error! Generic anonymous functions are not supported
val f = fun <T> (a: T): T = a // COMPILATION ERROR
```


```
//3
import kotlin.*

data class User(val id: Int)
data class Name(val name: String)

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
    
    val makeAdmin: () -> User = fun() = User(id = 0)
    println(makeAdmin()) // User(id=0)

    val add: (String, String) -> String =
        fun(s1: String, s2: String): String {
            return s1 + s2
        }
    println(add.invoke("A", "B")) // AB
    println(add("C", "D")) // CD
    
    val toName: (String) -> Name = fun(name: String) = Name(name)
    val name: Name = toName("Cookie")
    println(name) // Name(name=Cookie)
}
```


```
val cheer = fun() {
    println("Hello")
}
val printNumber = fun(i: Int) {
    println(i)
}
val log = fun(ctx: String, message: String) {
    println("[$ctx] $message")
}
val makeAdmin = fun() = User(id = 0)
val add = fun(s1: String, s2: String): String {
    return s1 + s2
}
val toName = fun(name: String) = Name(name)
```


```
val printNumber: (Int) -> Unit = fun(i) {
    println(i)
}
val log: (String, String) -> Unit = fun(ctx, message) {
    println("[$ctx] $message")
}
val add: (String, String) -> String = fun(s1, s2): String {
    return s1 + s2
}
val toName: (String) -> Name = fun(name) = Name(name)
```