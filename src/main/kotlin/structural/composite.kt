package structural

interface AbstractRegistryComponent

abstract class RegistryComponent : AbstractRegistryComponent {
    private val children = mutableListOf<AbstractRegistryComponent>()

    fun addChild(child: AbstractRegistryComponent): RegistryComponent {
        children.add(child)
        return this
    }

    fun removeChild(child: AbstractRegistryComponent): RegistryComponent {
        children.remove(child)
        return this
    }

    fun getChildrenList(): List<Citizen> {
        val leaves = mutableListOf<Citizen>()
        if (this is Citizen) {
            leaves.add(this)
        } else {
            for (child in children) {
                leaves.addAll((child as RegistryComponent).getChildrenList())
            }
        }
        return leaves
    }

}

class CityCitizenRegistry : RegistryComponent()

class Family : RegistryComponent()

data class Citizen(
    var name: String,
    var age: Long
) : RegistryComponent()