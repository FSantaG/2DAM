package com.example.e1mdsantamariafernando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e1mdsantamariafernando.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWelcomeBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityWelcomeBinding.inflate(layoutInflater);
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.welcomeText.text = getString(R.string.welcome) + intent.getStringExtra("username");

        binding.backToMenu.setOnClickListener(){
            var intent = Intent(this, MainActivity::class.java);

            startActivity(intent);
            finish()
        }
    }
}