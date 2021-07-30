package com.example.guessmynumberapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var number : Int = 5

    private lateinit var questionTextView : TextView
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.question_text_view)//initialize
        printTheQuestion()// concatenate strings together with String.format
    }

    fun clickDownwardArrow(view : View){

        when (number) {
            5 -> {
                guessTheNumber(3)
            }
            3 -> {
                guessTheNumber(2)
            }
            2 -> {
                guessTheNumber(1)
            }
            8 -> {
                guessTheNumber(7)
            }
            7 -> {
                guessTheNumber(6)
            }
        }
    }

    fun clickSuccess(view : View){
        questionTextView = findViewById(R.id.question_text_view)
        questionTextView.visibility = View.INVISIBLE //Make TextView Invisible

        resultTextView = findViewById(R.id.result_text_view)
        resultTextView.visibility = View.VISIBLE //Make TextView Visible
        resultTextView.text = String.format(resources.getString(R.string.str_sucess), number)//set a text for result

    }

    fun clickUpwardArrow(view : View){

        when (number) {
            3 -> {
                guessTheNumber(4)
            }
            5 -> {
                guessTheNumber(8)
            }
            8 -> {
                guessTheNumber(9)
            }
            9 -> {
                guessTheNumber(10)
            }
        }
    }

    fun clickResetButton(view : View){
        questionTextView = findViewById(R.id.question_text_view)
        questionTextView.visibility = View.VISIBLE //Make TextView visible

        resultTextView = findViewById(R.id.result_text_view)
        resultTextView.visibility = View.INVISIBLE //Make TextView Invisible
        number = 5
        printTheQuestion()

    }
    private fun printTheQuestion(){
        questionTextView.text = String.format(resources.getString(R.string.str_question), number)
    }

    private fun guessTheNumber(myNumber : Int){
        number = myNumber
        printTheQuestion()
    }
}