package f_05_function_references.s_6

class TeamPoints(val points: List<Int>) {
   fun <T> calculatePoints(operation: (List<Int>) -> T): T =
       operation(points)
}

fun main() {
   val teamPoints = TeamPoints(listOf(1, 3, 5))

   val sum = teamPoints
       .calculatePoints(List<Int>::sum)
   println(sum) // 9

   val avg = teamPoints
       .calculatePoints(List<Int>::average)
   println(avg) // 3.0

   val invalid = String?::isNullOrBlank
   println(invalid(null)) // true
   println(invalid("  ")) // true
   println(invalid("AAA")) // false
}
