package creational

import kotlin.random.Random

// abstraction

interface TreasureGenerator {
    fun spawn(): Treasure
}

interface Treasure {
    fun logTreasure() = println("Player found $this")
}

// concrete

class Rupee(val value: Long) : Treasure {
    override fun toString() = "Rupee with value=$value"
}

class HeartContainer : Treasure {
    override fun toString() = "Heart Container!"
}

class RupeeGenerator : TreasureGenerator {

    override fun spawn(): Rupee {
        val rupeeValue: Long =
            when(Random.nextLong() % 100) {
                in 0..4 -> 500
                in 5..14 -> 200
                in 15..29 -> 100
                in 30..59 -> 50
                in 60..89 -> 20
                else -> 10
            }

        return Rupee(rupeeValue)
    }

}

class HeartContainerGenerator : TreasureGenerator {

    override fun spawn(): HeartContainer = HeartContainer()

}

class Chest {

    fun getTreasure() {
        val generator = if (Random.nextInt() % 10 != 0) RupeeGenerator() else HeartContainerGenerator()
        generator.spawn().logTreasure()
    }

}
