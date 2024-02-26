```
//1
// fold implementation from Kotlin stdlib
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
```


```
//2
fun main() {
    val numbers = listOf(1, 2, 3, 4)
    val sum = numbers.fold(0) { acc, i -> acc + i }
    println(sum) // 10
    val joinedString = numbers.fold("") { acc, i -> acc + i }
    println(joinedString) // 1234
    val product = numbers.fold(1) { acc, i -> acc * i }
    println(product) // 24
}
```


```
//3
// simplified `filter` implemented with `fold`
inline fun <T> Iterable<T>.filter(
    predicate: (T) -> Boolean
): List<T> = fold(emptyList()) { acc, e ->
    if (predicate(e)) acc + e else acc
}

// simplified `map` implemented with `fold`
inline fun <T, R> Iterable<T>.map(
    transform: (T) -> R
): List<R> = fold(emptyList()) { acc, e -> acc + transform(e) }

// simplified `flatMap` implemented with `fold`
inline fun <T, R> Iterable<T>.flatMap(
    transform: (T) -> Iterable<R>
): List<R> = fold(emptyList()) { acc, e -> acc + transform(e) }
```


```
//4
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    println(numbers.sum()) // 15
    println(numbers.joinToString(separator = "")) // 12345
}
```


```
//5
fun Iterable<Int>.product(): Int =
    fold(1) { acc, i -> acc * i }
```


```
//6
fun main() {
    val numbers = listOf(1, 2, 3, 4)
    println(numbers.fold(0) { acc, i -> acc + i }) 
    // 10
    println(numbers.scan(0) { acc, i -> acc + i })
    // [0, 1, 3, 6, 10]
    println(numbers.runningFold(0) { acc, i -> acc + i })
    // [0, 1, 3, 6, 10]

    println(numbers.fold("") { acc, i -> acc + i }) 
    // 1234
    println(numbers.scan("") { acc, i -> acc + i })
    // [, 1, 12, 123, 1234]
    println(numbers.runningFold("") { acc, i -> acc + i })
    // [, 1, 12, 123, 1234]

    println(numbers.fold(1) { acc, i -> acc * i }) 
    // 24
    println(numbers.scan(1) { acc, i -> acc * i })
    // [1, 1, 2, 6, 24]
    println(numbers.runningFold(1) { acc, i -> acc * i })
    // [1, 1, 2, 6, 24]
}
```


```
//7
// simplified reduce implementation from Kotlin stdlib
public inline fun <S, T : S> Iterable<T>.reduce(
    operation: (acc: S, T) -> S
): S {
    val iterator = this.iterator()
    if (!iterator.hasNext())
        throw UnsupportedOperationException(
            "Empty collection can't be reduced."
        )
    var accumulator: S = iterator.next()
    while (iterator.hasNext()) {
        accumulator = operation(accumulator, iterator.next())
    }
    return accumulator
}
```


```
//8
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    println(numbers.fold(0) { acc, i -> acc + i }) // 15
    println(numbers.reduce { acc, i -> acc + i }) // 15

    println(numbers.fold("") { acc, i -> acc + i }) // 12345
    // Here `reduce` cannot be used instead of `fold`

    println(numbers.fold(1) { acc, i -> acc * i }) // 120
    println(numbers.reduce { acc, i -> acc * i }) // 120
}
```


```
//9
// simplified sample sum implementation from Kotlin stdlib
fun Iterable<Int>.sum(): Int {
    var sum: Int = 0
    for (element in this) {
        sum += element
    }
    return sum
}

// simplified sample sumOf implementation from Kotlin stdlib
inline fun <T> Iterable<T>.sumOf(
    selector: (T) -> Int
): Int {
    var sum: Int = 0.toInt()
    for (element in this) {
        sum += selector(element)
    }
    return sum
}
```


```
//10
fun main() {
    val numbers = listOf(1, 6, 2, 4, 7, 1)
    println(numbers.sum()) // 21

    val doubles = listOf(0.1, 0.6, 0.2, 0.4, 0.7)
    println(doubles.sum()) // 1.9999999999999998
    // It is not 2, due to limited JVM double representation

    val bytes = listOf<Byte>(1, 4, 2, 4, 5)
    println(bytes.sum()) // 16
}
```


```
//11
import java.math.BigDecimal

data class Player(
    val name: String,
    val points: Int,
    val money: BigDecimal,
)

fun main() {
    val players = listOf(
        Player("Jake", 234, BigDecimal("2.30")),
        Player("Megan", 567, BigDecimal("1.50")),
        Player("Beth", 123, BigDecimal("0.00")),
    )

    println(players.map { it.points }.sum()) // 924
    println(players.sumOf { it.points }) // 924

    // Works for `BigDecimal` as well
    println(players.sumOf { it.money }) // 3.80
}
```