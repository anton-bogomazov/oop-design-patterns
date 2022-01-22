package structural

interface TargetService {
    fun doUsefulThing()
}

class TargetServiceImplementation : TargetService {
    override fun doUsefulThing() {
        println("> Useful thing done!")
    }
}

class TargetServiceLoggingProxy(
    private val service: TargetService
) : TargetService {
    override fun doUsefulThing() {
        println("log.info: start doUsefulThing()")
        service.doUsefulThing()
        println("log.info: finish doUsefulThing()")
    }
}