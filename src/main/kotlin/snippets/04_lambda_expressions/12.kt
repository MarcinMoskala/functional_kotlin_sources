package f_04_lambda_expressions.s_12

class User
fun onUserChanged(listener: (User)->Unit) {}
fun cheerUser(user: User) {}

fun main() {
    onUserChanged someLabel@{ user ->
        if (user == null) return@someLabel
        cheerUser(user)
    }
}
