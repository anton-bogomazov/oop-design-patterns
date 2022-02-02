package behavioral

import java.util.*
import kotlin.collections.HashMap
import kotlin.system.exitProcess

// from https://github.com/joaodelgado/fuck-kotlin

class BrainfuckInterpreter(
    private val program: String
) {
    fun run() {
        val jumps = matchJumps(program)
        val mem = MutableList(30000, init = { 0 })
        var pc = 0
        var cursor = 0

        while (pc < program.length) {
            when (program[pc]) {
                '+' -> mem[cursor] = (mem[cursor] + 1) % 255
                '-' -> mem[cursor] = (mem[cursor] - 1) % 255
                '>' -> cursor++
                '<' -> cursor--
                '[' -> {
                    if (mem[cursor] == 0) {
                        pc = jumps[pc] as Int
                    }
                }
                ']' -> {
                    pc = jumps[pc] as Int
                    pc--
                }
                '.' -> print("${mem[cursor].toChar()}")
                ',' -> mem[cursor] = System.`in`.read()
            }

            pc++
        }
    }

    private fun matchJumps(program: String): Map<Int, Int> {
        val stack = Stack<Int>()
        val jumpsMap = HashMap<Int, Int>()

        for ((i, c) in program.withIndex()) {
            when (c) {
                '[' -> stack.push(i)
                ']' -> {
                    try {
                        val other = stack.pop()
                        jumpsMap[other] = i
                        jumpsMap[i] = other
                    } catch (e: EmptyStackException) {
                        println("Program has unmatched brackets.")
                        exitProcess(1)
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            println("Program has unmatched brackets.")
            exitProcess(1)
        }

        return jumpsMap
    }
}
