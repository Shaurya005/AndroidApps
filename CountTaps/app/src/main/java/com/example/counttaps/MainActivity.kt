package com.example.counttaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get reference to button
        val btn_click_me = findViewById(R.id.button) as Button
        var textview = findViewById(R.id.textView) as TextView
        var timesClicked=0


        //val btn_click_me : Button = findViewById(R.id. button) It's same as previous line
        // set on-click listener
        btn_click_me.setOnClickListener {
            timesClicked++
            textview.text=timesClicked.toString()
            Toast.makeText(this@MainActivity, "You clicked me $timesClicked times.", Toast.LENGTH_SHORT).show()
        }
    }
}