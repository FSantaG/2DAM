package com.example.ut7ej8santamariafernando.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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