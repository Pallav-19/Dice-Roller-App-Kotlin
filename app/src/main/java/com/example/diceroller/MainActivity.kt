package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
        // on start
        rollDice();
    }


    private fun rollDice() {
        val dice = Dice(6);
        val text = dice.roll();
        val diceImage: ImageView = findViewById(R.id.imageView)
        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (text) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = text.toString();


    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {

        return (1..sides).random()
    }
}