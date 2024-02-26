package f_05_function_references.s_11

object SuperUser {
   fun getId() = 0
}

fun main() {
   val myId = SuperUser::getId
   println(myId()) // 0

   val obj = object {
       fun cheer() {
           println("Hello")
       }
   }
   val f = obj::cheer
   f() // Hello
}
