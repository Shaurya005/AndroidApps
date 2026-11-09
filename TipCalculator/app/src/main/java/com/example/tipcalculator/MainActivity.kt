package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Returns the outermost View in the associated layout file. If this binding is for a <merge> layout, this will return the first view inside of the merge tag.
        binding.calculateButton.setOnClickListener{ calculateTip() }
    }
    private fun calculateTip() {
        // Get the decimal value from the cost of service text field
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        //val cost = stringInTextField.toDouble()
        val cost = stringInTextField.toDoubleOrNull()
        /*
        public fun String.toDoubleOrNull(): Double?
        Parses the string as a Double number and returns the result or null if the string is not a valid representation of a number.
        */
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            /*
            public int getCheckedRadioButtonId()
            Returns the identifier of the selected radio button in this group. Upon empty selection, the returned value is -1.
            Returns: the unique id of the selected radio button in this group
            */
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        //val roundUp = binding.roundUpSwitch.isChecked
        //if (roundUp) {
        if(binding.roundUpSwitch.isChecked){
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        /*
        java.text.NumberFormat public static final NumberFormat getCurrencyInstance()
        Returns a currency format for the current default FORMAT locale.
         */
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}