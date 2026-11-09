package com.example.randomizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import kotlin.random.Random

/*
The first piece of an app is layout which describes how the app should look. In Android layouts are created by combining different types of views.
A view is just a rectangular area on the screen but there are views that contain text, view that act as button, and views for holding other views. And by combining all these views, we make anything.
The other piece of app is the activity, it can be thought as the code behind the layout. It's where you tell what to do.

We can delete any view in design tab of layout by clicking on it and then clicking backspace.
We're putting these views inside another view called constraint layout. Constraint layout lets us position the views inside by using constraints which let us chain views
together and it makes creating a layout super simple.

We have two screens there, the left one is showing us what the app will look like and the right one is more of a blueprint view showing us all the little details behind the app
To change the width of view to full width of its constraint, change layout_width attribute to match constraint
*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//This is where our layout gets connected to our activity.

        val rollButton =
            findViewById<Button>(R.id.rollButton)//This finds our roll button from layout and assigns it to a new variable named rollButton
        //Similarly, same thing is done for resultsTextView and seekBar
        val resultsTextView = findViewById<TextView>(R.id.resultsTextView)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        //Now we have access to each of those views. The next thing we need to do, is make something happen when we click on a button

        rollButton.setOnClickListener {
            //First we'll get a random number based on the value of seek bar and then we'll set that random number as the text of our textview
            var rand = java.util.Random().nextInt(seekBar.progress)+1//1 is added to make range of rand from 1 to 10 instead of from 0 as seekBar value is from 0 to 9 in general.
            //This will give us a random integer from within a certain range(between 0 and the value of our seekBar)
            resultsTextView.text = rand.toString()//Since rand is an integer, we need to turn it into a string before adding it to our text view.
        }
    }
}