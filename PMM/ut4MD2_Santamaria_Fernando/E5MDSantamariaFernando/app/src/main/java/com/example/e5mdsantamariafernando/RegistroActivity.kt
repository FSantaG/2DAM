package com.example.e5mdsantamariafernando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e5mdsantamariafernando.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegistroBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.btnSearch.setOnClickListener(){
            val intent = Intent(this, InformacionActivity::class.java);
            TODO("usar launch (ver página 120 del libro)");

        }

        binding.btnCancelRequest.setOnClickListener(){
            finish();
        }

        binding.btnCloseApp.setOnClickListener(){
            finishAffinity();
        }
    }
}