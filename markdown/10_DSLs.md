```
// build.gradle.kts
// Kotlin
plugins {
    java
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jb.ktx:kotlinx-coroutines-core:1.6.0")
    testImplementation("io.mockk:mockk:1.12.1")
    testImplementation("org.junit.j:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.j:junit-jupiter-engine:5.8.2")
}
```


```
// Kotlin
body {
    div {
        a("https://kotlinlang.org") {
            target = ATarget.blank
            +"Main site"
        }
    }
    +"Some content"
}
```


```
// Kotlin
class HelloWorld : View() {
    override val root = hbox {
        label("Hello world") {
            addClass(heading)
        }

        textfield {
            promptText = "Enter your name"
        }
    }
}
```


```
fun Routing.api() {
    route("news") {
        get {
            val newsData = NewsUseCase.getAcceptedNews()
            call.respond(newsData)
        }
        get("propositions") {
            requireSecret()
            val newsData = NewsUseCase.getPropositions()
            call.respond(newsData)
        }
    }
    // ...
}
```


```
fun Routing.setupRedirect(redirect: Map<String, String>) {
    for ((path, redirectTo) in redirect) {
        get(path) {
            call.respondRedirect(redirectTo)
        }
    }
}
```


```
class MyTests : StringSpec({
    "length should return size of string" {
        "hello".length shouldBe 5
    }
    "startsWith should test for a prefix" {
        "world" should startWith("wor")
    }
})
```


```
//1
// Named extension function
fun String.myPlus1(other: String) = this + other

fun main() {
    println("A".myPlus1("B")) // AB

    // Anonymous extension function assigned to a variable
    val myPlus2 = fun String.(other: String) = this + other
    println(myPlus2.invoke("A", "B")) // AB
    println(myPlus2("A", "B")) // AB
    println("A".myPlus2("B")) // AB
}
```


```
//2
fun main() {
    val myPlus2: String.(String) -> String =
        fun String.(other: String) = this + other
    println(myPlus2.invoke("A", "B")) // AB
    println(myPlus2("A", "B")) // AB
    println("A".myPlus2("B")) // AB
}
```


```
//3
fun main() {
    val myPlus3: String.(String) -> String = { other ->
        this + other
        // Inside, we can use receiver `this`,
        // that is of type `String`
    }
    // Here, there is no receiver, so `this` has no meaning
    println(myPlus3.invoke("A", "B")) // AB
    println(myPlus3("A", "B")) // AB
    println("A".myPlus3("B")) // AB
}
```


```
//4
class Dialog {
    var title: String = ""
    var message: String = ""
    var okButtonText: String = ""
    var okButtonHandler: () -> Unit = {}
    var cancelButtonText: String = ""
    var cancelButtonHandler: () -> Unit = {}
    fun show() { 
        /*...*/
    }
}

fun main() {
    val dialog = Dialog()
    dialog.title = "Some dialog"
    dialog.message = "Just accept it, ok?"
    dialog.okButtonText = "OK"
    dialog.okButtonHandler = { /*OK*/ }
    dialog.cancelButtonText = "Cancel"
    dialog.cancelButtonHandler = { /*Cancel*/ }
    dialog.show()
}
```


```
fun main() {
    val dialog = Dialog()
    val init: Dialog.() -> Unit = {
        title = "Some dialog"
        message = "Just accept it, ok?"
        okButtonText = "OK"
        okButtonHandler = { /*OK*/ }
        cancelButtonText = "Cancel"
        cancelButtonHandler = { /*Cancel*/ }
    }
    init.invoke(dialog)
    dialog.show()
}
```


```
fun showDialog(init: Dialog.() -> Unit) {
    val dialog = Dialog()
    init.invoke(dialog)
    dialog.show()
}

fun main() {
    showDialog {
        title = "Some dialog"
        message = "Just accept it, ok?"
        okButtonText = "OK"
        okButtonHandler = { /*OK*/ }
        cancelButtonText = "Cancel"
        cancelButtonHandler = { /*Cancel*/ }
    }
}
```


```
// Simplified apply implementation
inline fun <T> T.apply(block: T.() -> Unit): T {
    this.block() // same as block.invoke(this)
    return this
}
```


```
fun main() {
    Dialog().apply {
        title = "Some dialog"
        message = "Just accept it, ok?"
        okButtonText = "OK"
        okButtonHandler = { /*OK*/ }
        cancelButtonText = "Cancel"
        cancelButtonHandler = { /*Cancel*/ }
    }.show()
}
```


