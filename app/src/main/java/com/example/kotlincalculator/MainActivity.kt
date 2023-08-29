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

            val number1Int = binding.number1.text.trim().toString()
            val number2Int = binding.number2.text.trim().toString()
            if (number1Int.isBlank()) {
                binding.number1.error = "Skriv et tal"
            }
            if (number2Int.isBlank()) {
                binding.number2.error = "Skriv et tal"
            }
            val number1 = number1Int.toIntOrNull()?: 0
            val number2 = number2Int.toIntOrNull()?: 0
            val numberResult = number1 + number2
            binding.result.text = numberResult.toString()
        }
    }
}