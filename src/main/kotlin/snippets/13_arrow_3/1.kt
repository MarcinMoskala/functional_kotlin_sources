package f_13_arrow_3.s_1

data class Address(
    val zipcode: String,
    val country: String
)
data class Person(
    val name: String,
    val age: Int,
    val address: Address
)
