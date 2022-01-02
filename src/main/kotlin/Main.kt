import creational.abstractFactory
import creational.builder
import creational.factoryMethod

fun main() {
    println("Creational Design Patterns:")
    printWrapperAndRun(::factoryMethod)
    printWrapperAndRun(::abstractFactory)
    printWrapperAndRun(::builder)
}

fun printWrapperAndRun(method: () -> Unit) {
    val delimiter = "**********"
    val methodName = method.toString().split(' ')[1]

    println("\t- $methodName:")
    println(delimiter)
    method()
    println("$delimiter\n")
}