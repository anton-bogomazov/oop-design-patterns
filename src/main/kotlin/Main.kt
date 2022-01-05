import creational.*
import creational.singleton.ApplicationContext

fun main() {
    println("Creational Design Patterns:")
    printWrapperAndRun(::factoryMethod)
    printWrapperAndRun(::abstractFactory)
    printWrapperAndRun(::builder)
    printWrapperAndRun(::prototype)
    printWrapperAndRun(::singleton)
}

fun printWrapperAndRun(method: () -> Unit) {
    val delimiter = "**********"
    val methodName = method.toString().split(' ')[1]

    println("\t- $methodName:")
    println(delimiter)
    method()
    println("$delimiter\n")
}

fun singleton() {
    val instance = ApplicationContext.getInstance()

    println("Instance classpath is ${instance.classpath}")
    println("Is instances equals? > ${instance.equals(ApplicationContext.getInstance())}")
}