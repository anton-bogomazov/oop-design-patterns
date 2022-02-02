package behavioral

abstract class FileProcessor {

    fun process(file: String) {
        val data = read(file)
        analyze(data)
    }

    abstract fun read(file: String): String

    private fun analyze(data: String) {
        println("> Beep-bop, processing data <$data>...")
        Thread.sleep(2000)
        println("> Done!")
    }

}

class PdfFileProcessor : FileProcessor() {
    override fun read(file: String): String {
        // some pdf parsing and processing
        return "very-important-data"
    }
}
