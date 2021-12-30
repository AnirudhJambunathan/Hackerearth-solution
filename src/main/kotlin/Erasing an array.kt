fun main() {
    for(i in 0 until readLine()!!.toInt()) {
        val arrCount = readLine()!!.toInt()
        val arr = readLine()!!.split(' ').map { it.toInt() }
        var segments = 1
        var j=0
        var k : Int
        while(j < arrCount-1) {
            k = j+1
            if(arr[j] == 0) {
                var goingUpwards = false
                while (k < arrCount) {
                    if(arr[k] == 1) {
                        goingUpwards = true
                    } else if(arr[k] == 0 && goingUpwards) {
                        segments++
                        break
                    }
                    k++
                }
            } else {
                while(k < arrCount) {
                    if(arr[k] == 0) {
                        segments++
                        break
                    }
                    k++
                }
            }
            j=k
        }
        println(segments)
    }
}