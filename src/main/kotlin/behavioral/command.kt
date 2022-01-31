package behavioral

import java.lang.Exception

interface Command {
    fun execute(command: String): String
}

interface Rollbackable {
    fun rollback()
}

class Select : Command {
    override fun execute(command: String): String {
        println("> Executing: $command")
        return "important-data"
    }
}

class Update : Command, Rollbackable {
    override fun execute(command: String): String {
        println("> Executing: $command")
        try {
            if (command != "good command") error("something wrong")
        } catch (e: Exception) {
            rollback()
            return "> Fail"
        }
        return "> Successful update"
    }

    override fun rollback() {
        println("> Rollback...")
    }

}

class Database {
    val select: Command = Select()
    val update: Command = Update()
}