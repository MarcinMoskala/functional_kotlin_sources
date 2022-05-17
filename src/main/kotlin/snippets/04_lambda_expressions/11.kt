package f_04_lambda_expressions.s_11

class User
fun onUserChanged(listener: (User)->Unit) {}
fun cheerUser(user: User) {}

fun main() {
    onUserChanged { user ->
//        if (user == null) return // compilation error
        cheerUser(user)
    }
}
