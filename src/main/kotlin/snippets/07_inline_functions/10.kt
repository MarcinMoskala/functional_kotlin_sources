package f_07_inline_functions.s_10

class User(val name: String, val surname: String) {
   inline val fullName: String get() = "$name $surname"
}

fun main() {
   val user = User("A", "B")
   println(user.fullName) // A B
   // during compilation changes to
   println("${user.name} ${user.surname}")
}
