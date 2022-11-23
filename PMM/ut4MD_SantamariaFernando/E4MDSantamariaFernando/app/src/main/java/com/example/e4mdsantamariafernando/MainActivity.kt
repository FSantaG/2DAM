package com.example.e4mdsantamariafernando

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e4mdsantamariafernando.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private val words = listOf<String>("FREEZE", "MINION", "WAVE", "TOWER");

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater);

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        generateWord();

        binding.btnA.setOnClickListener(){
            generateWord(); //debug cosa
        }
    }

    public fun generateWord(){
        var selectedWord = words[Random.nextInt(words.size)];

    }
}