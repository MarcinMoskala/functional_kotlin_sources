```
//1
fun String.capitalize() = this
    .replaceFirstChar(Char::uppercase)

fun Iterable<Int>.product() = this
    .fold(1, Int::times)

fun main() {
    println("alex".capitalize()) // Alex
    println("this is text".capitalize()) // This is text
    println((1..5).product()) // 120
    println(listOf(1, 3, 5).product()) // 15
}
```


```
fun HtmlBuilder.standardHead() {
    head {
        title = "My website"
        css("Some CSS1")
        css("Some CSS2")
    }
}

val html = html {
    standardHead()
    body {
        h1("Title")
        h3("Subtitle 1")
        +"Some text 1"
        h3("Subtitle 2")
        +"Some text 2"
    }
}
```


```
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*

fun <T> Flow<T>.launchIn(scope: CoroutineScope): Job =
    scope.launch { collect() }

suspend fun main(): Unit = coroutineScope {
    flowOf(1, 2, 3)
        .onEach { print(it) }
        .launchIn(this)
}
```


```
interface LoggingContext {
    val logger: Logger
}

fun LoggingContext.sendNotification(
    notification: NotificationData
) {
    logger.info("Sending notification $notification")
    notificationSender.send(notification)
}
```


```
// This is how we want standardHead used
html {
    standardHead()
}

// or this
with(receiver) {
    standardHead()
}

// but not this
builder.standardHead()
```


```
class Foo {
    fun foo() {
        print("Foo")
    }
}

context(Foo)
fun callFoo() {
    foo()
}

fun main() {
    with(Foo()) {
        callFoo()
    }
}
```


```
class Foo {
    fun foo() {
        print("Foo")
    }
}

class Boo {
    fun boo() {
        println("Boo")
    }
}

context(Foo, Boo)
fun callFooBoo() {
    foo()
    boo()
}

context(Foo, Boo)
fun callFooBoo2() {
    callFooBoo()
}

fun main() {
    with(Foo()) {
        with(Boo()) {
            callFooBoo() // FooBoo
            callFooBoo2() // FooBoo
        }
    }
    with(Boo()) {
        with(Foo()) {
            callFooBoo() // FooBoo
            callFooBoo2() // FooBoo
        }
    }
}
```


```
package fgfds

interface Foo {
    fun foo() {
        print("Foo")
    }
}

interface Boo {
    fun boo() {
        println("Boo")
    }
}

context(Foo, Boo)
fun callFooBoo() {
    foo()
    boo()
}

class FooBoo : Foo, Boo {
    fun call() {
        callFooBoo()
    }
}

fun main() {
    val fooBoo = FooBoo()
    fooBoo.call() // FooBoo
}
```


```
context(HtmlBuilder)
fun standardHead() {
    head {
        title = "My website"
        css("Some CSS1")
        css("Some CSS2")
    }
}
```


```
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*

context(CoroutineScope)
fun <T> Flow<T>.launchFlow(): Job =
    this@CoroutineScope.launch { collect() }

suspend fun main(): Unit = coroutineScope {
    flowOf(1, 2, 3)
        .onEach { print(it) }
        .launchFlow()
}
```


```
context(LoggingContext)
fun sendNotification(notification: NotificationData) {
    logger.info("Sending notification $notification")
    notificationSender.send(notification)
}
```


```
fun myChristmasLetter() = christmasLetter {
    title = "My presents list"
    addItem("Cookie")
    addItem("Drawing kit")
    addItem("Poi set")
}
```


```
fun myChristmasLetter() = christmasLetter {
    title = "My presents list"
    +"Cookie"
    +"Drawing kit"
    +"Poi set"
}
```


```
context(ChristmasLetterBuilder)
operator fun String.unaryPlus() {
    addItem(this)
}
```


```
context(View)
val Float.dp get() = this * resources.displayMetrics.density

context(View)
val Int.dp get() = this.toFloat().dp
```


```
package sdfgv

class ApplicationConfig(
    val name: String,
) {
    fun start() {
        print("Start application")
    }
}

context(ApplicationConfig)
class ApplicationControl(
    val applicationName: String = this@ApplicationConfig.name
) {
    fun start() {
        print("Using control: ")
        this@ApplicationConfig.start()
    }
}

fun main() {
    with(ApplicationConfig("AppName")) {
        val control = ApplicationControl()
        println(control.applicationName) // AppName
        control.start() // Using control: Start application
    }
}
```


```
// Don't do this
context(
    LoggerContext,
    NotificationSenderProvider, // not a context
    NotificatonsRepository // not a context
) // it might hard to call such a function
suspend fun sendNotifications() {
    log("Sending notifications")
    val notifications = getUnsentNotifications() // unclear
    val sender = create() // unclear
    for (n in notifications) {
        sender.send(n)
    }
    log("Notifications sent")
}

class NotificationsController(
    notificationSenderProvider: NotificationSenderProvider,
    notificationsRepository: NotificationsRepository
) : Logger() {
    @Post("send")
    suspend fun send() {
        with(notificationSenderProvider) { // avoid such calls
            with(notificationsRepository) { //avoid such calls
                sendNotifications()
            }
        }
    }
}
```


```
// Don't do that
context(LoggerContext)
suspend fun sendNotifications(
    notificationSenderProvider: NotificationSenderProvider,
    notificationsRepository: NotificationsRepository
) {
    log("Sending notifications")
    val notifications = notificationsRepository
        .getUnsentNotifications()
    val sender = notificationSenderProvider.create()
    for (n in notifications) {
        sender.send(n)
    }
    log("Notifications sent")
}

class NotificationsController(
    notificationSenderProvider: NotificationSenderProvider,
    notificationsRepository: NotificationsRepository
) : Logger() {
    @Post("send")
    suspend fun send() {
        sendNotifications(
            notificationSenderProvider,
            notificationsRepository
        )
    }
}
```