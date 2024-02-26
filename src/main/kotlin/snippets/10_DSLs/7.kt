package f_10_DSLs.s_7

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
