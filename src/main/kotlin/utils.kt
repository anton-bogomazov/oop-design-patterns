
fun printWrapperAndRun(method: () -> Unit) {
    val delimiter = "**********"
    val methodName = method.toString().split(' ')[1]

    println("\t- $methodName:")
    println(delimiter)
    method()
    println("$delimiter\n")
}
