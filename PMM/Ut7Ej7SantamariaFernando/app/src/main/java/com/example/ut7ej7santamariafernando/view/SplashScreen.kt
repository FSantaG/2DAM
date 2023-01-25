package com.example.ut7ej7santamariafernando.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ut7ej7santamariafernando.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    /**
     * El programa explota si se trabaj desde otros ordenadores (no sé si es culpa de Github o qué)
     * Si eso sucediese, hacer un clean y un rebuild (En el caso de que el error obtenido sea "No virtual method getProfesor()I)
     */

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