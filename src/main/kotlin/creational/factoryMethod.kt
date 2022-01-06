package creational

private var idCounter: Long = 0

// abstraction

enum class ProductType {
    COOKIES, CHEESE
}

abstract class Product(private val productType: ProductType) {
    private val id = idCounter++

    override fun toString() = "Product with id=$id of type $productType was created."
}

abstract class ProductCreator {

    abstract fun makeProduct(): Product

    fun getProduct(): Product {
        val product = makeProduct()
        println(product.toString())
        return product
    }
}

// concrete products

class Cookies : Product(ProductType.COOKIES)

class Cheese : Product(ProductType.CHEESE)

// concrete creators

class CookiesCreator : ProductCreator() {
    override fun makeProduct(): Cookies = Cookies()
}

class CheeseCreator : ProductCreator() {
    override fun makeProduct(): Cheese = Cheese()
}
