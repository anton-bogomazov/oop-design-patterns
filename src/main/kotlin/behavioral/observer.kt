package behavioral

interface Listener {
    fun handle(event: String)
}

interface Publisher {
    fun subscribe(listener: Listener)
}

class EventListener : Listener {
    override fun handle(event: String) {
        println("Event: $event received by $this")
    }
}

class EventPublisher : Publisher {

    private val listeners = mutableListOf<Listener>()

    fun send(event: String) = listeners.forEach { it.handle(event) }

    override fun subscribe(listener: Listener) {
        listeners.add(listener)
    }

}
