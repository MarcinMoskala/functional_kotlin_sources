```
// partition implementation from Kotlin stdlib
inline fun <T> Iterable<T>.partition(
    predicate: (T) -> Boolean
): Pair<List<T>, List<T>> {
    val first = ArrayList<T>()
    val second = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            first.add(element)
        } else {
            second.add(element)
        }
    }
    return Pair(first, second)
}
```


```
//1
fun main() {
    val nums = listOf(1, 2, 6, 11)
    val partitioned: Pair<List<Int>, List<Int>> =
        nums.partition { it in 2..10 }
    println(partitioned) // ([2, 6], [1, 11])

    val (inRange, notInRange) = partitioned
    println(inRange) // [2, 6]
    println(notInRange) // [1, 11]
}
```


```
//2
fun main() {
    val nums = (1..10).toList()

    val (smaller, bigger) = nums.partition { it <= 5 }
    println(smaller) // [1, 2, 3, 4, 5]
    println(bigger) // [6, 7, 8, 9, 10]

    val (even, odd) = nums.partition { it % 2 == 0 }
    println(even) // [2, 4, 6, 8, 10]
    println(odd) // [1, 3, 5, 7, 9]

    data class Student(val name: String, val passing: Boolean)

    val students = listOf(
        Student("Alex", true),
        Student("Ben", false),
    )
    val (passing, failed) = students.partition { it.passing }
    println(passing) // [Student(name=Alex, passing=true)]
    println(failed) // [Student(name=Ben, passing=false)]
}
```


```
// groupBy implementation from Kotlin stdlib
inline fun <T, K> Iterable<T>.groupBy(
    keySelector: (T) -> K
): Map<K, List<T>> {
    val destination = LinkedHashMap<K, MutableList<T>>()
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { 
            ArrayList<T>() 
        }
        list.add(element)
    }
    return destination
}
```


```
//3
fun main() {
    val names = listOf("Marcin", "Maja", "Cookie")

    val byCapital = names.groupBy { it.first() }
    println(byCapital)
    // {M=[Marcin, Maja], C=[Cookie]}

    val byLength = names.groupBy { it.length }
    println(byLength)
    // {6=[Marcin, Cookie], 4=[Maja]}
}
```


```
// Count the number of users in each city
val usersCount: Map<City, Int> = users
    .groupBy { it.city }
    .mapValues { (_, users) -> users.size }

// Find the number of points received by each team
val pointsPerTeam: Map<Team, Int> = players
    .groupBy { it.team }
    .mapValues { (_, players) ->
        players.sumOf { it.points }
    }

// Find the best resolution in each category
val bestResolutionPerQuality: Map<Quality, Resolution> =
    formats.groupBy { it.quality }
        .mapValues { (_, formats) ->
            formats.maxOf { it.resolution }
        }
```


```
//4
data class Player(val name: String, val team: String)

fun main() {
    val players = listOf(
        Player("Alex", "A"),
        Player("Ben", "B"),
        Player("Cal", "A"),
    )
    val grouped = players.groupBy { it.team }
    println(grouped)
    // {A=[Player(name=Alex, team=A),
    //     Player(name=Cal, team=A)],
    // B=[Player(name=Ben, team=B)]}
    println(grouped.flatMap { it.value })
    // [Player(name=Alex, team=A), Player(name=Cal, team=A),
    // Player(name=Ben, team=B)]
}
```