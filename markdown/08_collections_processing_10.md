```
//1
fun main() {
    val names = listOf("Maja", "Norbert", "Ola")
    println(names.joinToString())
    // Maja, Norbert, Ola
    println(names.joinToString { it.uppercase() })
    // MAJA, NORBERT, OLA
    println(names.joinToString(separator = "; "))
    // Maja; Norbert; Ola
    println(names.joinToString(limit = 2))
    // Maja, Norbert, ...
    println(names.joinToString(limit = 2, truncated = "etc."))
    // Maja, Norbert, etc.
    println(names.joinToString(prefix = "{names=[", postfix="]}"))
    // {names=[Maja, Norbert, Ola]}
}
```


```
//2
data class User(val id: Int, val name: String)

fun main() {
    val names: Map<Int, String> = mapOf(0 to "Alex", 1 to "Ben")
    println(names)
    // {0=Alex, 1=Ben}

    val users: List<User> = names.map { User(it.key, it.value) }
    println(users)
    // [User(id=0, name=Alex), User(id=1, name=Ben)]

    val usersById: Map<Int, User> = users.associateBy { it.id }
    println(usersById)
    // {0=User(id=0, name=Alex), 1=User(id=1, name=Ben)}

    val namesById: Map<Int, String> = usersById
        .mapValues { it.value.name }
    println(names)
    // {0=Alex, 1=Ben}

    val usersByName: Map<String, User> = usersById
        .mapKeys { it.value.name }
    println(usersByName)
    // {Alex=User(id=0, name=Alex), Ben=User(id=1, name=Ben)}
}
```