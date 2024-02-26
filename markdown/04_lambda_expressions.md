```
//1
fun main() {
    val f: () -> Unit = {}
    f()
    // or f.invoke()
}
```


```
//2
fun main() {
    {
        println("AAA")
    }
}
```


```
//3
fun produce() = { 42 }

fun main() {
    println(produce()) // ???
}
```


```
//4
fun produceFun() = { 42 }
fun produceNum() = 42

fun main() {
    val f = produceFun()
    println(f()) // 42
    println(produceFun()()) // 42
    println(produceFun().invoke()) // 42

    println(produceNum()) // 42
}
```


```
//5
fun main() {
    val printTimes = { text: String, times: Int ->
        for (i in 1..times) {
            print(text)
        }
    } // the type is (text: String, times: Int) -> Unit
    printTimes("Na", 7) // NaNaNaNaNaNaNa
    printTimes.invoke("Batman", 2) // BatmanBatman
}
```


```
fun setOnClickListener(listener: (View, Click) -> Unit) {}

fun main() {
    setOnClickListener({ view, click ->
        println("Clicked")
    })
}
```


```
setOnClickListener({ _, _ ->
    println("Clicked")
})
```


```
//6
data class User(val name: String, val surname: String)
data class Element(val id: Int, val type: String)

fun setOnClickListener(listener: (User, Element) -> Unit) {}

fun main() {
    setOnClickListener({ (name, surname), (id, type) ->
        println(
            "User $name $surname clicked " +
            "element $id of type $type"
        )
    })
}
```


```
//7
inline fun <R> run(block: () -> R): R = block()

inline fun repeat(times: Int, block: (Int) -> Unit) {
    for (i in 0 until times) {
        block(i)
    }
}

fun main() {
    run({ println("A") }) // A
    run() { println("A") } // A
    run { println("A") } // A

    repeat(2, { print("B") }) // BB
    println()
    repeat(2) { print("B") } // BB
}
```


```
setOnClickListener { _, _ ->
    println("Clicked")
}
```


```
fun sum(a: Int, b: Int) = (a..b).fold(0) { acc, i -> acc + i }

fun product(a: Int, b: Int) = (a..b).fold(1) { acc, i -> acc * i }
```


```
//8
fun call(before: () -> Unit = {}, after: () -> Unit = {}) {
    before()
    print("A")
    after()
}

fun main() {
    call({ print("C") })
    call { print("B") }
}
```


```
fun main() {
    call(before = { print("C") })
    call(after = { print("B") })
}
```


```
//9
fun main() {
    val f = {
        10
        20
        30
    }
    println(f()) // 30
}
```


```
fun main() {
    onUserChanged { user ->
        if (user == null) return // compilation error
        cheerUser(user)
    }
}
```


```
fun main() {
    onUserChanged someLabel@{ user ->
        if (user == null) return@someLabel
        cheerUser(user)
    }
}
```


```
fun main() {
    onUserChanged { user ->
        if (user == null) return@onUserChanged
        cheerUser(user)
    }
}
```


```
//10
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
```


```
//11
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
```


```
val cheer = {
    println("Hello")
}
val printNumber = { i: Int ->
    println(i)
}
val log = { ctx: String, message: String ->
    println("[$ctx] $message")
}
val makeAdmin = { User(id = 0) }
val add = { s1: String, s2: String -> s1 + s2 }
val toName = { name: String -> Name(name) }
```


```
val printNumber: (Int) -> Unit = { i ->
    println(i)
}
val log: (String, String) -> Unit = { ctx, message ->
    println("[$ctx] $message")
}
val add: (String, String) -> String = { s1, s2 -> s1 + s2 }
val toName: (String) -> Name = { name -> Name(name) }
```


```
val printNumber: (Int) -> Unit = { println(it) }
val toName: (String) -> Name = { Name(it) }

// Real-life example, functions will be explained later
val newsItemAdapters = news
    .filter { it.visible }
    .sortedByDescending { it.publishedAt }
    .map { it.toNewsItemAdapter() }
```


```
//12
fun makeCounter(): () -> Int {
    var i = 0
    return { i++ }
}

fun main() {
    val counter1 = makeCounter()
    val counter2 = makeCounter()

    println(counter1()) // 0
    println(counter1()) // 1
    println(counter2()) // 0
    println(counter1()) // 2
    println(counter1()) // 3
    println(counter2()) // 1
}
```


```
val processor = label@{ data: String ->
    if (data.isEmpty()) {
        return@label null
    }

    data.uppercase()
}

val processor = fun(data: String): String? {
    if (data.isEmpty()) {
        return null
    }

    return data.uppercase()
}
```