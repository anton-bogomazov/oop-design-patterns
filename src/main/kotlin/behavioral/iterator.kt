package behavioral

interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T?
}

interface Iterable<T> {
    fun createIterator(): Iterator<T>
    fun createReverseIterator(): Iterator<T>
}

class IntegerListIterator(private val list: IntegerList) : Iterator<Int> {

    var currentElementIndex: Int = 0

    override fun hasNext(): Boolean {
        list.collection.getOrNull(currentElementIndex) ?: return false
        return true
    }

    override fun next(): Int? = if (hasNext()) list.collection[currentElementIndex++] else null

}

class IntegerListReverseIterator(private val list: IntegerList) : Iterator<Int> {

    var currentElementIndex: Int = list.collection.lastIndex

    override fun hasNext(): Boolean {
        list.collection.getOrNull(currentElementIndex) ?: return false
        return true
    }

    override fun next(): Int? = if (hasNext()) list.collection[currentElementIndex--] else null

}

class IntegerList : Iterable<Int> {
    val collection = mutableListOf<Int>()

    fun add(element: Int): IntegerList {
        collection.add(element)

        return this
    }

    override fun createIterator(): Iterator<Int> {
        return IntegerListIterator(this)
    }

    override fun createReverseIterator(): Iterator<Int> {
        return IntegerListReverseIterator(this)
    }
}