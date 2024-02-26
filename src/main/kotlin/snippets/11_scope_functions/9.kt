package f_11_scope_functions.s_9

class Node(val name: String) {

    fun makeChild(childName: String) =
        create("$name.$childName")
            .also { print("Created ${it?.name}") }

    fun create(name: String): Node? = Node(name)
}

fun main() {
    val node = Node("parent")
    node.makeChild("child") // Created child
}
