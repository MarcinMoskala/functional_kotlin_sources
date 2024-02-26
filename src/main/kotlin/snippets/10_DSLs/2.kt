package f_10_DSLs.s_2

fun main() {
    val myPlus2: String.(String) -> String =
        fun String.(other: String) = this + other
    println(myPlus2.invoke("A", "B")) // AB
    println(myPlus2("A", "B")) // AB
    println("A".myPlus2("B")) // AB
}
