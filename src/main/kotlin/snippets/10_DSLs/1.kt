package f_10_DSLs.s_1

// Named extension function
fun String.myPlus1(other: String) = this + other

fun main() {
    println("A".myPlus1("B")) // AB

    // Anonymous extension function assigned to a variable
    val myPlus2 = fun String.(other: String) = this + other
    println(myPlus2.invoke("A", "B")) // AB
    println(myPlus2("A", "B")) // AB
    println("A".myPlus2("B")) // AB
}
