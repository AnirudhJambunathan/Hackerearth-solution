fun main() {
    val vaccineCount = readLine()!!.toInt()
    val virusRNALen = readLine()!!.toInt()
    val virusRNA = readLine()!!
    var highestCount = 0
    var highestCountIndex = 0
    var virusG = 0
    var virusC = 0
    for(i in 0 until virusRNALen) {
        if(virusRNA[i] == 'G')
            virusG++
        else if(virusRNA[i] == 'C')
            virusC++
    }
    for (i in 1 .. vaccineCount) {
        val vaccineRNALen = readLine()!!.toInt()
        val vaccineRNA = readLine()!!
        var vaccineG = 0
        var vaccineC = 0
        for(j in 0 until vaccineRNALen) {
            if(vaccineRNA[j] == 'G')
                vaccineG++
            else if(vaccineRNA[j] == 'C')
                vaccineC++
        }
        val matchCount = virusC*vaccineG + vaccineC*virusG
        if(matchCount > highestCount) {
            highestCount = matchCount
            highestCountIndex = i
        }
    }
    println(highestCountIndex)
}