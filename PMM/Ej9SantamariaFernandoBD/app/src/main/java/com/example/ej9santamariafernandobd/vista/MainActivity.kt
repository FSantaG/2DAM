package com.example.ej9santamariafernandobd.vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ej9santamariafernandobd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}