package com.example.ut7ej8santamariafernando.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.ut7ej8santamariafernando.DB.DBQueries
import com.example.ut7ej8santamariafernando.DB.MyDBOpenHelper
import com.example.ut7ej8santamariafernando.R
import com.example.ut7ej8santamariafernando.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var bd: DBQueries


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_splash_screen)

        bd = DBQueries(this)
        if(bd.checkEmptyTable(MyDBOpenHelper.TABLA_USUARIO)){
            addUsers()
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    fun addUsers(){
        val usuarios = resources.getStringArray(R.array.usuarios)
        for(usuario in usuarios){
            val datosUsuario = usuario.split("*")

            Thread {
                bd.addUsuario(datosUsuario)
            }.start()
        }
    }
}