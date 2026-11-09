package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    var lastNumeric = false
    var lastDot = false
   // var tvInput : TextView=findViewById(R.id.tvInput) App was not opening if we have used it here instead of separately for each function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onEqual(view:View){
        var tvInput : TextView=findViewById(R.id.tvInput)
        if(lastNumeric){
            var tvValue = tvInput.text.toString()
            var prefix=""
            try{
                if(tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                if(tvValue.contains("-")){
                    val splitValue = tvValue.split("-")
                    var one=splitValue[0]
                    var two=splitValue[1]
                    if(!prefix.isEmpty()){
                        one=prefix+one
                    }
                    tvInput.text=removeZeroAfterDot((one.toDouble()-two.toDouble()).toString())
                }
                if(tvValue.contains("+")){
                    val splitValue = tvValue.split("+")
                    var one=splitValue[0]
                    var two=splitValue[1]
                    if(!prefix.isEmpty()){
                        one=prefix+one
                    }
                    tvInput.text=(one.toDouble()+two.toDouble()).toString()
                }
                if(tvValue.contains("*")){
                    val splitValue = tvValue.split("*")
                    var one=splitValue[0]
                    var two=splitValue[1]
                    if(!prefix.isEmpty()){
                        one=prefix+one
                    }
                    tvInput.text=removeZeroAfterDot((one.toDouble()*two.toDouble()).toString())
                }
                if(tvValue.contains("/")){
                    val splitValue = tvValue.split("/")
                    var one=splitValue[0]
                    var two=splitValue[1]
                    if(!prefix.isEmpty()){
                        one=prefix+one
                    }
                    tvInput.text=removeZeroAfterDot((one.toDouble()/two.toDouble()).toString())
                }
            }
            catch(e: ArithmeticException){ e.printStackTrace() }
        }
    }
    fun onDigit(view: View){
        var tvInput : TextView=findViewById(R.id.tvInput)
        tvInput.append((view as Button).text)
        lastNumeric = true
        //if(tvInput.text.contains("1"))
          //  tvInput.text = ""
    }
   fun onClear(view: View){
       var tvInput : TextView=findViewById(R.id.tvInput)
       tvInput.text=""
        lastNumeric = false
        lastDot = false
    }
    fun onDecimal(view: View){
        var tvInput : TextView=findViewById(R.id.tvInput)
        if(lastNumeric && !lastDot) {
            tvInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    private fun removeZeroAfterDot(result:String):String{
        var value=result
        if(result.contains("0"))
            value=result.substring(0,result.length-2)
        return value
    }
    fun onOperator(view:View){
        var tvInput : TextView=findViewById(R.id.tvInput)
        if(lastNumeric && !isOperatorAdded(tvInput.text.toString())){
            tvInput.append((view as Button).text)
            lastDot=false
            lastNumeric=false
        }
    }
    private fun isOperatorAdded(value: String) : Boolean{
        return if (value.startsWith("-"))
            false
        else
            value.contains("/")||value.contains("*")||value.contains("+")||value.contains("-")
            //contains function return boolean value
    }
}