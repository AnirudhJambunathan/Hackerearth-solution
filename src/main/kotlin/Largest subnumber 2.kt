fun main() {
    for(i in 0 until readLine()!!.toInt()) {
        val (n, k) = readLine()!!.split(' ').map { it.toInt() }
        val input = readLine()!!
        val xorArray = IntArray(n)
        xorArray[0] = input[0] - '0'
        for(j in 1 until n) {
            xorArray[j] = (input[j] - '0') xor xorArray[j-1]
        }
        var reqIndex = -1
        var rem = 0
        var maxM = 0
        var previous10PowMod = 1
        val mod10k = 10%k
        for(j in n-1 downTo 1) {
            /**
                currentDigit * 10Pow + previousNum = currentNum
                On applying mod to both sides,
                (currentDigit * 10Pow + previousNum) % k = currentNum %k
                => [(currentDigit % 10Pow)%k + previousNum%k]%k
                => [[currentDigit%k * 10Pow%k] % k + previousNum%k]%k
             **/
            rem = (((input[j] - '0')%k * previous10PowMod) + rem)%k
            if(rem == 0 && input[j] != '0' && xorArray[j-1] >= maxM) {
                reqIndex = j
                maxM = xorArray[j-1]
            }
            previous10PowMod = (previous10PowMod * mod10k) % k
        }
        if(reqIndex == -1)
            println(-1)
        else
            println(input.substring(reqIndex))
    }
}