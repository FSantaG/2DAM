package com.example.ut7ej7santamariafernando.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ut7ej7santamariafernando.DB_Ops.DBQueries
import com.example.ut7ej7santamariafernando.MyDBOpenHelper
import com.example.ut7ej7santamariafernando.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setCorpImage("https://santamaria-artesano.es/images/logo2.png")


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    private fun setCorpImage(url:String) {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.logo)
    }
}