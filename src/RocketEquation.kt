fun main() {
    val sum = inputNums().map { recursiveFuelRequired(it) }.sum()
    print(sum)
}


tailrec fun recursiveFuelRequired(mass: Int, acc: Int = 0): Int {
    val fuelRequired = fuelRequired(mass)
    return if (fuelRequired <= 0) acc
    else recursiveFuelRequired(fuelRequired, fuelRequired + acc)
}

private fun inputNums(): List<Int> {
    return RocketEquation.javaClass.getResource("day1input.txt")
            .readText()
            .split("\n")
            .map {it.toInt() }
}

object RocketEquation

fun fuelRequired(mass: Int) = mass / 3 - 2