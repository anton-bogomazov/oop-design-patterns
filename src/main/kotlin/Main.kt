
fun main() {
    println("Creational Design Patterns:")
    printWrapperAndRun(::factoryMethod)
    printWrapperAndRun(::abstractFactory)
    printWrapperAndRun(::builder)
    printWrapperAndRun(::prototype)
    printWrapperAndRun(::singleton)

    println("Structural Design Patterns:")
    printWrapperAndRun(::adapter)
}
