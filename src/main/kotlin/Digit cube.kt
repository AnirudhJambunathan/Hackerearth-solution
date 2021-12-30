//To calculate cube of sum of the digits
fun getProd(p1 : String) : String {
    var sum = 0L
    p1.forEach {
        sum += it - '0'
    }
    return (sum*sum*sum).toString()
}

fun find(p1 : String, p2: String, q : Long) : String {
    return if(q == 0L)
        p1
    else {
        val prod = getProd(p1)
        if(prod == p1)          //If cube of sum of digits of a num is same as that num
            prod
        else if(prod == p2)     //If the same result occurs alternatively
            if(q%2 == 0L)       //If q is even, then p2's result is the final product
                getProd(p2)
            else                //Else p1's result is the final product
                prod
        else find(prod, p1,q-1L)
    }
}

fun main() {
  val result = mutableListOf<String>()
    for(i in 0 until readLine()!!.toInt()) {
        val (n, k) = readLine()!!.split(' ')
        result.add(find(n, n, k.toLong()))
    }
    for(i in 0 until result.size) {
        println(result[i])
    }
}