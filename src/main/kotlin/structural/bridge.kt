package structural

import java.lang.Exception
import kotlin.random.Random

open class Database(
    protected val path: String
) {

    fun runCommand(command: String) {
        println("> Running $command...")
        println("> Done")
    }

}

class RedisDatabase(
    private val size: Long
) : Database("heap:///redis/") {

    init {
        if (size > 50000) error("Decrease db size")
    }

}

class Neo4jDatabase : Database("localhost:1337")

open class DatabaseAdmin(
    private val db: Database
) {

    fun runCommand(command: String, userId: Long) {
        if (!isPermitted(userId)) {
            println("ERROR: RED ALERT!")
            return
        }
        db.runCommand(command)
    }

    private fun isPermitted(userId: Long): Boolean = userId < Random.nextInt()

}

class DatabaseSuperAdmin(
    db: Database
) : DatabaseAdmin(db) {

    fun dropDb() {
        println("DB was successfully dropped")
    }

}