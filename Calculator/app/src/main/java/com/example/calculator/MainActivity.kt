package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val num1=findViewById<EditText>(R.id.EtNum1)
        val num2=findViewById<EditText>(R.id.EtNum2)
        val add=findViewById<Button>(R.id.add)
        val subtract=findViewById<Button>(R.id.Subtract)
        val multiply=findViewById<Button>(R.id.multiply)
        val divide=findViewById<Button>(R.id.divide)
        val power=findViewById<Button>(R.id.power)
        val percent=findViewById<Button>(R.id.percent)
        val res=findViewById<TextView>(R.id.textViewResult)
        add.setOnClickListener {
            val StringInnum1=num1.text.toString()
            val StringInnum2=num2.text.toString()
            val n1=StringInnum1.toDoubleOrNull()
            val n2=StringInnum2.toDoubleOrNull()
            val result : Double // Defining result without ":Double" here gives error
            if(n1==null||n2==null)
                result = 0.0
            else
                result=n1+n2
            res.setText(result.toString())
        }
        subtract.setOnClickListener {
            val StringInnum1=num1.text.toString()
            val StringInnum2=num2.text.toString()
            val n1=StringInnum1.toDoubleOrNull()
            val n2=StringInnum2.toDoubleOrNull()
            val result : Double // Defining result without ":Double" here gives error
            if(n1==null||n2==null)
                result = 0.0
            else
                result=n1-n2
            res.setText(result.toString())
        }
        multiply.setOnClickListener {
            val StringInnum1=num1.text.toString()
            val StringInnum2=num2.text.toString()
            val n1=StringInnum1.toDoubleOrNull()
            val n2=StringInnum2.toDoubleOrNull()
            val result : Double // Defining result without ":Double" here gives error
            if(n1==null||n2==null)
                result = 0.0
            else
                result=n1*n2
            res.setText(result.toString())
        }
        divide.setOnClickListener {
            val StringInnum1=num1.text.toString()
            val StringInnum2=num2.text.toString()
            val n1=StringInnum1.toDoubleOrNull()
            val n2=StringInnum2.toDoubleOrNull()
            val result : Double // Defining result without ":Double" here gives error
            if(n1==null||n2==null)
                result = 0.0
            else
                result=n1/n2
            res.setText(result.toString())
        }
        power.setOnClickListener {
            val StringInnum1=num1.text.toString()
            val StringInnum2=num2.text.toString()
            val n1=StringInnum1.toDoubleOrNull()
            val n2=StringInnum2.toDoubleOrNull()
            val result : Double // Defining result without ":Double" here gives error
            if(n1==null||n2==null)
                result = 0.0
            else
                result=n1.pow(n2)
            res.setText(result.toString())
        }
        percent.setOnClickListener {
            val StringInnum1=num1.text.toString()
            val StringInnum2=num2.text.toString()
            val n1=StringInnum1.toDoubleOrNull()
            val n2=StringInnum2.toDoubleOrNull()
            val result : Double // Defining result without ":Double" here gives error
            if(n1==null||n2==null)
                result = 0.0
            else
                result=n1*n2/100
            res.setText(result.toString())
        }
    }
}