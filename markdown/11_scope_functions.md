```
// `let` implementation without contract
inline fun <T, R> T.let(block: (T) -> R): R = block(this)
```


```
//1
fun main() {
    println(listOf("a", "b", "c").map { it.uppercase() })
    // [A, B, C]
    println("a".let { it.uppercase() }) // A
}
```


```
val fis = FileInputStream("someFile.gz")
val bis = BufferedInputStream(fis)
val gis = ZipInputStream(bis)
val ois = ObjectInputStream(gis)
val someObject = ois.readObject()
```


```
val someObject = FileInputStream("someFile.gz")
    .let { BufferedInputStream(it) }
    .let { ZipInputStream(it) }
    .let { ObjectInputStream(it) }
    .readObject()
```


```
val someObject = FileInputStream("someFile.gz")
    .let(::BufferedInputStream)
    .let(::ZipInputStream)
    .let(::ObjectInputStream)
    .readObject()
```


```
class CoursesService(
    private val userRepository: UserRepository,
    private val coursesRepository: CoursesRepository,
    private val userCoursesFactory: UserCoursesFactory,
) {
    // Imperative approach, without let
    fun getActiveCourses(token: String): UserCourses? {
        val user = userRepository.getUser(token)
            ?: return null
        val activeCourses = coursesRepository
            .getActiveCourses(user.id) ?: return null
        return userCoursesFactory.produce(activeCourses)
    }

    // Functional approach, using let
    fun getActiveCourses(token: String): UserCourses? =
        userRepository.getUser(token)
            ?.let {coursesRepository.getActiveCourses(it.id)}
            ?.let(userCoursesFactory::produce)
}
```


```
class UserCreationRequest(
    val id: String,
    val name: String,
    val surname: String,
)

class UserDto(
    val userId: String,
    val firstName: String,
    val lastName: String,
)

fun UserCreationRequest.toUserDto() = UserDto(
    userId = this.id,
    firstName = this.name,
    lastName = this.surname,
)
```


```
class UserCreationRequest(
    val name: String,
    val surname: String,
)

class UserDto(
    val userId: String,
    val firstName: String,
    val lastName: String,
)

class UserCreationService(
    private val userRepository: UserRepository,
    private val idGenerator: IdGenerator,
) {
    fun addUser(request: UserCreationRequest): User =
        request.toUserDto()
            .also { userRepository.addUser(it) }
            .toUser()

    // Anti-pattern! Avoid using member extensions
    private fun UserCreationRequest.toUserDto() = UserDto(
        userId = idGenerator.generate(),
        firstName = this.name,
        lastName = this.surname,
    )
}
```


```
class UserCreationRequest(
    val name: String,
    val surname: String,
)

class UserDto(
    val userId: String,
    val firstName: String,
    val lastName: String,
)

class UserCreationService(
    private val userRepository: UserRepository,
    private val idGenerator: IdGenerator,
) {
    fun addUser(request: UserCreationRequest): User =
        request.let { createUserDto(it) }
        // or request.let(::createUserDto)
            .also { userRepository.addUser(it) }
            .toUser()

    private fun createUserDto(request: UserCreationRequest) =
        UserDto(
            userId = idGenerator.generate(),
            firstName = request.name,
            lastName = request.surname,
        )
}
```


```
class UserCreationService(
    private val userRepository: UserRepository,
    private val userDtoFactory: UserDtoFactory,
) {
    fun addUser(request: UserCreationRequest): User =
        request.let { userDtoFactory.produce(it) }
            .also { userRepository.addUser(it) }
            .toUser()

//  or
//  fun addUser(request: UserCreationRequest): User =
//      request.let(userDtoFactory::produce)
//          .also(userRepository::addUser)
//          .toUser()
}
```


```
// Not good, not terrible
val someObject = FileInputStream("/someFile.gz")
    .let(::BufferedInputStream)
    .let(::ZipInputStream)
    .let(::ObjectInputStream)
    .readObject()
println(someObject)

// Terrible
print(
    FileInputStream("/someFile.gz")
        .let(::BufferedInputStream)
        .let(::ZipInputStream)
        .let(::ObjectInputStream)
        .readObject()
)
```


