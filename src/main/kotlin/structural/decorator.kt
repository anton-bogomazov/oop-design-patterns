package structural

interface AbstractDataSource {
    fun write(data: String)
    fun read(): String?
}

abstract class DataSource : AbstractDataSource{
    var data: String? = null

    override fun write(data: String) {
        this.data = data
    }

    override fun read(): String? = data
}

class FileDataSource(
    val filename: String
) : DataSource()

open class DataSourceDecorator(
    protected val dataSource: DataSource
) : AbstractDataSource {

    override fun write(data: String) {
        dataSource.write(data)
    }

    override fun read(): String? = dataSource.read()

}

class InterpreterDecorator(file: FileDataSource) : DataSourceDecorator(file) {

    fun runCode() {
        dataSource as FileDataSource
        println("> Running js code from ${dataSource.filename}...")
        println("Data is ${dataSource.data}")
    }

}