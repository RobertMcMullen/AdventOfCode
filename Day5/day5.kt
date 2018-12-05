package Day5

import java.io.File
import java.io.InputStream
import java.lang.StringBuilder
import java.sql.Time
import java.util.*
import kotlin.collections.ArrayList


fun main(args: Array<String>){

    part1()
    part2()
}

fun part1() {

    val inputStream: InputStream = File("Inputs/day5.txt").inputStream()
    val inputStreamTest: InputStream = File("TestInputs/day5_test.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readLine() }

    val input = StringBuilder(inputString)
    var finalProduct = cleanString(input)

    println("done")
    println(finalProduct)
    println(finalProduct.length)

}

fun part2(){
    val inputStream: InputStream = File("Inputs/day5.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readLine() }
    val input = StringBuilder(inputString)

    var bestResult =10000
    val letterLow:String = "abcdefghijklmnopqrstuvwxyz"
    for (i in (0 until letterLow.length )) {
        val fullInputString = input
        val total = cleanStringPart2(letterLow[i],fullInputString)
        if(total<bestResult){
            bestResult=total
        }
        println("Using letter " + letterLow[i] + ", length == " + total)
    }
    println("THE BEST RESULT IS $bestResult")
}
fun cleanStringPart2(inputLetter:Char,currentInput:StringBuilder):Int {

    var returnString:StringBuilder = StringBuilder()

    currentInput.forEach { letter ->
        if (!letter.equals(inputLetter, true)) {
            returnString.append(letter)
        }
    }
    return cleanString(returnString).length
}



fun cleanString(input:StringBuilder):StringBuilder{
    var isDone = false
    while(!isDone) {
        var itemRemoved = false
        for (i in (0 until input.length - 1)) {
            if(input[i].equals(input[i+1],ignoreCase = true) && !input[i].equals(input[i+1],ignoreCase = false)){
                input.delete(i,i+2)
                itemRemoved = true
                break
            }
        }
        if(!isDone && !itemRemoved){
            isDone = true
        }
    }
    return input


}




