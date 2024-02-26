package f_10_DSLs.s_9

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
