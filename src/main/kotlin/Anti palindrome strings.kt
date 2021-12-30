fun main() {
    for(i in 0 until readLine()!!.toInt()) {
        val input = readLine()!!
        if(input == input.reversed()) {
            println(-1)
        } else {
            println(input.toCharArray().sortedArray().joinToString(separator = ""))
        }
    }
}