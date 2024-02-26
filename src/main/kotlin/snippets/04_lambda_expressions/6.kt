package f_04_lambda_expressions.s_6

data class User(val name: String, val surname: String)
data class Element(val id: Int, val type: String)

fun setOnClickListener(listener: (User, Element) -> Unit) {}

fun main() {
    setOnClickListener({ (name, surname), (id, type) ->
        println(
            "User $name $surname clicked " +
            "element $id of type $type"
        )
    })
}
