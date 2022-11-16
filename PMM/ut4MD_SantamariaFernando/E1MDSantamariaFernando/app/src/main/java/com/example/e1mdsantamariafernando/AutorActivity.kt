package com.example.e1mdsantamariafernando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e1mdsantamariafernando.databinding.ActivityAutorBinding

class AutorActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAutorBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutorBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.btnBack.setOnClickListener(){
            finish();
        }
    }
}