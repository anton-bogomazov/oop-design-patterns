package structural

import kotlin.random.Random

class CommonGrass(
    private val texture: String
) {
    fun draw(x: Long, y: Long) {
        println("> Drawing grass in {$x;$y} with <$texture> texture")
    }
}

class Grass(
    private val commonGrass: CommonGrass,
    private val x: Long = Random.nextLong(),
    private val y: Long = Random.nextLong()
) {
    fun draw() = commonGrass.draw(x, y)
}