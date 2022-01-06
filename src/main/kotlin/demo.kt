import creational.*
import creational.singleton.ApplicationContext

fun singleton() {
    val instance = ApplicationContext.getInstance()

    println("Instance classpath is ${instance.classpath}")
    println("Is instances equals? > ${instance.equals(ApplicationContext.getInstance())}")
}

fun abstractFactory() = Chest().getTreasure()

fun builder() {
    val director = PizzaDirector()

    println(director.cookPizza(PizzaType.PEPPERONI, 35))
    println(director.cookPizza(PizzaType.MUSHROOM, 15))
}

fun factoryMethod() {
    val cookiesCreator = CookiesCreator()
    val cheeseCreator = CheeseCreator()

    cookiesCreator.getProduct()
    cookiesCreator.getProduct()
    cheeseCreator.getProduct()
    cheeseCreator.getProduct()
    cookiesCreator.getProduct()
}

fun prototype() {
    val prototype = ConfigRegistry().getPrototype(ConfigType.RUN_WITH_DOCKER)

    println("Original is $prototype")
    val clone = prototype.clone()
    println("Clone is $clone")
    val modifiedConfig = clone.setCreateDockerImage(isEnabled = false)
    println("Modified clone is $modifiedConfig")
}