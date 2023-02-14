package com.example.santamariafernando.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.santamariafernando.R
import com.example.santamariafernando.databinding.ActivitySplashScreenBinding
import com.example.santamariafernando.modelo.Categoria
import com.example.santamariafernando.modelo.DBQueries
import com.example.santamariafernando.modelo.MyDBOpenHelper
import com.example.santamariafernando.modelo.Producto

class SplashScreen : AppCompatActivity() {
    private lateinit var binding:ActivitySplashScreenBinding
    private lateinit var bd:DBQueries

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = DBQueries(this)
        if(bd.checkEmptyTable(MyDBOpenHelper.TABLA_CATEGORIAS)){
            addCategorias()
        }
        if(bd.checkEmptyTable(MyDBOpenHelper.TABLA_PRODUCTOS)){
            addProductos()
        }
        if(bd.checkEmptyTable(MyDBOpenHelper.TABLA_USUARIOS)){
            addUsuarios()
        }

        loadImage("https://santamaria-artesano.es/images/logo2.png")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }

    private fun loadImage(url:String){
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.corpImage)
    }

    fun addCategorias(){
        val categorias = resources.getStringArray(R.array.categorias)
        for(categoria in categorias){
            val datosCategoria = categoria.split("*")
            Thread {
                bd.addCategoria(datosCategoria)
            }.start()
        }
    }

    fun addProductos(){
        val productos = resources.getStringArray(R.array.productos)
        for(producto in productos){
            val producto = producto.split("*")
            Thread {
                bd.addProducto(producto)
            }.start()
        }
    }

    fun addUsuarios(){
        val usuarios = resources.getStringArray(R.array.usuarios)
        for(usuario in usuarios){
            val datosUsuario = usuario.split("*")
            Thread {
                bd.addUsuario(datosUsuario)
            }.start()
        }
    }
}