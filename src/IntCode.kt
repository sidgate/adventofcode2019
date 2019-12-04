class IntCode(private val list: MutableList<Int>) {
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
fun updatedData(vararg pairs: Pair<Int, Int>): (String) -> MutableList<Int> {
    return fun(input: String): MutableList<Int> {
        val list = input.split(",").map { it.toInt() }.toMutableList()
        pairs.forEach {
            list[it.first] = it.second
        }
        return list
    }
}


fun main() {
    val _1202 = updatedData(1 to 12, 2 to 2)
    val input = IntCode::class.java.getResource("day2input.txt").readText()
    val initialList = updatedData()(input)

    iloop@ for(i in 1..initialList.size){
        for(j in 1..initialList.size){
            try {
                val updatedData = updatedData(1 to i, 2 to j)
                val output = IntCode(updatedData(input)).process()
                val ans = output.split(",")[0]
                if(ans.toInt() == 19690720) {
                    print(i * 100 + j)
                    break@iloop
                }
            } catch (e: Exception) {
            }
        }
    }

}