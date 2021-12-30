import kotlin.math.pow

fun getMin(n : Int, sum : Int, power : Int) : Int {
    if(n == 0)
        return sum
    return getMin(n-1, sum+n*(10.0.pow(power)).toInt(), power+1)
}

fun getMax(n : Int, sum : Int, power : Int, k : Int) : Int {
    if(n == 0)
        return sum
    return getMax(n-1, sum + k*(10.0.pow(power)).toInt(), power+1, k-1)
}

fun main() {
    val (b, k) = readLine()!!.split(' ').map { it.toInt() }
    for(i in getMin(k, 0, 0) .. getMax(k, 0, 0, 9)) {
        if(anyDigitRepeatingOrContainsZero(i) && (if(i%9 ==0 ) 9 else i%9) == b) {
            println(i)
            break
        }
    }
}

fun anyDigitRepeatingOrContainsZero(num1 : Int) : Boolean {
    var num = num1
    val digitCount = IntArray(10) { 0 }
    while (num != 0) {
        val rem = num%10
        if(rem == 0)
            return false
        else if(digitCount[rem] == 0)
            digitCount[rem]++
        else
            return false
        num/=10
    }
    return true
}