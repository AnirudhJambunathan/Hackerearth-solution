fun main() {
    for(test in 0 until readLine()!!.toInt()) {
        val N = readLine()!!.toLong()
        var sum = 0L
        var divisor = 1L
        while(true) {
            val i = N/divisor
            val j = N/(divisor+1) + 1
            if(i == j)
                break
            sum += (i-j+1)*divisor
            divisor++
        }
        var z=N/divisor
        while (z != 0L) {
            z--
            sum += N/(z+1)
        }
        println(sum)
    }
}