```
fun showDialog(init: Dialog.() -> Unit) {
    Dialog().apply(init).show()
}
```


```
//5
fun main() {
    val list = buildList {
        add(1)
        add(2)
        add(3)
    }
    println(list) // [1, 2, 3]
}
```


```
fun <T> buildList(init: MutableList<T>.() -> Unit): List<T>{
    val list = mutableListOf<T>()
    list.init()
    return list
    // or just
    // return mutableListOf<T>().apply(init)
}
```


```
fun secondsToPrettyTime(allSeconds: Int): String {
    if (allSeconds < 0) return "Invalid input"
    val hours = allSeconds / SEC_IN_HOUR
    val minutes = (allSeconds % SEC_IN_HOUR) / SEC_IN_MINUE
    val seconds = allSeconds % SEC_IN_MINUE

    return buildList {
        if (hours > 0) add("$hours h")
        if (minutes > 0) add("$minutes min")
        if (seconds > 0) add("$seconds sec")
    }.joinToString(separator = " ")
}

private const val SEC_IN_HOUR = 60 * 60
private const val SEC_IN_MINUE = 60
```


```
//6
fun main() {
    val string = buildString {
        append("A")
        append("B")
        append("C")
    }
    println(string) // ABC
}
```


```
class Dialog {
    var title: String = ""
    var message: String = ""
    var okButton: Button? = null
    var cancelButton: Button? = null

    fun show() { 
        /*...*/
    }

    class Button {
        var message: String = ""
        var handler: () -> Unit = {}
    }
}
```


```
fun main() {
    showDialog {
        title = "Some dialog"
        message = "Just accept it, ok?"
        okButton = Dialog.Button()
        okButton?.message = "OK"
        okButton?.handler = { /*OK*/ }
        cancelButton = Dialog.Button()
        cancelButton?.message = "Cancel"
        cancelButton?.handler = { /*Cancel*/ }
    }
}
```


```
fun makeButton(init: Dialog.Button.() -> Unit) {
    return Dialog.Button().apply(init)
}

fun main() {
    showDialog {
        title = "Some dialog"
        message = "Just accept it, ok?"
        okButton = makeButton {
            message = "OK"
            handler = { /*OK*/ }
        }
        cancelButton = makeButton {
            message = "Cancel"
            handler = { /*Cancel*/ }
        }
    }
}
```


```
//7
class Dialog {
    var title: String = ""
    var message: String = ""
    private var okButton: Button? = null
    private var cancelButton: Button? = null

    fun okButton(init: Button.() -> Unit) {
        okButton = Button().apply(init)
    }

    fun cancelButton(init: Button.() -> Unit) {
        cancelButton = Button().apply(init)
    }

    fun show() { 
        /*...*/
    }

    class Button {
        var message: String = ""
        var handler: () -> Unit = {}
    }
}

fun showDialog(init: Dialog.() -> Unit) {
    Dialog().apply(init).show()
}

fun main() {
    showDialog {
        title = "Some dialog"
        message = "Just accept it, ok?"
        okButton {
            message = "OK"
            handler = { /*OK*/ }
        }
        cancelButton {
            message = "Cancel"
            handler = { /*Cancel*/ }
        }
    }
}
```


```
fun main() {
    showDialog {
        title = "Some dialog"
        message = "Just accept it, ok?"
        okButton {
            title = "OK" // This sets the dialog title!
            handler = { /*OK*/ }
        }
        cancelButton {
            message = "Cancel"
            handler = { /*Cancel*/ }
        }
    }
}
```


```
@DslMarker
annotation class DialogDsl

@DialogDsl
class Dialog {
    var title: String = ""
    var message: String = ""
    private var okButton: Button? = null
    private var cancelButton: Button? = null

    @DialogDsl
    fun okButton(init: Button.() -> Unit) {
        okButton = Button().apply(init)
    }

    @DialogDsl
    fun cancelButton(init: Button.() -> Unit) {
        cancelButton = Button().apply(init)
    }

    fun show() { 
        /*...*/
    }

    @DialogDsl
    class Button {
        var message: String = ""
        var handler: () -> Unit = {}
    }
}

@DialogDsl
fun showDialog(init: Dialog.() -> Unit) {
    Dialog().apply(init).show()
}
```


```
val html = html {
    head {
        title = "My websi" +
        "te"
        style("Some CSS1")
        style("Some CSS2")
    }
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
fun html(init: HtmlBuilder.() -> Unit): HtmlBuilder = TODO()
```


