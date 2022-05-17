package f_07_inline_functions.s_1

class Student(val points: Int)
val students = listOf<Student>()

fun <T, R> Iterable<T>.fold(
    initial: R,
    operation: (acc: R, T) -> R
): R {
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
    }
    return accumulator
}

fun main() {
    val points = students.fold(0) { acc, s -> acc + s.points }
    println(points)
}
