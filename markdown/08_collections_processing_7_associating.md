```
// associate simplified implementation from Kotlin stdlib
inline fun <T, K, V> Iterable<T>.associate(
    transform: (T) -> Pair<K, V>
): Map<K, V> {
    val destination = LinkedHashMap<K, V>(initialCapacity())
    for (element in this) {
        destination += transform(element)
    }
    return destination
}

// associateBy simplified implementation from Kotlin stdlib
inline fun <T, K> Iterable<T>.associateBy(
    keySelector: (T) -> K
): Map<K, T> {
    val destination = LinkedHashMap<K, V>(initialCapacity())
    for (element in this) {
        destination.put(keySelector(element), element)
    }
    return destination
}

// associateWith simplified implementation from Kotlin stdlib
public inline fun <K, V> Iterable<K>.associateWith(
    valueSelector: (K) -> V
): Map<K, V> {
    val destination = LinkedHashMap<K, V>(initialCapacity())
    for (element in this) {
        destination.put(element, valueSelector(element))
    }
    return destination
}
```


```
//1
fun main() {
    val names = listOf("Alex", "Ben", "Cal")
    println(names.associate { it.first() to it.drop(1) })
    // {A=lex, B=en, C=al}
    println(names.associateWith { it.length })
    // {Alex=4, Ben=3, Cal=3}
    println(names.associateBy { it.first() })
    // {A=Alex, B=Ben, C=Cal}
}
```


```
//2
fun main() {
    val names = listOf("Alex", "Aaron", "Ada")
    println(names.associateBy { it.first() })
    // {A=Ada}
    println(names.groupBy { it.first() })
    // {A=[Alex, Aaron, Ada]}
}
```


```
//3
fun main() {
    val names = listOf("Alex", "Ben", "Cal")
    val aW = names.associateWith { it.length }
    println(aW.keys.toList() == names) // true
    val aB = names.associateBy { it.first() }
    println(aB.values.toList() == names) // true
}
```


```
fun produceUserOffers(
    offers: List<Offer>,
    users: List<User>
): List<UserOffer> {
    //
    val usersById = users.associateBy { it.id }
    return offers
        .map { createUserOffer(it, usersById[it.buyerId]) }
}
```


```
//4
// distinct implementation from Kotlin stdlib
fun <T> Iterable<T>.distinct(): List<T> {
    return this.toMutableSet().toList()
}

inline fun <T, K> Iterable<T>.distinctBy(
    selector: (T) -> K
): List<T> {
    val set = HashSet<K>()
    val list = ArrayList<T>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}
```


```
//5
fun main() {
    val list: List<Int> = listOf(1, 2, 4, 2, 3, 1)
    val set: Set<Int> = list.toSet()
    println(set) // [1, 2, 4, 3]
}
```


```
//6
fun main() {
    val numbers = listOf(1, 2, 4, 2, 3, 1)
    println(numbers) // [1, 2, 4, 2, 3, 1]
    println(numbers.distinct()) // [1, 2, 4, 3]

    val names = listOf("Marta", "Maciek", "Marta", "Daniel")
    println(names) // [Marta, Maciek, Marta, Daniel]
    println(names.distinct()) // [Marta, Maciek, Daniel]
}
```


```
//7
fun main() {
    val names = listOf("Marta", "Maciek", "Marta", "Daniel")
    println(names) // [Marta, Maciek, Marta, Daniel]
    println(names.distinctBy { it[0] }) // [Marta, Daniel]
    println(names.distinctBy { it.length }) // [Marta, Maciek]
}
```


```
//8
fun main() {
    val names = listOf("Marta", "Maciek", "Daniel")
    println(names)
    // [Marta, Maciek, Daniel]
    println(names.distinctBy { it.length })
    // [Marta, Maciek]
    println(names.associateBy { it.length }.values)
    // [Marta, Daniel]
}
```


```
//9
data class Person(val id: Int, val name: String) {
    override fun toString(): String = "$id: $name"
}

fun main() {
    val people = listOf(
        Person(0, "Alex"),
        Person(1, "Ben"),
        Person(1, "Carl"),
        Person(2, "Ben"),
        Person(0, "Alex"),
    )
    println(people.distinct())
    // [0: Alex, 1: Ben, 1: Carl, 2: Ben]
    println(people.distinctBy { it.id })
    // [0: Alex, 1: Ben, 2: Ben]
    println(people.distinctBy { it.name })
    // [0: Alex, 1: Ben, 1: Carl]
}
```