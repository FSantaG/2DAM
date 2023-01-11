package com.example.ut7ej7santamariafernando.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ut7ej7santamariafernando.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}