package com.example.calculator20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button9=findViewById<Button>(R.id.button9)
        val button8=findViewById<Button>(R.id.button8)
        val button7=findViewById<Button>(R.id.button7)
        val button6=findViewById<Button>(R.id.button6)
        val button5=findViewById<Button>(R.id.button5)
        val button4=findViewById<Button>(R.id.button4)
        val button3=findViewById<Button>(R.id.button3)
        val button2=findViewById<Button>(R.id.button2)
        val button1=findViewById<Button>(R.id.button1)
        val button0=findViewById<Button>(R.id.button0)
        val buttonadd=findViewById<Button>(R.id.buttonadd)
        val buttonsub=findViewById<Button>(R.id.buttonsubtract)
        val buttondiv=findViewById<Button>(R.id.buttondivide)
        val buttonmult=findViewById<Button>(R.id.buttonmultiply)

    }
}