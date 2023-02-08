package com.example.ej9santamariafernandobd.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ej9santamariafernandobd.R
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper
import com.example.ej9santamariafernandobd.databinding.ActivitySplashScreenBinding
import com.example.ej9santamariafernandobd.modelo.DBQueries

class SplashScreen : AppCompatActivity() {
    private lateinit var binding:ActivitySplashScreenBinding
    private lateinit var bd: DBQueries
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = DBQueries(this)
        if(bd.checkEmptyTable(MyDBOpenHelper.TABLA_TIPOS)){
            addTypes()
        }
        if(bd.checkEmptyTable(MyDBOpenHelper.TABLA_PROFESIONALES)){
            addPros()
        }


        loadImage("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Sacyl.svg/1200px-Sacyl.svg.png")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)


    }

    fun addTypes(){
        val tipos = resources.getStringArray(R.array.tipos)
        for(tipo in tipos){
            Thread {
                bd.addTipo(tipo)
            }.start()
        }
    }

    fun addPros(){
        val profesionales = resources.getStringArray(R.array.profesionales)
        for(profesional in profesionales){
            val datosProfesional = profesional.split("*")
            Thread {
                bd.addProfesional(datosProfesional)
            }.start()
        }
    }

    private fun loadImage(url:String){
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.corpImage)
    }
}