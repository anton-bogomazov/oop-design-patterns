package creational

private var idCounter: Long = 0

// abstraction

enum class ProductType {
    COOKIES, CHEESE
}

abstract class Product(productType: ProductType) {
    private val id = idCounter++

    init {
        println("Product with id=$id of type $productType was created.")
    }

}

abstract class ProductCreator(productType: ProductType) {

    init {
        println("${productType.toString().lowercase()}Creator was started.")
    }

    abstract fun create(): Product
}

// concrete products

class Cookies : Product(ProductType.COOKIES)

class Cheese : Product(ProductType.CHEESE)

// concrete creators

class CookiesCreator : ProductCreator(ProductType.COOKIES) {
    override fun create(): Cookies = Cookies()
}

class CheeseCreator : ProductCreator(ProductType.CHEESE) {
    override fun create(): Cheese = Cheese()
}

fun factoryMethod() {
    val cookiesCreator = CookiesCreator()
    val cheeseCreator = CheeseCreator()

    cookiesCreator.create()
    cookiesCreator.create()
    cheeseCreator.create()
    cheeseCreator.create()
    cookiesCreator.create()
}
