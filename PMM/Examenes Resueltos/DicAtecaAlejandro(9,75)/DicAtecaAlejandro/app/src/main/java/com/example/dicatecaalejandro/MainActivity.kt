package com.example.dicatecaalejandro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicatecaalejandro.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val usuarios = listOf(
        Usuario("admin", "123", 1),
        Usuario("pepe", "456", 0),
        Usuario("jose", "789", 0),
        Usuario("mario", "159", 0),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnValidar.setOnClickListener {
            validar()
        }
        binding.btnCancelar.setOnClickListener {
            cancelar()
        }
    }

    private fun validar(){
        val user = binding.edtUser.text.toString()
        val pass = binding.edtPass.text.toString()
        val usuario = usuarios.indexOf(Usuario(user, pass))

        if(usuario != -1){
            val tipo = usuarios[usuario].tipo
            llamada(tipo)
        }else{
            Snackbar.make(
                binding.root,
                "El usuario introducido no existe",
                Snackbar.LENGTH_SHORT
            )
                .setAnchorView(binding.btnValidar).show()
        }
    }


    private fun cancelar(){
        binding.edtUser.setText("")
        binding.edtPass.setText("")
    }

    private fun llamada(tipo: Int) {
        val intent = Intent(this, Casos::class.java)
        intent.putExtra("tipo", tipo)
        startActivity(intent)
        finish()
    }


}