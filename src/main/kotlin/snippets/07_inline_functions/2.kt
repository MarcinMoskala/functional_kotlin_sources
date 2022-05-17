package f_07_inline_functions.s_2

class Student(val points: Int)
val students = listOf<Student>()

fun main() {
    var points = 0
    for (student in students) {
        points += student.points
    }
    println(points)
}
