fun main() {
    println("Creational Design Patterns:")
    printWrapperAndRun(::factoryMethod)
    printWrapperAndRun(::abstractFactory)
    printWrapperAndRun(::builder)
    printWrapperAndRun(::prototype)
    printWrapperAndRun(::singleton)

    println("Structural Design Patterns:")
    printWrapperAndRun(::adapter)
    printWrapperAndRun(::bridge)
    printWrapperAndRun(::composite)
    printWrapperAndRun(::decorator)
    printWrapperAndRun(::flyweight)
    printWrapperAndRun(::proxy)

    println("Behavioral Design Patterns:")
    printWrapperAndRun(::chainOfResponsibility)
    printWrapperAndRun(::command)
    printWrapperAndRun(::iterator)
}
