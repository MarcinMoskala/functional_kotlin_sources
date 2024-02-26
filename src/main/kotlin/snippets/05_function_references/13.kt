package f_05_function_references.s_13

class Drone {
   fun setOff() {}
   fun land() {}

   companion object {
       fun makeDrone(): Drone = Drone()
   }
}

fun main() {
   val maker: () -> Drone = Drone.Companion::makeDrone
}
