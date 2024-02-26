package f_10_DSLs.s_3

fun main() {
    val myPlus3: String.(String) -> String = { other ->
        this + other
        // Inside, we can use receiver `this`,
        // that is of type `String`
    }
    // Here, there is no receiver, so `this` has no meaning
    println(myPlus3.invoke("A", "B")) // AB
    println(myPlus3("A", "B")) // AB
    println("A".myPlus3("B")) // AB
}
