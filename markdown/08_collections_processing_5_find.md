```
//1
fun main() {
    val c = ('a'..'z').toList()

    println(c.first()) // a
    println(c.last()) // z
    println(c.get(3)) // d
    println(c[3]) // d
    val (c1, c2, c3) = c
    println(c1) // a
    println(c2) // b
    println(c3) // c
}
```


```
//2
fun main() {
    val c = listOf<Char>()

    println(c.firstOrNull()) // null
    println(c.lastOrNull()) // null
    println(c.getOrNull(3)) // null
}
```


```
fun getUser(id: String): User? =
    users.find { it.id == id }

fun findConfiguration(name: String): Configuration? =
    configurations.find { it.name == name }
```


```
//3
fun main() {
    val names = listOf("Cookie", "Figa")

    println(names.find { it.first() == 'A' }) // null
    println(names.firstOrNull { it.first() == 'A' }) // null
    println(names.find { it.first() == 'C' }) // Cookie
    println(names.firstOrNull { it.first() == 'C' }) // Cookie

    println(listOf(1, 2, 6, 11).find { it in 2..10 }) // 2
}
```


```
//4
fun main() {
    val names = listOf("C1", "C2")

    println(names.find { it.first() == 'C' }) // C1
    println(names.firstOrNull { it.first() == 'C' }) // C1
    println(names.findLast { it.first() == 'C' }) // C2
    println(names.lastOrNull { it.first() == 'C' }) // C2
}
```


```
//5
fun main() {
    val range = (1..100 step 3)
    println(range.count()) // 34
}
```


```
val premiumUsersCount = users
    .count { it.hasPremium }

val qualifiedNum = students
    .count { qualifiesForInternship(it) }
```


```
//6
fun main() {
    val range = (1..100 step 3)
    println(range.count { it % 5 == 0 }) // 7
}
```


```
//7
data class Person(
    val name: String,
    val age: Int,
    val male: Boolean
)

fun main() {
    val people = listOf(
        Person("Alice", 31, false),
        Person("Bob", 29, true),
        Person("Carol", 31, true)
    )

    fun isAdult(p: Person) = p.age > 18
    fun isChild(p: Person) = p.age < 18
    fun isMale(p: Person) = p.male
    fun isFemale(p: Person) = !p.male

    // Is there an adult?
    println(people.any(::isAdult)) // true
    // Are they all adults?
    println(people.all(::isAdult)) // true
    // Is none of them an adult?
    println(people.none(::isAdult)) // false

    // Is there any child?
    println(people.any(::isChild)) // false
    // Are they all children?
    println(people.all(::isChild)) // false
    // Are none of them children?
    println(people.none(::isChild)) // true

    // Are there any males?
    println(people.any { isMale(it) }) // true
    // Are they all males?
    println(people.all { isMale(it) }) // false
    // Is none of them a male?
    println(people.none { isMale(it) }) // false

    // Are there any females?
    println(people.any { isFemale(it) }) // true
    // Are they all females?
    println(people.all { isFemale(it) }) // false
    // Is none of them a female?
    println(people.none { isFemale(it) }) // false
}
```


```
//8
fun main() {
    val emptyList = emptyList<String>()
    println(emptyList.any { error("Ignored") }) // false
    println(emptyList.all { error("Ignored") }) // true
    println(emptyList.none { error("Ignored") }) // true
}
```