//Author : NGO KIAN HEE
package com.example.practical1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    /*Why do i use global variable? Because when a new random number is generated.
    i store the current random number into currentDiceNumber
    i will count up the dice number by using the currentDiceNumber
    image resource will be retrieve by putting the latest currentDiceNumber into parameter of getDrawableImage()*/
    var currentDiceNumber=0
    var currentDiceNumber2=0
    var currentDiceNumber3=0
    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView
    lateinit var diceImage3 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val countUp: Button = findViewById(R.id.count_up)
        val resetDice: Button = findViewById(R.id.reset_dice)
//        val sumDice: Button = findViewById(R.id.sum_dice)
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)
        diceImage3 = findViewById(R.id.dice_image3)
        rollButton.setOnClickListener { rollDice() }
        countUp.setOnClickListener{countUp()}
        resetDice.setOnClickListener{resetDice()}
//        sumDice.setOnClickListener{totalSum()}
        totalSum()

    }
    private fun rollDice() {
        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
//        val resultText: TextView = findViewById(R.id.result_text)
//        val resultText2: TextView = findViewById(R.id.result_text2)
//        val resultText3: TextView = findViewById(R.id.result_text3)
//        val diceImage: ImageView = findViewById(R.id.dice_image)
//        val diceImage2: ImageView = findViewById(R.id.dice_image2)
//        val diceImage3: ImageView = findViewById(R.id.dice_image3)
        currentDiceNumber=getRandomDiceNumber()
        diceImage.setImageResource(getDrawableImage(currentDiceNumber))
        currentDiceNumber2=getRandomDiceNumber()
        diceImage2.setImageResource(getDrawableImage(currentDiceNumber2))
        currentDiceNumber3=getRandomDiceNumber()
        diceImage3.setImageResource(getDrawableImage(currentDiceNumber3))
//        resultText.text="Dice Rolled!"
//        val randomInt = Random().nextInt(6)+ 1
//        val randomInt2 = Random().nextInt(6)+ 1
//        val randomInt3 = Random().nextInt(6)+ 1
//
//
//        resultText.text = randomInt.toString()
//        resultText2.text = randomInt2.toString()
//        resultText3.text = randomInt3.toString()
        totalSum()

    }
    private fun getRandomDiceNumber() : Int {
        val randomInt = Random().nextInt(6) + 1
        /*return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }*/
        return randomInt
    }

    private fun countUp() {
        /*val resultText: TextView = findViewById(R.id.result_text)
        val resultText2: TextView = findViewById(R.id.result_text2)
        val resultText3: TextView = findViewById(R.id.result_text3)
        if(!resultText.text.isDigitsOnly()){
            resultText.text= "1" //default is 1
        }else{
            var rolledResult = resultText.text.toString().toInt()
            if(rolledResult<6){
                rolledResult++ //add 1 to the resultText(current result)
                resultText.text=rolledResult.toString() //update the text view
            }
        }
        if(!resultText2.text.isDigitsOnly()){
            resultText2.text="1" //default is 1
        }else{
            var rolledResult = resultText2.text.toString().toInt()
            if(rolledResult<6){
                rolledResult++ //add 1 to the resultText(current result)
                resultText2.text=rolledResult.toString() //update the text view
            }
        }
        if(!resultText3.text.isDigitsOnly()){
            resultText3.text="1" //default is 1
        }else{
            var rolledResult = resultText3.text.toString().toInt()
            if(rolledResult<6){
                rolledResult++ //add 1 to the resultText(current result)
                resultText3.text=rolledResult.toString() //update the text view
            }
        }*/
        currentDiceNumber++
        if(currentDiceNumber>=6){
            currentDiceNumber=6
        }
        diceImage.setImageResource(getDrawableImage(currentDiceNumber))
        currentDiceNumber2++
        if(currentDiceNumber2>=6){
            currentDiceNumber2=6
        }
        diceImage2.setImageResource(getDrawableImage(currentDiceNumber2))
        currentDiceNumber3++
        if(currentDiceNumber3>=6){
            currentDiceNumber3=6
        }
        diceImage3.setImageResource(getDrawableImage(currentDiceNumber3))
        totalSum()

    }
    private fun getDrawableImage(x: Int) : Int {
        return when (x) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
    private fun resetDice() {
        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
        currentDiceNumber = 0
        currentDiceNumber2 = 0
        currentDiceNumber3 = 0
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
        diceImage3.setImageResource(R.drawable.empty_dice)
        totalSum()
    }
    private fun totalSum(){
        val totalSum: TextView = findViewById(R.id.totalSum)
        totalSum.text = String.format("Sum of dice number : %d",(currentDiceNumber+ currentDiceNumber2 + currentDiceNumber3))
    }
}
