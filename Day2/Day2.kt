import java.io.File
import java.io.InputStream
import javax.xml.crypto.dsig.keyinfo.KeyValue

fun main(args: Array<String>){
    part1()
    part1Revised()
    part2()

}
fun part2() {
    println("*******PART 2*********")
    var maxLettersInCommon = 0
    var commonLetters = ""
    val inputStream: InputStream = File("input.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readLines() }
    inputString.forEach { currentWordCompare ->//select 1 word at a time and compare it to all others
        inputString.forEach { wordBeingCompared->//iterate through all the words on each line
            if(!(currentWordCompare.equals(wordBeingCompared))){//ignore itself
                var currentMaxLettersInCommon = 0
                var currentCommonLetters = ""
                for(i in 0..(wordBeingCompared.length-1)){//iterate through all the char in the word
                    if(wordBeingCompared[i] == currentWordCompare[i]){
                        currentCommonLetters += wordBeingCompared[i]
                        currentMaxLettersInCommon++
                    }
                }
                if(currentMaxLettersInCommon>maxLettersInCommon){
                    //set the new record
                    maxLettersInCommon = currentMaxLettersInCommon
                    commonLetters = currentCommonLetters
                }
            }
        }
    }
    println("Max letters in common == "+maxLettersInCommon)
    println("Common letters are == "+commonLetters+"\n")
}

fun part1Revised(){
    println("*******PART 1*********")
    val inputStream: InputStream = File("input.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readLines() }
    val lineNums = inputString.map { inputString->
        inputString.groupingBy { it }.eachCount().values
    }
    println("The number of 2 occurences is "+lineNums.count { 2 in it })
    println("The number of 3 occurences is "+lineNums.count{3 in it})
    println("CheckSum is  "+lineNums.count { 2 in it }*lineNums.count { 3 in it }+"\n")
}
fun part1(){
    println("*******PART 1*********")
    var twoTimes = 0
    var threeTimes = 0
    val inputStream: InputStream = File("input.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readLines() }

    inputString.forEach { fullStringPerLine: String ->
        var hasTwo = false
        var hasThree = false
        fullStringPerLine.forEach { letter: Char->
            val letterSeen = arrayListOf<Char>()
            if(!letterSeen.contains(letter)) {
                val occurrences = countSubstring(fullStringPerLine,letter.toString())
                letterSeen.add(letter)
                if(occurrences == 2 && !hasTwo){
                    twoTimes++
                    hasTwo = true
                }
                else if(occurrences == 3 && !hasThree){
                    threeTimes++
                    hasThree = true
                }
            }
        }
    }
    println("The number of 2 occurences is "+twoTimes)
    println("The number of 3 occurences is "+threeTimes)
    println("CheckSum is  "+threeTimes*twoTimes+"\n")
}

fun countSubstring(fullString: String, letter: String): Int = fullString.split(letter).size - 1
fun stripChars(s: String, r: String) = s.replace(Regex("[$r]"), "")