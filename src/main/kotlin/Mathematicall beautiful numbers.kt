import kotlin.math.log

fun main() {
    for(i in 0 until readLine()!!.toInt()) {
        val (x, k) = readLine()!!.split(' ').map { it.toLong() }
        var leastHighestPower = log(x.toDouble(), k.toDouble()).toInt()+1
        println(leastHighestPower)
        var sum = 0L
        val element = LongArray(leastHighestPower+1)
        element[0] = 1L
        for(j in 1 .. leastHighestPower) {
            element[j] = element[j-1]*k
        }
        while (leastHighestPower >= 0) {
            sum += element[leastHighestPower]
            if(sum == x) {
                println("YES")
                break
            } else if(sum > x) {
                sum -= element[leastHighestPower]
            } else {
                print("leastPower = $leastHighestPower, result = ${element[leastHighestPower]} ")
            }
            leastHighestPower--
        }
        if(sum < x) {
            println("\nNO")
        }
    }
}