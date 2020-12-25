package com.example.calculator__

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var firstVariable:Double = 0.0
    private var secondVariable:Double= 0.0
    private var operation = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }
    private fun init(){
        Button0.setOnClickListener(this)
        Button1.setOnClickListener(this)
        Button2.setOnClickListener(this)
        Button3.setOnClickListener(this)
        Button4.setOnClickListener(this)
        Button5.setOnClickListener(this)
        Button6.setOnClickListener(this)
        Button7.setOnClickListener(this)
        Button8.setOnClickListener(this)
        Button9.setOnClickListener(this)



        dotButton.setOnClickListener {
            if (resultTextView.text.isNotEmpty() && "." !in resultTextView.text.toString()){
                resultTextView.text = resultTextView.text.toString() + "."

            }


        }
        deleteButton.setOnLongClickListener {
            if (resultTextView.text.isNotEmpty())
                resultTextView.text=""
            true
        }
    }

    fun delete(view: View){
        val value = resultTextView.text.toString()
        if (value.isNotEmpty())
        resultTextView.text = value.substring(startIndex = 0, endIndex = value.length - 1)


    }

    fun divide(view: View){
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()){
        firstVariable = value.toDouble()
        operation = "÷"
        resultTextView.text = ""
        }

    }
    fun plus(view: View){
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()){
            firstVariable=value.toDouble()
            operation= "+"
            resultTextView.text= ""
        }
    }
    fun minus(view: View){
        val value=resultTextView.text.toString()
        if (value.isNotEmpty()){
            firstVariable=value.toDouble()
            operation="-"
            resultTextView.text=""
        }
    }
    fun multipl(view: View){
        val value=resultTextView.text.toString()
        if (value.isNotEmpty()){
            firstVariable=value.toDouble()
            operation="x"
            resultTextView.text=""
        }
    }
    fun equal(view: View){
        val value = resultTextView.text.toString()

        if (value.isNotEmpty() && operation.isNotEmpty()) {
            secondVariable = value.toDouble()
            var result:Double = 0.0
            if (operation == "÷" && secondVariable!=0.0) {
                result=firstVariable/secondVariable

            }else if (operation=="+"){
                result=firstVariable+secondVariable
            }else if (operation=="-"){
                result= firstVariable-secondVariable
            }else if(operation=="x"){
                result=firstVariable*secondVariable
            }else if(operation=="÷" && secondVariable==0.0){
                Toast.makeText(this, "Number is not divisable by zero", Toast.LENGTH_SHORT).show()


            }


            resultTextView.text = result.toString()
            operation=""
            firstVariable=0.0
            secondVariable=0.0

            }


        }



    override fun onClick(v: View?) {
       val button = v as Button
        resultTextView.text=resultTextView.text.toString() + button.text.toString()


    }
}