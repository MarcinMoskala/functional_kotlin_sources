package f_08_collections_processing_6_grouping.s_3

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
