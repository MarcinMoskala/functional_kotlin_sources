```
fun <T, R> Iterable<T>.fold(
    initial: R,
    operation: (acc: R, T) -> R
): R {
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
    }
    return accumulator
}

fun main() {
    val points = students.fold(0) { acc, s -> acc + s.points }
    println(points)
}
```


```
fun main() {
    var points = 0
    for (student in students) {
        points += student.points
    }
    println(points)
}
```


```
inline fun print(message: Any?) {
    System.out.print(message)
}

fun main() {
    print("A")
    print("B")
    print("C")
}

// under the hood becomes
fun main() {
    System.out.print("A")
    System.out.print("B")
    System.out.print("C")
}
```


```
//1
inline fun repeat(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(index)
    }
}

fun main() {
    repeat(10) {
        print(it)
    }
}
```


```
//2
fun main() {
    for (index in 0 until 10) {
        print(index)
    }
}
```


```
inline fun <T, R> Iterable<T>.fold(
    initial: R,
    operation: (acc: R, T) -> R
): R {
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
    }
    return accumulator
}

fun main() {
    val points = students.fold(0) { acc, s -> acc + s.points }
    println(points)
}

// under the hood compiled to
fun main() {
    var accumulator = 0
    for (element in students) {
        accumulator = accumulator + element.points
    }
    val points = accumulator
    println(points)
}
```


```
public inline fun <T, R> Iterable<T>.map(
    transform: (T) -> R
): List<R> {
    return mapTo(
        ArrayList<R>(collectionSizeOrDefault(10)),
        transform
    )
}

public inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}
```


```
//3
fun main() {
    repeat(7) {
        print("Na")
    }
    println(" Batman")
}
// NaNaNaNaNaNaNa Batman
```


```
//4
fun main() {
    for (i in 0 until 10) {
        if (i == 4) return // Returns from main
        print(i)
    }
}
// 0123
```


```
//5
fun main() {
    repeat(10) { index ->
        if (index == 4) return // Returns from main
        print(index)
    }
}
// 0123
```


```
//6
fun main() {
    for (index in 0 until 10) {
        if (index == 4) return // Returns from main
        print(index)
    }
}
// 0123
```


```
//7
fun main() {
    (0 until 19).forEach { index ->
        if (index == 4) return // Returns from main
        print(index)
    }
}
// 0123
```


```
inline fun requestNewToken(
    hasToken: Boolean,
    crossinline onRefresh: () -> Unit,
    noinline onGenerate: () -> Unit
) {
    if (hasToken) {
        httpCall("get-token", onGenerate) // We must use
        // noinline to pass function as an argument to a
        // function that is not inlined
    } else {
        httpCall("refresh-token") {
            onRefresh() // We must use crossinline to
            // inline function in a context where
            // non-local return is not allowed
            onGenerate()
        }
    }
}

fun httpCall(url: String, callback: () -> Unit) {
    /*...*/
}
```


```
any is List<Int> // Error
any is List<*> // OK
```


```
fun <T> printTypeName() {
    print(T::class.simpleName) // ERROR
}

fun <T> isOfType(value: Any): Boolean =
    value is T // ERROR
```


```
//8
inline fun <reified T> printTypeName() {
    print(T::class.simpleName)
}

fun main() {
    printTypeName<Int>() // Int
    printTypeName<Char>() // Char
    printTypeName<String>() // String
}
```


```
//9
fun main() {
    print(Int::class.simpleName) // Int
    print(Char::class.simpleName) // Char
    print(String::class.simpleName) // String
}
```


```
class Worker
class Manager

val employees: List<Any> = listOf(Worker(), Manager(), Worker())

val workers: List<Worker> = employees.filterIsInstance<Worker>()
```


```
inline fun <reified T : Any> String.fromJsonOrNull(): T? = try {
    gson.fromJson(this, T::class.java)
} catch (e: JsonSyntaxException) {
    null
}

// usage
val user: User? = userAsText.fromJsonOrNull()
```


```
// Koin module declaration
val myModule = module {
    single { Controller(get()) } // get is reified
    single { BusinessService() }
}

// Koin injection
val service: BusinessService by inject()
// inject is reified
```


```
val User.fullName: String
   get() = "$name $surname"

var User.birthday: Date
   get() = Date(birthdayMillis)
   set(value) {
       birthdayMillis = value.time
   }

// Under the hood is similar to:

fun getFullName(user: User) =
   "${user.name} ${user.surname}"

fun getBirthday(user: User) =
   Date(user.birthdayMillis)

fun setBirthday(user: User, value: Date) {
   user.birthdayMillis = value.time
}
```


```
//10
class User(val name: String, val surname: String) {
   inline val fullName: String get() = "$name $surname"
}

fun main() {
   val user = User("A", "B")
   println(user.fullName) // A B
   // during compilation changes to
   println("${user.name} ${user.surname}")
}
```


```
internal inline fun read() {
    val reader = Reader() // Error
    // ...
}

private class Reader {
    // ...
}
```