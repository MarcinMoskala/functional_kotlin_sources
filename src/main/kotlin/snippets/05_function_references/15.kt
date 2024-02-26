package f_05_function_references.s_15

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
