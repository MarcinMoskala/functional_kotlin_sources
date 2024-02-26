```
val visibleNews = mutableListOf<News>()
for (n in news) {
   if (n.visible) {
       visibleNews.add(n)
   }
}

Collections.sort(visibleNews) { n1, n2 ->
   n2.publishedAt - n1.publishedAt
}
val newsItemAdapters = mutableListOf<NewsItemAdapter>()
for (n in visibleNews) {
   newsItemAdapters.add(NewsItemAdapter(n))
}
```


```
val newsItemAdapters = news
   .filter { it.visible }
   .sortedByDescending { it.publishedAt }
   .map(::NewsItemAdapter)
```


```
// forEach implementation from Kotlin stdlib
inline fun <T> Iterable<T>.forEach(action: (T) -> Unit) {
   for (element in this) action(element)
}

// simplified onEach implementation from Kotlin stdlib
inline fun <T, C : Iterable<T>> C.onEach(
   action: (T) -> Unit
): C {
   for (element in this) action(element)
   return this
}
```


```
// Without variable, this code would be hard to read
val messagesToSend = users.filter { it.isActive }
   .flatMap { it.remainingMessages }
   .filter { it.isToBeSent }
for (message in messagesToSend) {
   sendMessage(message)
}

// better
users.filter { it.isActive }
   .flatMap { it.remainingMessages }
   .filter { it.isToBeSent }
   .forEach { sendMessage(it) }
```


```
users
   .filter { it.isActive }
   .onEach { log("Sending messages for user $it") }
   .flatMap { it.remainingMessages }
   .filter { it.isToBeSent }
   .forEach { sendMessage(it) }
```


```
// simplified filter implementation from Kotlin stdlib
inline fun <T> Iterable<T>.filter(
   predicate: (T) -> Boolean
): List<T> {
   val destination = ArrayList<T>()
   for (element in this) {
       if (predicate(element)) {
           destination.add(element)
       }
   }
   return destination
}
```


```
val activeUsers = users
   .filter { it.isActive }

val publicArticles = articles
   .filter { it.visibility == PUBLIC }
```


```
//1
fun main() {
   val old = listOf(1, 2, 6, 11)
   val new = old.filter { it in 2..10 }
   println(new) // [2, 6]
}
```


```
//2
fun main() {
   val old = listOf(1, 2, 6, 11)
   val new = old.filterNot { it in 2..10 }
   println(new) // [1, 11]
}
```


```
// simplified map implementation from Kotlin stdlib
inline fun <T, R> Iterable<T>.map(
   transform: (T) -> R
): List<R> {
   val size = if (this is Collection<*>) this.size else 10
   val destination = ArrayList<R>(size)
   for (element in this) {
       destination.add(transform(element))
   }
   return destination
}
```


```
//3
fun main() {
   val old = listOf(1, 2, 3, 4)
   val new = old.map { it * it }
   println(new) // [1, 4, 9, 16]
}
```


```
//4
fun main() {
   val names: List<String> = listOf("Alex", "Bob", "Carol")
   val nameSizes: List<Int> = names.map { it.length }
   println(nameSizes) // [4, 3, 5]
}
```


```
// Make users that are 1 year older than before
val olderUsers = users
   .map { it.copy(age = it.age + 1) }

// Transform offers into offer views
val offerViews = offers
   .map { OfferView(it) }
```


```
// simplified mapNotNull implementation from Kotlin stdlib
inline fun <T, R> Iterable<T>.mapNotNull(
    transform: (T) -> R
): List<R> {
    val size = if (this is Collection<*>) this.size else 10
    val destination = ArrayList<R>(size)
    for (element in this) {
        val result = transform(element)
        if (result != null) destination.add(result)
    }
    return destination
}
```


```
//5
fun main() {
    val old = listOf("1", "A", "2", "3", "B", "4")
    println(old.mapNotNull { it.toIntOrNull() })
    // [1, 2, 3, 4]

    val numbers = listOf(-1, 2, -3, 4)
    println(numbers.mapNotNull { prod(it) })
    // [2, 24]
    println(numbers.mapNotNull { if (it > 0) it else null })
    // [2, 4]
}

fun prod(num: Int): Int? {
    if (num <= 0) return null
    // Can be simplified with fold, that we will learn later
    var res = 1
    for (i in 1..num) {
        res *= i
    }
    return res
}
```


```
// Transforming a list of products into their categories,
// but skipping those that do not have a category.
val categories: Set<Category> = products
    .mapNotNull { productCategories[it] }
    .toSet()

// Getting exchange urls from a list of exchanges, 
// but skipping those that cannot be found.
// toMap transforms a list of pairs into a map.
val exchangeUrls: Map<Exchange, String> = exchanges
    .mapNotNull { exchange ->
        val url = getExchangeUrl(exchange)
            ?: return@mapNotNull null
        exchange to url
    }
    .toMap()
```


```
// simplified flatMap implementation from Kotlin stdlib
inline fun <T, R> Iterable<T>.flatMap(
   transform: (T) -> Iterable<R>
): List<R> {
   val size = if (this is Collection<*>) this.size else 10
   val destination = ArrayList<R>(size)
   for (element in this) {
       destination.addAll(transform(element))
   }
   return destination
}
```


```
//6
fun main() {
   val old = listOf(1, 2, 3)
   val new = old.flatMap { listOf(it, it + 10) }
   println(new) // [1, 11, 2, 12, 3, 13]
}
```


```
//7
fun main() {
   val names = listOf("Ann", "Bob", "Cale")
   val chars1: List<Char> = names.flatMap { it.toList() }
   println(chars1) // [A, n, n, B, o, b, C, a, l, e]
   val mapRes: List<List<Char>> = names.map { it.toList() }
   println(mapRes) // [[A, n, n], [B, o, b], [C, a, l, e]]
   val chars2 = mapRes.flatten()
   println(chars2) // [A, n, n, B, o, b, C, a, l, e]
   println(chars1 == chars2) // true
}
```


```
val allStudents = schools
   .flatMap { it.students }

val allEmployees = department
   .flatMap { it.employees }
```