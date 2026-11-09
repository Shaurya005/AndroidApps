package com.example.choosemybeer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0;
        var button: Button = findViewById<Button>(R.id.find_beer)
    /*    button.setOnClickListener {
            count++
            if (count % 2 != 0) {
                button.text = "Button Clicked $count times"
                button.textSize = 32F
            }
            else{
                button.text = "Button Clicked $count times"
                button.textSize=16F
        }
        }
     */
    }
    fun onClickFindBeer(view: View){
        var brands : TextView = findViewById(R.id.brands)
        var color=findViewById<Spinner>(R.id.color)
//If the above two reference is created outside this function block then although the system won't show any error but app will get installed and closed instantly.
        val beerType =(color.selectedItem).toString()
        //brands.text=beerType
        brands.setText(beerType)
    }
}