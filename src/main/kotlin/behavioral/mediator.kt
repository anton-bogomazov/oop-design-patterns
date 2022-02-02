package behavioral

interface Mediator {
    fun notify(event: String, consumer: Consumer)
}

class BaseMediator(
    private val consumers: List<Pair<Consumer, Long>>
) : Mediator {

    override fun notify(event: String, consumer: Consumer) {
        val consumerToMessageNumber = consumers.singleOrNull { it.first == consumer } ?: error("Cannot find consumer")
        if (consumerToMessageNumber.second > 3) error("Too much events to this consumer")

        consumerToMessageNumber.first.handle(event)
    }

}

interface Producer {
    fun send(event: String, consumer: Consumer)
}

class BaseProducer(private val mediator: Mediator): Producer {

    override fun send(event: String, consumer: Consumer) {
        println("<$this> send event <$event> to <$consumer>")
        mediator.notify(event, consumer)
    }

}

interface Consumer {
    fun handle(event: String)
}

class BaseConsumer : Consumer {
    override fun handle(event: String) {
        println("Event <$event> consumed by <$this>")
    }
}
