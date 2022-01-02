import creational.abstractFactory
import creational.factoryMethod

fun main() {
    println("Creational Design Patterns:")
    printWrapperAndRun(::factoryMethod)
    printWrapperAndRun(::abstractFactory)
}

fun printWrapperAndRun(method: () -> Unit) {
    val delimiter = "**********"
    println("\t- ${method.toString().split(' ')[1]}:")
    println(delimiter)
    method()
    println("$delimiter\n")
}