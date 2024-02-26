```
// withIndex implementation from Kotlin stdlib
fun <T> Iterable<T>.withIndex(): Iterable<IndexedValue<T>> =
    IndexingIterable { iterator() }

data class IndexedValue<out T>(
    val index: Int,
    val value: T
)
```


```
//1
fun main() {
    listOf("A", "B", "C", "D") // List<String>
        .withIndex() // List<IndexedValue<String>>
        .filter { (index, value) -> index % 2 == 0 }
        .map { (index, value) -> "[$index] $value" }
        .forEach { println(it) }
}
// [0] A
// [2] C
```


```
//2
fun main() {
    val chars = listOf("A", "B", "C", "D")

    val filtered = chars
        .filterIndexed { index, value -> index % 2 == 0 }
    println(filtered) // [A, C]

    val mapped = chars
        .mapIndexed { index, value -> "[$index] $value" }
    println(mapped) // [[0] A, [1] B, [2] C, [3] D]
}
```


```
//3
fun main() {
    val chars = listOf("A", "B", "C", "D")

    val r1 = chars.withIndex()
        .filter { (index, value) -> index % 2 == 0 }
        .map { (index, value) -> "[$index] $value" }
    println(r1) // [[0] A, [2] C]

    val r2 = chars
        .filterIndexed { index, value -> index % 2 == 0 }
        .mapIndexed() { index, value -> "[$index] $value" }
    println(r2) // [[0] A, [1] C]
}
```