package f_05_function_references.s_16

class StudentId(val value: Int)
data class UserId(val value: Int) {
   constructor(studentId: StudentId) : this(studentId.value)
}

fun main() {
   val intToUserId: (Int) -> UserId = ::UserId
   println(intToUserId(1)) // UserId(value=1)

   val studentId = StudentId(2)
   val studentIdToUserId: (StudentId) -> UserId = ::UserId
   println(studentIdToUserId(studentId)) // UserId(value=2)
}
