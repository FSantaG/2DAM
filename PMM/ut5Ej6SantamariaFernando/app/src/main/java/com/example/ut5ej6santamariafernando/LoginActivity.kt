package com.example.ut5ej6santamariafernando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ut5ej6santamariafernando.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    private val listaUsuarios = listOf<Usuario>(
        Usuario("fsantag", "1234"),
        Usuario("plopezp", "1234", 1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInicioSesion.setOnClickListener{
            val nombre = binding.txtUsuario.text.toString()
            val clave = binding.txtClave.text.toString()
            val usuario = listaUsuarios.indexOf(Usuario(nombre, clave))

            if(usuario != -1){
                val intent = Intent(this, GarajeActivity::class.java)
                intent.putExtra("usuarioIniciado", usuario)
                startActivity(intent)
            }else{
                Snackbar.make(binding.view, "Usuario y Contraseña no Coincidentes",
                    Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}