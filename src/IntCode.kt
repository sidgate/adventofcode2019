class IntCode(private val input: String) {
    var list = input.split(",").map { it.toInt() }.toMutableList()
    fun process(): String {
        loop@ for(index in 0..list.size step 4){
            when(list[index]){
                99 -> break@loop
                1 -> list[list[index+3]] = list[list[index+1]] + list[list[index+2]]
                2 -> list[list[index+3]] = list[list[index+1]] * list[list[index+2]]
            }
        }
        return list.joinToString(",")
    }

}

fun main() {
    val input = IntCode::class.java.getResource("day2input.txt").readText()
    print(IntCode(input).process())
}