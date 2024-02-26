```
//1
fun main() {
    println(listOf(4, 1, 3, 2).sorted())
    // [1, 2, 3, 4]

    println(listOf('b', 'A', 'a', ' ', 'B').sorted())
    // [ , A, B, a, b]

    println(listOf("Bab", "AAZ", "Bza", "A").sorted())
    // [A, AAZ, Bab, Bza]

    println(listOf(true, false, true).sorted())
    // [false, true, true]
}
```


```
//2
fun main() {
    println(listOf(4, 1, 3, 2).reversed())
    // [2, 3, 1, 4]
    println(listOf('C', 'B', 'F', 'A', 'D', 'E').reversed())
    // [E, D, A, F, B, C]
}
```


```
//3
fun main() {
    println(listOf(4, 1, 3, 2).sortedDescending())
    // [4, 3, 2, 1]
    println(listOf(4, 1, 3, 2).sorted().reversed())
    // [4, 3, 2, 1]

    println(
        listOf('b', 'A', 'a', ' ', 'B')
            .sortedDescending()
    )
    // [b, a, B, A,  ]

    println(
        listOf("Bab", "AAZ", "Bza", "A")
            .sortedDescending()
    )
    // [Bza, Bab, AAZ, A]

    println(listOf(true, false, true).sortedDescending())
    // [true, true, false]
}
```


```
// Sort students by the semester
students.sortedBy { it.semester }

// Sort students by surname
students.sortedBy { it.surname }
```


```
//4
fun main() {
    val names = listOf("Alex", "Bob", "Celine")

    // Sort by name length
    println(names.sortedBy { it.length })
    // [Bob, Alex, Celine]

    // Sort by last letter
    println(names.sortedBy { it.last() })
    // [Bob, Celine, Alex]
}
```


```
//5
fun main() {
    val names = listOf("Ben", "Bob", "Bass", "Alex")
    val sorted = names.sortedBy { it.first() }
    println(sorted) // [Alex, Ben, Bob, Bass]
}
```


```
//6
fun main() {
    val names = listOf("Alex", "Bob", "Celine")

    // Sort by name length
    println(names.sortedByDescending { it.length })
    // [Celine, Alex, Bob]

    // Sort by last letter
    println(names.sortedByDescending { it.last() })
    // [Alex, Celine, Bob]
}
```


```
// Users sorted by login
val usersSorted = users
    .sortedBy { it.login }

// News sorted starting from the newest
val newsFromLatest = news
    .sortedByDescending { it.publicationDate }

// News sorted starting from the oldest
val newsFromOldest = news
    .sortedBy { it.publicationDate }

// Tasks from the highest priority to the lowest
val tasksInOrder = tasks
    .sortedByDescending { it.priority }
```


```
fun main() {
    val people = listOf(
        Person(1, "Alex"),
        Person(null, "Ben"),
        Person(2, null),
    )
    println(people.sortedBy { it.id })
    // [null: Ben, 1: Alex, 2: null]
    println(people.sortedBy { it.name })
    // [2: null, 1: Alex, null: Ben]
}
```


```
//7
fun interface Comparator<T> {
    fun compare(a: T, b: T): Int
}
```


```
names.sortedWith(Comparator { o1, o2 ->
    when {
        o1.surname < o2.surname -> -1
        o1.surname > o2.surname -> 1
        o1.name < o2.name -> -1
        o1.name > o2.name -> 1
        else -> 0
    }
})
```


```
//8
data class FullName(val name: String, val surname: String) {
    override fun toString(): String = "$name $surname"
}

fun main() {
    val names = listOf(
        FullName("B", "B"),
        FullName("B", "A"),
        FullName("A", "A"),
        FullName("A", "B"),
    )

    println(names.sortedBy { it.name })
    // [A A, A B, B B, B A]
    println(names.sortedBy { it.surname })
    // [B A, A A, B B, A B]
    println(names.sortedWith(compareBy(
        { it.surname },
        { it.name }
    )))
    // [A A, B A, A B, B B]
    println(names.sortedWith(compareBy(
        { it.name },
        { it.surname }
    )))
    // [A A, A B, B A, B B]
}
```


