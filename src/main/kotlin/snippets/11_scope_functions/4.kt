package f_11_scope_functions.s_4

class User(val name: String)

var user: User? = null

fun showUserNameIfPresent() {
    // will not work, because cannot smart-cast a property
    // if (user != null) {
    //     println(user.name)
    // }

    // works
    // val u = user
    // if (u != null) {
    //     println(u.name)
    // }

    // perfect
    user?.let { println(it.name) }
}