```
FileInputStream("/someFile.gz")
    .let(::BufferedInputStream)
    .let(::ZipInputStream)
    .let(::ObjectInputStream)
    .readObject()
    .let(::print)
```


```
FileInputStream("/someFile.gz")
    .let(::BufferedInputStream)
    .let(::ZipInputStream)
    .let(::ObjectInputStream)
    .readObject()
    ?.let(::print)
```


```
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
```


```
// `also` implementation without contract
inline fun <T> T.also(block: (T) -> Unit): T {
    block(this)
    return this
}
```


```
fun addUser(request: UserCreationRequest): User =
    request.toUserDto()
        .also { userRepository.addUser(it) }
        .toUser()
```


```
fun addUser(request: UserCreationRequest): User =
    request.toUserDto()
        .also { userRepository.addUser(it) }
        .also { log("User created: $it") }
        .toUser()

class CachingDatabaseFactory(
    private val databaseFactory: DatabaseFactory,
) : DatabaseFactory {
    private var cache: Database? = null

    override fun createDatabase(): Database = cache
        ?: databaseFactory.createDatabase()
            .also { cache = it }
}
```


```
class User(val name: String)

var user: User? = null

fun showUserNameIfPresent() {
    user?.also { println(it.name) }
}

fun readAndPrint() {
    FileInputStream("/someFile.gz")
        .let(::BufferedInputStream)
        .let(::ZipInputStream)
        .let(::ObjectInputStream)
        .readObject()
        ?.also(::print)
}
```


```
// `takeIf` implementation without contract
inline fun <T> T.takeIf(predicate: (T) -> Boolean): T? {
    return if (predicate(this)) this else null
}

// `takeUnless` implementation without contract
inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T? {
    return if (!predicate(this)) this else null
}
```


```
val lines = File("SomeFile")
    .takeIf { it.exists() }
    ?.readLines()
```


```
class UserCreationService(
    private val userRepository: UserRepository,
) {
    fun readUser(token: String): User? =
        userRepository.findUser(token)
            .takeIf { it.isValid() }
            ?.toUser()
}
```


```
// `apply` implementation without contract
inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}
```


```
fun createDialog() = Dialog().apply {
    title = "Some dialog"
    message = "Just accept it, ok?"
    // ...
}

fun showUsers(users: List<User>) {
    listView.apply {
        adapter = UsersListAdapter(users)
        layoutManager = LinearLayoutManager(context)
    }
}
```


```
//2
class Node(val name: String) {

    fun makeChild(childName: String) =
        create("$name.$childName")
            .apply { print("Created $name") }

    fun create(name: String): Node? = Node(name)
}

fun main() {
    val node = Node("parent")
    node.makeChild("child")
}
```


```
//3
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
```


```
// `with` implementation without contract
inline fun <T, R> with(receiver: T, block: T.() -> R): R =
    receiver.block()
```


```
// explicit scope changing in Kotlin Coroutines
val scope = CoroutineScope(SupervisorJob())
with(scope) {
    launch {
        // ...
    }
    launch {
        // ...
    }
}

// unit-test assertions
with(user) {
    assertEquals(aName, name)
    assertEquals(aSurname, surname)
    assertEquals(aWebsite, socialMedia?.websiteUrl)
    assertEquals(aTwitter, socialMedia?.twitter)
    assertEquals(aLinkedIn, socialMedia?.linkedin)
    assertEquals(aGithub, socialMedia?.github)
}
```


```
// `run` implementation without contract
inline fun <R> run(block: () -> R): R = block()

// `run` implementation without contract
inline fun <T, R> T.run(block: T.() -> R): R = block()
```


```
val locationWatcher = run {
    val positionListener = createPositionListener()
    val streetListener = createStreetListener()
    LocationWatcher(positionListener, streetListener)
}
```