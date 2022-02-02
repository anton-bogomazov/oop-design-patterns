package behavioral

class Editor {

    private var text: String = ""
    private var cursorPosition: Long = 0
    private var snapshot: Snapshot? = null

    fun printText() = println("> $text")

    fun appendText(text: String) {
        createSnapshot()
        this.text += text
    }

    fun undo() = snapshot?.restore()

    private fun createSnapshot() {
        snapshot = Snapshot(this, text, cursorPosition)
    }

    class Snapshot(
        private val editor: Editor,
        private val text: String,
        private val cursorPosition: Long
    ) {
        fun restore() {
            editor.text = text
            editor.cursorPosition = cursorPosition
        }
    }
}
