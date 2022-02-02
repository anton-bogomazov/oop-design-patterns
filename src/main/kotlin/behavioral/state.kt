package behavioral

data class Article(
    var state: State? = null,
    var text: String = ""
) {
    init { state = Draft(this) }

    fun edit(text: String) = state?.edit(text)
    fun publish() = state?.publish()
    fun like() = state?.like()
}

abstract class State(
    private val article: Article
) {

    fun next() {
        article.state = when (this) {
            is Draft -> Published(article)
            is Published -> error("Article in published state")
            else -> error("unknown state")
        }
    }

    open fun edit(text: String) {
        article.text = text
    }

    open fun publish() {
        println("> Publishing... Done!")
        next()
    }

    open fun like() {
        println("> Awesome article ❤️")
    }

}

class Draft(article: Article) : State(article) {
    override fun like() = println("Cannot like: Article in draft state")
}

class Published(article: Article) : State(article) {
    override fun edit(text: String) = println("Cannot edit: Article in published state")
    override fun publish() = println("Cannot publish: Article in published state")
}
