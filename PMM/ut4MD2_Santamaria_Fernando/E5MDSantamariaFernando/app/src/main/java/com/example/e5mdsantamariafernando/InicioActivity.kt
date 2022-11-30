package com.example.e5mdsantamariafernando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.e5mdsantamariafernando.databinding.ActivityInicioBinding

class InicioActivity : AppCompatActivity() {
    private lateinit var binding:ActivityInicioBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInicioBinding.inflate(layoutInflater);

        super.onCreate(savedInstanceState)
        setContentView(binding.root);

        Glide.with(this)
            .load("https://cdn-icons-png.flaticon.com/512/33/33777.png")
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.imageButton);

        binding.imageButton.setOnClickListener(){
            val intent = Intent(this, RegistroActivity::class.java);
            startActivity(intent);
        }
    }
}