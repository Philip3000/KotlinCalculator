package com.example.kotlincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlincalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)


        binding.resultButton.setOnClickListener {

            val number1Double = binding.number1.text.trim().toString()
            val number2Double = binding.number2.text.trim().toString()
            if (number1Double.isBlank() || number1Double == ".") {
                binding.number1.error = "Skriv et tal"
            }
            if (number2Double.isBlank() || number2Double == ".") {
                binding.number2.error = "Skriv et tal"
            }
            val number1 = number1Double.toDoubleOrNull()?: 0.0
            val number2 = number2Double.toDoubleOrNull()?: 0.0
            val operation = binding.spinner.selectedItem
            val numberResult = when (operation) {
                "+" -> number1 + number2
                "-" -> number1 - number2
                "/" -> number1 / number2
                "*" -> number1 * number2
                else -> Double.NaN
            }
            //val numberResult = number1 + number2
            binding.result.text = numberResult.toString()
        }
    }
}