package f_10_DSLs.s_4

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
