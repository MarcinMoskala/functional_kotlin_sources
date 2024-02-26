package f_08_collections_processing_5_find.s_7

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
