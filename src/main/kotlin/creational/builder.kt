package creational

enum class PizzaType {
    PEPPERONI, MARGHERITA, MUSHROOM
}

data class Pizza(
    var size: Long? = null,
    var sauce: Boolean = false,
    var pepperoni: Boolean = false,
    var cheese: Boolean = false,
    var mushrooms: Boolean = false
) {

    override fun toString() = "Pizza with size=$size, sauce=$sauce, pepperoni=$pepperoni, cheese=$cheese, mushrooms=$mushrooms"

}

class PizzaBuilder {

    private val pizza: Pizza = Pizza()

    fun setSize(size: Long) {
        if (size !in 15..45) error("Size must be in range 15..45")

        pizza.size = size
    }

    fun addSause() { pizza.sauce = true }

    fun addPepperoni() { pizza.pepperoni = true }

    fun addCheese() { pizza.cheese = true }

    fun addMushrooms() { pizza.mushrooms = true }

    fun reset() {
        pizza.size = null
        pizza.sauce = false
        pizza.pepperoni = false
        pizza.cheese = false
        pizza.mushrooms = false
    }

    fun cookPizza() = pizza.copy()

}

class PizzaDirector {

    private val builder: PizzaBuilder = PizzaBuilder()

    fun cookPizza(pizzaType: PizzaType, size: Long) =
        when (pizzaType) {
            PizzaType.PEPPERONI -> cookPepperoni(size)
            PizzaType.MARGHERITA -> cookMargherita(size)
            PizzaType.MUSHROOM -> cookMushroom(size)
        }

    private fun cookPepperoni(size: Long): Pizza {
        builder.reset()

        builder.setSize(size)
        builder.addSause()
        builder.addPepperoni()
        builder.addCheese()

        return builder.cookPizza()
    }

    private fun cookMushroom(size: Long): Pizza {
        builder.reset()

        builder.setSize(size)
        builder.addSause()
        builder.addMushrooms()
        builder.addCheese()

        return builder.cookPizza()
    }

    private fun cookMargherita(size: Long): Pizza {
        builder.reset()

        builder.setSize(size)
        builder.addSause()
        builder.addCheese()

        return builder.cookPizza()
    }

}

fun builder() {
    val director = PizzaDirector()

    println(director.cookPizza(PizzaType.PEPPERONI, 35))
    println(director.cookPizza(PizzaType.MUSHROOM, 15))
}