package f_10_DSLs.s_14

class HeadBuilder {
    var title: String = ""
    private var styles: List<String> = emptyList()

    fun style(body: String) {
        styles += body
    }
}
