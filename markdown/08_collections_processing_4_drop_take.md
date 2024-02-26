```
//1
fun main() {
    val chars = ('a'..'z').toList()

    println(chars.take(10))
    // [a, b, c, d, e, f, g, h, i, j]
    println(chars.takeLast(10))
    // [q, r, s, t, u, v, w, x, y, z]
    println(chars.drop(10))
    // [k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
    println(chars.dropLast(10))
    // [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p]
}
```


```
//2
fun main() {
    val c = ('a'..'z').toList()

    println(c.take(10) == c.dropLast(c.size - 10)) // true
    println(c.takeLast(10) == c.drop(c.size - 10)) // true
    println(c.drop(10) == c.takeLast(c.size - 10)) // true
    println(c.dropLast(10) == c.take(c.size - 10)) // true
}
```


```
//3
fun main() {
    val c = ('a'..'z').toList()

    val n = 10
    val s = c.size
    println(c.take(n) == c.subList(0, n)) // true
    println(c.takeLast(n) == c.subList(s - n, s)) // true
    println(c.drop(n) == c.subList(n, s)) // true
    println(c.dropLast(n) == c.subList(0, s - n)) // true
}
```


```
//4
fun main() {
    val letters = listOf("a", "b", "c")
    println(letters.take(100)) // [a, b, c]
    println(letters.takeLast(100)) // [a, b, c]
    println(letters.drop(100)) // []
    println(letters.dropLast(100)) // []
    letters.subList(0, 4) // throws IndexOutOfBoundsException
}
```