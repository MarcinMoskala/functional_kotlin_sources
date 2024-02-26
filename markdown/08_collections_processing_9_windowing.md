```
//1
fun main() {
    val nums = 1..4
    val chars = 'A'..'F'
    println(nums.zip(chars))
    // [(1, A), (2, B), (3, C), (4, D)]

    val winner = listOf("Ashley", "Barbara", "Cyprian", "David")
    val prizes = listOf(5000, 3000, 1000)
    val zipped = winner.zip(prizes)
    println(zipped)
    // [(Ashley, 5000), (Barbara, 3000), (Cyprian, 1000)]
    zipped.forEach { (person, price) ->
        println("$person won $price")
    }
    // Ashley won 5000
    // Barbara won 3000
    // Cyprian won 1000
}
```


```
//2
fun main() {
    // zip can be used with infix notation
    val zipped = (1..4) zip ('a'..'d')
    println(zipped) // [(1, a), (2, b), (3, c), (4, d)]
    val (numbers, letters) = zipped.unzip()
    println(numbers) // [1, 2, 3, 4]
    println(letters) // [a, b, c, d]
}
```


```
//3
fun main() {
    println((1..4).zipWithNext())
    // [(1, 2), (2, 3), (3, 4)]

    val person = listOf("Ashley", "Barbara", "Cyprian")
    println(person.zipWithNext())
    // [(Ashley, Barbara), (Barbara, Cyprian)]
}
```


```
//4
fun main() {
    val person = listOf("A", "B", "C", "D", "E")
    println(person.zipWithNext { prev, next -> "$prev$next" })
    // [AB, BC, CD, DE]
}
```


```
//5
fun main() {
    val person = listOf("Ashley", "Barbara", "Cyprian", "David")
    println(person.windowed(size = 1, step = 1))
    // [[Ashley], [Barbara], [Cyprian], [David]]
    // so similar to map { listOf(it) }

    println(person.windowed(size = 2, step = 1))
    // [[Ashley, Barbara], [Barbara, Cyprian],
    // [Cyprian, David]]
    // so similar to zipWithNext().map { it.toList() }

    println(person.windowed(size = 1, step = 2))
    // [[Ashley], [Cyprian]]

    println(person.windowed(size = 2, step = 2))
    // [[Ashley, Barbara], [Cyprian, David]]

    println(person.windowed(size = 3, step = 1))
    // [[Ashley, Barbara, Cyprian], [Barbara, Cyprian, David]]

    println(person.windowed(size = 3, step = 2))
    // [[Ashley, Barbara, Cyprian]]

    println(
        person.windowed(
            size = 3,
            step = 1,
            partialWindows = true
        )
    )
    // [[Ashley, Barbara, Cyprian], [Barbara, Cyprian, David],
    // [Cyprian, David], [David]]

    println(
        person.windowed(
            size = 3,
            step = 2,
            partialWindows = true
        )
    )
    // [[Ashley, Barbara, Cyprian], [Cyprian, David]]
}
```


```
//6
// chunked implementation from Kotlin stdlib
fun <T> Iterable<T>.chunked(size: Int): List<List<T>> =
    windowed(size, size, partialWindows = true)
```


```
//7
fun main() {
    val person = listOf("Ashley", "Barbara", "Cyprian", "David")
    println(person.chunked(1))
    // [[Ashley], [Barbara], [Cyprian], [David]]

    println(person.chunked(2))
    // [[Ashley, Barbara], [Cyprian, David]]

    println(person.chunked(3))
    // [[Ashley, Barbara, Cyprian], [David]]

    println(person.chunked(4))
    // [[Ashley, Barbara, Cyprian, David]]
}
```