```
class HtmlBuilder {
    fun head(init: HeadBuilder.() -> Unit) {
        /*...*/
    }

    fun body(init: BodyBuilder.() -> Unit) {
        /*...*/
    }
}
```


```
class HeadBuilder {
    var title: String = ""

    fun style(body: String) {
        /*...*/
    }
}
```


```
class BodyBuilder {
    fun h1(text: String) {
        /*...*/
    }

    fun h3(text: String) {
        /*...*/
    }

    operator fun String.unaryPlus() {
        /*...*/
    }
}
```


```
class HeadBuilder {
    var title: String = ""
    private var styles: List<String> = emptyList()

    fun style(body: String) {
        styles += body
    }
}
```


```
class BodyBuilder {
    private var elements: List<BodyElement> = emptyList()

    fun h1(text: String) {
        this.elements += H1(text)
    }

    fun h3(text: String) {
        this.elements += H3(text)
    }

    operator fun String.unaryPlus() {
        elements += Text(this)
    }
}

sealed interface BodyElement
data class H1(val text: String) : BodyElement
data class H3(val text: String) : BodyElement
data class Text(val text: String) : BodyElement
```


```
fun head(init: HeadBuilder.() -> Unit) {
    val head = HeadBuilder()
    init.invoke(head)
    // or init(head)
    // or head.init()
    this.head = head
}
```


```
fun html(init: HtmlBuilder.() -> Unit): HtmlBuilder {
    return HtmlBuilder().apply(init)
}

class HtmlBuilder {
    private var head: HeadBuilder? = null
    private var body: BodyBuilder? = null

    fun head(init: HeadBuilder.() -> Unit) {
        this.head = HeadBuilder().apply(init)
    }

    fun body(init: BodyBuilder.() -> Unit) {
        this.body = BodyBuilder().apply(init)
    }
}
```


```
//8
// DSL definition
@DslMarker
annotation class HtmlDsl

@HtmlDsl
fun html(init: HtmlBuilder.() -> Unit): HtmlBuilder {
    return HtmlBuilder().apply(init)
}

@HtmlDsl
class HtmlBuilder {
    private var head: HeadBuilder? = null
    private var body: BodyBuilder? = null

    @HtmlDsl
    fun head(init: HeadBuilder.() -> Unit) {
        this.head = HeadBuilder().apply(init)
    }

    @HtmlDsl
    fun body(init: BodyBuilder.() -> Unit) {
        this.body = BodyBuilder().apply(init)
    }

    override fun toString(): String =
        listOfNotNull(head, body)
            .joinToString(
                separator = "",
                prefix = "<html>\n",
                postfix = "</html>",
                transform = { "$it\n" }
            )
}

@HtmlDsl
class HeadBuilder {
    var title: String = ""
    private var cssList: List<String> = emptyList()

    @HtmlDsl
    fun css(body: String) {
        cssList += body
    }

    override fun toString(): String {
        val css = cssList.joinToString(separator = "") {
            "<style>$it</style>\n"
        }
        return "<head>\n<title>$title</title>\n$css</head>"
    }
}

@HtmlDsl
class BodyBuilder {
    private var elements: List<BodyElement> = emptyList()

    @HtmlDsl
    fun h1(text: String) {
        this.elements += H1(text)
    }

    @HtmlDsl
    fun h3(text: String) {
        this.elements += H3(text)
    }

    operator fun String.unaryPlus() {
        elements += Text(this)
    }

    override fun toString(): String {
        val body = elements.joinToString(separator = "\n")
        return "<body>\n$body\n</body>"
    }
}

sealed interface BodyElement
data class H1(val text: String) : BodyElement {
    override fun toString(): String = "<h1>$text</h1>"
}

data class H3(val text: String) : BodyElement {
    override fun toString(): String = "<h3>$text</h3>"
}

data class Text(val text: String) : BodyElement {
    override fun toString(): String = text
}

// DSL usage
val html = html {
    head {
        title = "My website"
        css("Some CSS1")
        css("Some CSS2")
    }
    body {
        h1("Title")
        h3("Subtitle 1")
        +"Some text 1"
        h3("Subtitle 2")
        +"Some text 2"
    }
}

fun main() {
    println(html)
}
/*
<html>
<head>
<title>My website</title>
<style>Some CSS1</style>
<style>Some CSS2</style>
</head>
<body>
<h1>Title</h1>
<h3>Subtitle 1</h3>
Some text 1
<h3>Subtitle 2</h3>
Some text 2
</body>
</html>
*/
```