package behavioral

interface Handler {
    fun setNext(handler: Handler): Handler
    fun handle(request: Request)
}

abstract class BaseHandler : Handler {

    companion object FilterChainFactory {

        private var handlers: BaseHandler? = null

        fun build(vararg handlers: BaseHandler): FilterChainFactory {
            var current: BaseHandler? = null

            for (handler in handlers) {
                if (handler == handlers.first()) {
                    this.handlers = handler
                    current = this.handlers
                }
                current = current?.setNext(handler)
            }
            return this
        }

        fun run(request: Request) {
            var currentHandler = handlers

            while (currentHandler != null) {
                currentHandler.handle(request)
                currentHandler = currentHandler.nextHandler
            }
        }

    }

    var nextHandler: BaseHandler? = null

    override fun setNext(handler: Handler): BaseHandler {
        nextHandler = handler as BaseHandler
        return nextHandler!!
    }
}

class AuthFilter : BaseHandler() {
    override fun handle(request: Request) {
        request.login ?: error("no login")
        request.password ?: error("no password")

        // validate auth data
        // checkPassword(usersRepository.findByLogin(request.login).password)
    }
}

class BodyFilter : BaseHandler() {
    override fun handle(request: Request) {
        if (request.body == "{dangerous code}") error("We are under attack!")
    }
}

class RequestTypeFilter : BaseHandler() {
    override fun handle(request: Request) {
        if (request.type == "PUT") error("unsupported request type")
    }
}

data class Request(
    var login: String? = null,
    var password: String? = null,
    var type: String? = null,
    var body: String? = null
)
