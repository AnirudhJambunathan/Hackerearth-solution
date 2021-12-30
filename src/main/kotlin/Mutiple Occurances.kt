fun merge(low: Int, mid : Int, high: Int, arr: Array<IntArray>) {
    val leftIndex = mid - low + 1
    val rightIndex = high - mid
    val left = Array(2) { IntArray(leftIndex) }
    val right = Array(2) { IntArray(rightIndex) }
    for(i in 0 until leftIndex) {
        left[0][i] = arr[0][low+i]
        left[1][i] = arr[1][low+i]
    }
    for(j in 0 until rightIndex) {
        right[0][j] = arr[0][mid+1+j]
        right[1][j] = arr[1][mid+1+j]
    }
    var i=0
    var j=0
    var k=low

    while (i<leftIndex && j<rightIndex) {
        if(left[0][i] <= right[0][j]) {
            arr[0][k] = left[0][i]
            arr[1][k] = left[1][i]
            i++
        } else {
            arr[0][k] = right[0][j]
            arr[1][k] = right[1][j]
            j++
        }
        k++
    }

    while (i<leftIndex) {
        arr[0][k] = left[0][i]
        arr[1][k] = left[1][i]
        i++
        k++
    }
    while (j<rightIndex) {
        arr[0][k] = right[0][j]
        arr[1][k] = right[1][j]
        j++
        k++
    }
}

fun mergeSort(low : Int, high : Int, arr : Array<IntArray>) {
    if(low < high) {
        val mid = (low+high)/2
        mergeSort(low, mid, arr)
        mergeSort(mid+1, high, arr)
        merge(low, mid, high, arr)
    }
}
fun main() {
    for(test in 0 until readLine()!!.toInt()) {
        val arrSize = readLine()!!.toInt()
        val arr = Array(2) { IntArray(arrSize) }
        arr[0] = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
        for(i in 0 until arrSize)
            arr[1][i] = i
        mergeSort(0, arrSize-1, arr)
        var i=0
        var j: Int
        var sum = 0
        while (i<arrSize-1) {
            j=i+1
            var checkIndex = -1
            while (j<arrSize) {
                if(arr[0][i] == arr[0][j])
                   checkIndex = arr[1][j]
                else
                    break
                j++
            }
            if(checkIndex != -1) {
                sum += checkIndex - arr[1][i]
                i = j
            } else {
                i++
            }
        }
        println(sum)
    }
}