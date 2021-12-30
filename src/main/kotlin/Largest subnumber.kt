import kotlin.math.pow

fun main() {
    for(i in 0 until readLine()!!.toInt()) {
        val (N, K) = readLine()!!.split(' ').map { it.toInt() }
        val num = readLine()!!.toLong()
        val listOfXorAnd2ndSeg = mutableListOf<Pair<Long, Long>>()
        for(j in 1 until N) {
            val divisor = 10.0.pow(N-j).toLong()
            val secondSeg = num%divisor
            if(secondSeg == 0L)
                break
            else if(secondSeg%K == 0L) {
                var firstSeg = num/divisor
                var xorValue = firstSeg%10L
                firstSeg /= 10L
                while (firstSeg != 0L) {
                    xorValue = xorValue xor (firstSeg%10L)
                    firstSeg /= 10L
                }
                listOfXorAnd2ndSeg.add(Pair(xorValue, secondSeg))
            }
        }
        var maxXor = 0L
        var maxSecondSeg = -1L
        for(entry in listOfXorAnd2ndSeg) {
            if(entry.first > maxXor) {
                maxXor = entry.first
                maxSecondSeg = entry.second
            } else if(entry.first == maxXor && entry.second > maxSecondSeg) {
                maxSecondSeg = entry.second
            }
        }
        println(maxSecondSeg)
    }
}
