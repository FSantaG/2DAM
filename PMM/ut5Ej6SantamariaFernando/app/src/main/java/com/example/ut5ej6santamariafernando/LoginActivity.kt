package com.example.ut5ej6santamariafernando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ut5ej6santamariafernando.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    private val listaUsuarios = listOf<Usuario>(
        Usuario("fsantag", "1234", 0),
        Usuario("plopezg", "1234", 1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInicioSesion.setOnClickListener{
            val nombre = binding.txtUsuario.text.toString()
            val clave = binding.txtClave.text.toString()
            val usuarioMecanicoPosible = listaUsuarios.indexOf(Usuario(nombre, clave, 0))
            val usuarioRecepcionistaPosible = listaUsuarios.indexOf(Usuario(nombre, clave, 1));

            if(usuarioMecanicoPosible != -1){
                createIntent(usuarioMecanicoPosible)
            }else if(usuarioRecepcionistaPosible != -1){
                createIntent(usuarioRecepcionistaPosible)
            }else{
                Snackbar.make(binding.view, "Usuario y Contraseña no Coincidentes",
                    Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun createIntent(usuario: Int) {
        val intent = Intent(this, GarajeActivity::class.java)
        val usuarioSolicitado = listaUsuarios.get(usuario)
        intent.putExtra("usuarioIniciado", usuarioSolicitado)
        startActivity(intent)
    }
}