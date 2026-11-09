package com.example.myintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val i=intent.getStringExtra(KEY_1)
        val age=intent.getIntExtra(KEY_2,-1)
        val isStudent=intent.getBooleanExtra(KEY_3,false)
        val text=findViewById<TextView>(R.id.textView)
        text.text="Name = $i Age = $age IsStudent = $isStudent"
    }
}