package f_10_DSLs.s_16

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
