```
val size = File("huge.file").readLines()
    .sumOf { it.length }
```


```
val size = File("huge.file").useLines { s ->
    s.sumOf { it.length }
}
```


```
interface Iterable<out T> {
    operator fun iterator(): Iterator<T>
}

interface Sequence<out T> {
    operator fun iterator(): Iterator<T>
}
```


```
public inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T> {
    return filterTo(ArrayList<T>(), predicate)
}

public fun <T> Sequence<T>.filter(
    predicate: (T) -> Boolean
): Sequence<T> {
    return FilteringSequence(this, true, predicate)
}
```


```
//1
fun main() {
    val seq = sequenceOf(1, 2, 3)
    val filtered = seq.filter { print("f$it "); it % 2 == 1 }
    println(filtered)  // FilteringSequence@...

    val asList = filtered.toList() // terminal operation
    // f1 f2 f3
    println(asList) // [1, 3]

    val list = listOf(1, 2, 3)
    val listFiltered = list
        .filter { print("f$it "); it % 2 == 1 }
    // f1 f2 f3
    println(listFiltered) // [1, 3]
}
```


```
//2
fun main() {
    listOf(1, 2, 3)
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
        .forEach { print("E$it, ") }
    // Prints: F1, F2, F3, M1, M3, E2, E6,
}
```


```
//3
fun main() {
    sequenceOf(1, 2, 3)
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
        .forEach { print("E$it, ") }
    // Prints: F1, M1, E2, F2, F3, M3, E6,
}
```


```
//4
fun main() {
    for (e in listOf(1, 2, 3)) {
        print("F$e, ")
        if (e % 2 == 1) {
            print("M$e, ")
            val mapped = e * 2
            print("E$mapped, ")
        }
    }
    // Prints: F1, M1, E2, F2, F3, M3, E6,
}
```


```
//5
fun main() {
    val resI = (1..10).asIterable()
        .map { print("M$it "); it * it }
        .find { print("F$it "); it > 3 }
    println(resI) // M1 M2 M3 M4 M5 M6 M7 M8 M9 M10 F1 F4 4

    val resS = (1..10).asSequence()
        .map { print("M$it "); it * it }
        .find { print("F$it "); it > 3 }
    println(resS) // M1 F1 M2 F4 4
}
```


```
//6
fun main() {
    (1..10).asSequence()
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
        .find { it > 5 }
    // Prints: F1, M1, F2, F3, M3,

    (1..10)
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
        .find { it > 5 }
    // Prints: F1, F2, F3, F4, F5, F6, F7, F8, F9, F10,
    // M1, M3, M5, M7, M9,
}
```


```
//7
fun main() {
    val s = (1..6).asSequence()
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }

    s.find { it > 3 } // F1, M1, F2, F3, M3,
    println()
    s.find { it > 3 } // F1, M1, F2, F3, M3,
    println()
    s.find { it > 3 } // F1, M1, F2, F3, M3,
    println()

    val l = (1..6)
        .filter { print("F$it, "); it % 2 == 1 }
        .map { print("M$it, "); it * 2 }
    // F1, F2, F3, F4, F5, F6, M1, M3, M5,

    l.find { it > 3 } // prints nothing
    l.find { it > 3 } // prints nothing
    l.find { it > 3 } // prints nothing
}
```


```
//8
fun main() {
    generateSequence(1) { it + 1 }
        .map { it * 2 }
        .take(10)
        .forEach { print("$it, ") }
    // Prints: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20,
}
```


```
//9
import java.math.BigInteger

val fibonacci: Sequence<BigInteger> = sequence {
    var current = 1.toBigInteger()
    var prev = 0.toBigInteger()
    yield(prev)
    while (true) {
        yield(current)
        val temp = prev
        prev = current
        current += temp
    }
}

fun main() {
    print(fibonacci.take(10).toList())
    // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
}
```


```
print(fibonacci.toList()) // Runs forever
```


```
val numbers = List(1_000_000) { it }

numbers
    .filter { it % 10 == 0 } // 1 collection here
    .map { it * 2 } // 1 collection here
    .sum()
// In total, 2 collections created under the hood

numbers
    .asSequence()
    .filter { it % 10 == 0 }
    .map { it * 2 }
    .sum()
// No collections created
```


```
// BAD SOLUTION, DO NOT USE COLLECTIONS FOR
// POSSIBLY BIG FILES
File("ChicagoCrimes.csv")
    .readLines() // returns List<String>
    .drop(1) // Drop labels
    .mapNotNull { it.split(",").getOrNull(6) }
    // Find description
    .filter { "CANNABIS" in it }
    .count()
    .let(::println)
```


```
File("ChicagoCrimes.csv").useLines { lines ->
// The type of `lines` is Sequence<String>
    lines.drop(1) // Drop first line (header)
        .mapNotNull { it.split(",").getOrNull(6) }
        // Find description
        .filter { "CANNABIS" in it }
        .count()
        .let { println(it) } // 318185
}
```


```
fun singleStepListProcessing(): List<Product> {
    return productsList.filter { it.bought }
}

fun singleStepSequenceProcessing(): List<Product> {
    return productsList.asSequence()
        .filter { it.bought }
        .toList()
}
```


```
fun multipleStepsListProcessing(): List<ProductDto> {
    return productsList
        .filter { it.bought }
        .map { it.productDto() }
}

fun multipleStepsSequenceProcessing(): List<ProductDto> {
    return productsList.asSequence()
        .filter { it.bought }
        .map { it.productDto() }
        .toList()
}
```


```
generateSequence(0) { it + 1 }.take(10).sorted().toList()
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
generateSequence(0) { it + 1 }.sorted().take(10).toList()
// Infinite time. Does not return.
```


```
productsList.asSequence()
    .filter { it.bought }
    .map { it.price }
    .sorted()
    .take(10)
    .sum()
```


```
productsList.asSequence()
    .filter { it.bought }
    .map { it.price }
    .average()

productsList.stream()
    .filter { it.bought }
    .mapToDouble { it.price }
    .average()
    .orElse(0.0)
```