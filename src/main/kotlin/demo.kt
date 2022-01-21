import creational.*
import creational.singleton.ApplicationContext
import structural.*

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

fun adapter() {
    val legacyCreator = LegacyCreator()
    val adapterToModern = FieldCreatorAdapter(ModernCreator())
    val data = "Hello!"

    println("Created with legacy creator: ${legacyCreator.createField(data)}")
    println("Created with modern creator: ${adapterToModern.createField(data)}")
}

fun bridge() {
    val admin = DatabaseAdmin(Neo4jDatabase())

    admin.runCommand("SELECT * FROM table", 14)
}

fun composite() {
    val johnsonFamily = Family()
        .addChild(Citizen("John Johnson",46))
        .addChild(Citizen("Mary Johnson",23))
    val lawsonFamily = Family()
        .addChild(Citizen("Gilbert Lawson",24))
        .addChild(Citizen("Kara Lawson",17))
        .addChild(Citizen("Cory Lawson",2))
    val atlantaRegistry = CityCitizenRegistry()
        .addChild(johnsonFamily)
        .addChild(lawsonFamily)

    println(atlantaRegistry.getChildrenList())
}

fun decorator() {
    val source = FileDataSource("program.js")

    val baseDecorator = DataSourceDecorator(source)
    baseDecorator.write("beep-boop-js-code")
    InterpreterDecorator(source).runCode()
}