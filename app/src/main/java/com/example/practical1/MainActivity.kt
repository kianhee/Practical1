package com.example.practical1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val countUp: Button = findViewById(R.id.count_up)
        val resetDice: Button = findViewById(R.id.reset_dice)
        rollButton.setOnClickListener { rollDice() }
        countUp.setOnClickListener{countUp()}
        resetDice.setOnClickListener{resetDice()}
    }
    private fun rollDice() {
        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        val resultText2: TextView = findViewById(R.id.result_text2)
        val resultText3: TextView = findViewById(R.id.result_text3)
        //resultText.text="Dice Rolled!"
        val randomInt = Random().nextInt(6)+ 1
        val randomInt2 = Random().nextInt(6)+ 1
        val randomInt3 = Random().nextInt(6)+ 1
        resultText.text = randomInt.toString()
        resultText2.text = randomInt2.toString()
        resultText3.text = randomInt3.toString()
    }
    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
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
        }
    }
    private fun resetDice() {
        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        val resultText2: TextView = findViewById(R.id.result_text2)
        val resultText3: TextView = findViewById(R.id.result_text3)
        resultText.text = "0"
        resultText2.text = "0"
        resultText3.text = "0"
    }

}
