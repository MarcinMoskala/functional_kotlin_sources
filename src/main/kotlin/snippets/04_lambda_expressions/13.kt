package f_04_lambda_expressions.s_13

class User
fun onUserChanged(listener: (User)->Unit) {}
fun cheerUser(user: User) {}

fun main() {
    onUserChanged { user ->
        if (user == null) return@onUserChanged
        cheerUser(user)
    }
}
