fun merge(arr : IntArray, low: Int, mid: Int, high : Int) {
    val arr1Len = mid-low+1
    val arr2Len = high - mid
    val arr1 = IntArray(arr1Len)
    val arr2 = IntArray(arr2Len)

    for(i in 0 until arr1Len) {
        arr1[i] = arr[low+i]
    }
    for(i in 0 until arr2Len) {
        arr2[i] = arr[mid+1+i]
    }
    var i = 0
    var j = 0
    var k = low
    while (i < arr1Len && j < arr2Len) {
        if(arr1[i] <= arr2[j]) {
            arr[k] = arr1[i]
            i++
        } else {
            arr[k] = arr2[j]
            j++
        }
        k++
    }

    while (i < arr1Len) {
        arr[k] = arr1[i]
        i++
        k++
    }
    while (j < arr2Len) {
        arr[k] = arr2[j]
        j++
        k++
    }
}

fun sort(arr : IntArray, low: Int, high : Int) {
    if(low < high) {
        val mid = (low+high)/2
        sort(arr, low, mid)
        sort(arr, mid+1, high)
        merge(arr, low, mid, high)
    }
}
fun main() {
    loop@for(i in 0 until readLine()!!.toInt()) {
        val (L, S) = readLine()!!.split(' ').map { it.toInt() }
        val arr = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
        sort(arr, 0, arr.size-1)
        var sum = 0
        for(j in arr.indices) {
            sum += arr[j]
            if(sum > L) {
                println(j)
                continue@loop
            }
        }
        println(S)
    }
}