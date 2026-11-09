package com.example.myage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button= findViewById(R.id.buttonDatePicker)
        //To check our button works or not
        button.setOnClickListener { view ->
            clickDatePicker(view)
            //Toast.makeText(this,"Button Works",Toast.LENGTH_LONG).show()
        }
    }
    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)
        //They are the instant date which is initially selected once Date  Picker Dialog Box appears as they're passed to OnDateSetListener as argument.

        //OnDateSetListener activates when we press OK in date picker dialog
        //Here the month starts from 0 so for December the month is 11.
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener {view, year, month, dayOfMonth ->
            Toast.makeText(this,"The chosen date is $dayOfMonth-$month-$year",Toast.LENGTH_LONG).show()

            val selectedDate = "$dayOfMonth/${month+1}/$year"
            val tvSelectedDate : TextView=findViewById(R.id.tvSelectedDate)
            tvSelectedDate.setText(selectedDate)
            //SimpleDateFormat Class allows us to format dates
            val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)//It means that it will build format of date in structure that is common in English Language
            val theDate=sdf.parse(selectedDate)//We parsed the selectedDate from String into 'Date' type object.
    },year, month, day).show()
    }
}