```
return recommendations.sortedWith(
    compareBy(
        { it.blocked }, // blocked to the end
        { !it.favourite }, // favorite at the beginning
        { calculateScore(it) },
    )
)
```


```
class Student(
    val name: String,
    val surname: String,
    val score: Double,
    val year: Int,
) {

    companion object {
        val ALPHABETICAL_ORDER =
            compareBy<Student>({ it.surname }, { it.name })
        val BY_SCORE_ORDER =
            compareByDescending<Student> { it.score }
        val BY_YEAR_ORDER =
            compareByDescending<Student> { it.year }
    }
}

fun presentStudentsForYearBook() = students
    .sortedWith(
        Student.BY_YEAR_ORDER.then(Student.ALPHABETICAL_ORDER)
    )

fun presentStudentsForTopScores() = students
    .sortedWith(
        Student.BY_YEAR_ORDER.then(Student.BY_SCORE_ORDER)
    )
```


```
//9
fun main() {
    val list = listOf(4, 2, 3, 1)
    val sortedRes = list.sorted()
    // list.sort() is illegal
    println(list) // [4, 2, 3, 1]
    println(sortedRes) // [1, 2, 3, 4]

    val mutableList = mutableListOf(4, 2, 3, 1)
    val sortRes = mutableList.sort()
    println(mutableList) // [1, 2, 3, 4]
    println(sortRes) // kotlin.Unit
}
```


```
//10
fun main() {
    val numbers = listOf(1, 6, 2, 4, 7, 1)
    println(numbers.maxOrNull()) // 7
    println(numbers.minOrNull()) // 1
}
```


```
//11
data class Player(val name: String, val score: Int)

fun main() {
    val players = listOf(
        Player("Jake", 234),
        Player("Megan", 567),
        Player("Beth", 123),
    )

    println(players.maxByOrNull { it.score })
    // Player(name=Megan, score=567)
    println(players.minByOrNull { it.score })
    // Player(name=Beth, score=123)
}
```


```
//12
data class FullName(val name: String, val surname: String)

fun main() {
    val names = listOf(
        FullName("B", "B"),
        FullName("B", "A"),
        FullName("A", "A"),
        FullName("A", "B"),
    )

    println(
        names
            .maxWithOrNull(compareBy(
                { it.surname },
                { it.name }
            ))
    )
    // FullName(name=B, surname=B)
    println(
        names
            .minWithOrNull(compareBy(
                { it.surname },
                { it.name }
            ))
    )
    // FullName(name=A, surname=A)
}
```


```
//13
data class Player(val name: String, val score: Int)

fun main() {
    val players = listOf(
        Player("Jake", 234),
        Player("Megan", 567),
        Player("Beth", 123),
    )

    println(players.map { it.score }.maxOrNull()) // 567
    println(players.maxByOrNull { it.score }?.score) // 567
    println(players.maxOfOrNull { it.score }) // 567
    println(players.maxOf { it.score }) // 567

    println(players.map { it.score }.minOrNull()) // 123
    println(players.minByOrNull { it.score }?.score) // 123
    println(players.minOfOrNull { it.score }) // 123
    println(players.minOf { it.score }) // 123
}
```


```
//14
import kotlin.random.Random

fun main() {
    val range = (1..100)
    val list = range.toList()

    // `random` requires a collection
    println(list.random()) // random number from 1 to 100
    println(list.randomOrNull())
    // random number from 1 to 100

    println(list.random(Random(123))) // 7
    println(list.randomOrNull(Random(123))) // 7

    println(range.shuffled())
    // List with numbers in a random order
}
```


```
//15
data class Character(val name: String, val surname: String)

fun main() {
    val characters = listOf(
        Character("Tamara", "Kurczak"),
        Character("Earl", "Gey"),
        Character("Ryba", "Luna"),
        Character("Cookie", "DePies"),
    )
    println(characters.random())
    // A random character,
    // like Character(name=Ryba, surname=Luna)
    println(characters.shuffled())
    // List with characters in a random order
}
```