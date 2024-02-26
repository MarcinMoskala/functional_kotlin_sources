package f_05_function_references.s_14

object Robot {
   fun moveForward() { 
       /*...*/
   }
   fun moveBackward() { 
       /*...*/
   }
}

fun main() {
   Robot.moveForward()
   Robot.moveBackward()

   val action1: () -> Unit = Robot::moveForward
   val action2: () -> Unit = Robot::moveBackward
}
