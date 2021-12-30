import kotlin.math.abs
import kotlin.math.max

fun main() {
    val num = readLine()!!.toInt()
    val (i, j , p) = readLine()!!.split(' ').map { it.toInt() }
    val result = Array(num) { IntArray(num) }
    for(k in 0 until num) {
        val absX = abs(i-k)
        for(m in 0 until num) {
            val absY = abs(j-m)
            if(absX > absY) {
                result[k][m] = max(p-absX, 0)
            } else {
                result[k][m] = max(p-absY, 0)
            }
        }
    }

    result.forEach {
        for(k in 0 until num) {
            print("${it[k]} ")
        }
        println()
    }
}