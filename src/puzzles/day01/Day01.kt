package puzzles.day01

import puzzles.readInput
import java.io.File
import java.util.*

fun main() {
    fun parseInput(input: String): List<List<Int>> = input.split("\r\n\r\n").map { elf: String ->
        elf.lines().map { it.toInt() }
    }

//    fun List<List<Int>>.topElves(n: Int): Int {
//        return map { it.sum() }6
//            .sortedDescending()
//            .take( n )
//            .sum()
//    }

    //Java version
    fun List<List<Int>>.topElves(n: Int): Int {
        val best = PriorityQueue<Int>()
        for (calories: Int in map { it.sum() }) {
            best.add(calories)
            if (best.size > n) {
                best.poll()
            }
        }
        return best.sum()
    }

    fun part1(input: String): Int {
        val data:List<List<Int>> = parseInput(input)
        return data.topElves(1)
    }

    fun part2(input: String): Int {
        val data:List<List<Int>> = parseInput(input)
        return data.topElves(3)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/puzzles/day01/Day01_test.txt").readText()
    check(part1(testInput) == 24000 )

    val input: String = File("src/puzzles/day01/Day01_test.txt").readText()
    println(part1(input))
    //println(part2(input))
}
