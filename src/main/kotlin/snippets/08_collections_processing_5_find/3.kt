package f_08_collections_processing_5_find.s_3

class User(val id: String)
val users = listOf<User>()
class Configuration(val name: String)
val configurations = listOf<Configuration>()

fun getUser(id: String): User? =
    users.find { it.id == id }

fun findUser(name: String): Configuration? =
    configurations.find { it.name == name }
