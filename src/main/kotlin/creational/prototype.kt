package creational

interface Cloneable {
    fun clone() : Cloneable
}

class ConfigRegistry {

    private val registry = mutableMapOf<String, Configuration>()

    fun getPrototype(name: ConfigType) = registry[name.toString()] ?: error("There is no prototype with name=$name")
    fun addPrototype(type: ConfigType, prototype: Configuration) = registry.put(type.toString(), prototype)

    init {
        addPrototype(
            ConfigType.ONLY_TESTS,
            Configuration(
                type = ConfigType.ONLY_TESTS,
                runTests = true,
                runAfterBuild = false,
                createDockerImage = false,
                addEnvVariables = false))
        addPrototype(
            ConfigType.RUN_WITH_DOCKER,
            Configuration(
                type = ConfigType.RUN_WITH_DOCKER,
                runTests = false,
                runAfterBuild = false,
                createDockerImage = true,
                addEnvVariables = true))
    }

}

enum class ConfigType {
    ONLY_TESTS, RUN_WITH_DOCKER
}

class Configuration(
    private val type: ConfigType,
    private val runTests: Boolean,
    private val runAfterBuild: Boolean,
    private var createDockerImage: Boolean,
    private val addEnvVariables: Boolean
) : Cloneable {

    override fun clone(): Configuration =
        Configuration(
            type = this.type,
            runTests = this.runTests,
            runAfterBuild = this.runAfterBuild,
            createDockerImage = this.createDockerImage,
            addEnvVariables = this.addEnvVariables)

    fun setCreateDockerImage(isEnabled: Boolean): Configuration {
        createDockerImage = isEnabled

        return this
    }

    override fun toString() = "Configuration(\n\ttype = ${this.type},\n\trunTests = ${this.runTests},\n\trunAfterBuild = ${this.runAfterBuild},\n" +
            "\tcreateDockerImage = ${this.createDockerImage},\n\taddEnvVariables = ${this.addEnvVariables})"
}
