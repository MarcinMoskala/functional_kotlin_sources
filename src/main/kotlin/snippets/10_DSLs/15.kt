package f_10_DSLs.s_15

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
