fun main() {
    val sumList = mutableListOf<Int>()
    for(l in 0 until readLine()!!.toInt()) {
        val (N, M) = readLine()!!.split(' ').map { it.toInt() }
        val maxIndex = N+M+1
        val spf = IntArray(N+M+1){ i-> i }
        val npf = IntArray(N+M+1)
        for(i in 4 until maxIndex step 2) {
            spf[i] = 2
        }
        var i=3
        while (i*i < maxIndex) {
            if(spf[i] == i) {
                var j=i*i
                while (j < maxIndex) {
                    if(spf[j] == j)
                        spf[j] = i
                    j += i
                }
            }
            i++
        }

        for(j in 2 until maxIndex) {
            npf[j] = numOfFactors(*spf, num1=j)
        }
        var sum = 0
        val minValue = kotlin.math.min(N, M)
        val sumNM = N + M
        for(j in 1..minValue) {
            sum += j*npf[j+1] + j*npf[sumNM-j+1]
        }
        if(N == M) {
            sum -= minValue*npf[minValue+1]
        } else {
            for(j in minValue+2 .. (sumNM-minValue)) {
                sum += minValue*npf[j]
            }
        }
        sumList.add(sum)
    }
    sumList.forEach { println(it) }
}

fun numOfFactors(vararg spf : Int, num1 : Int) : Int {
    var num = num1
    var factors = 0
    while(num != 1) {
        val c = num
        num /= spf[num]
        if(spf[c] != spf[num]) {
            factors++
        }
    }
    return factors
}