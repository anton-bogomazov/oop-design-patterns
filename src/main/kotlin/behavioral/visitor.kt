package behavioral

import kotlin.math.cos

interface Thing {
    fun accept(visitor: Visitor)
}

class ThisThing : Thing {
    private val color = "grey"
    private val cost = "5$"
    override fun accept(visitor: Visitor) {
        visitor.extractContentFromThisThing(color, cost)
    }
}

class CompletelyDifferentThing : Thing {
    private val content = "componentB content"
    private val access = "full"
    override fun accept(visitor: Visitor) {
        visitor.extractContentFromCompletelyDifferentThing(content, access)
    }
}

class Visitor {
    fun extractContentFromThisThing(color: String, cost: String) =
        println("ThisThing: color is $color, cost is $cost")

    fun extractContentFromCompletelyDifferentThing(content: String, access: String) =
        println("CompletelyDifferentThing: content is $content, access is $access")
}
