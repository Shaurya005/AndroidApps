package com.example.myintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

const val KEY_1="Name"
const val KEY_2="Age"
const val KEY_3="isStudent"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn:Button=findViewById(R.id.btn)
        btn.setOnClickListener {
            val i= Intent(this,MainActivity2::class.java)
            i.putExtra(KEY_1,"Pulkit")
            i.putExtra(KEY_2,23)
            i.putExtra(KEY_3,true)
            startActivity(i)
        }
    }
}