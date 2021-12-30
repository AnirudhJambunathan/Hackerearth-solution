private var num = 0L
private val specialNumbers = mutableListOf<Long>()

private fun gcd(num1 : Long, num2 : Long) : Long {
    if(num1 == 0L)
        return num2
    return gcd(num2%num1, num1)
}

private fun getAllNumbers(seed : Long) {
    if(seed > num)
        return
    else {
        specialNumbers.add(seed)
        getAllNumbers(seed*10L+4L)
        getAllNumbers(seed*10L+7L)
    }
}

fun main() {
    num = readLine()!!.toLong()
    getAllNumbers(4L)
    getAllNumbers(7L)
    specialNumbers.forEach {
        println(it)
    }
    var result = 0
    for(i in 0 until specialNumbers.size-1) {
        for(j in i+1 until specialNumbers.size) {
            if(gcd(specialNumbers[i], specialNumbers[j]) == 1L) {
                result++
            }
        }
    }
    println(result)
}