package com.example.santamariafernando.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.santamariafernando.databinding.ActivityLoginBinding
import com.example.santamariafernando.modelo.DBQueries
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var bd: DBQueries

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bd = DBQueries(this)
        binding.btnInicioSesion.setOnClickListener {
            comprobar()
        }

        binding.btnInvitado.setOnClickListener {
            openMainActivity(0)
        }
    }

    private fun comprobar() {
        val loginIntroducido = binding.txtUsuario.text.toString()
        val contrasenaIntroducida = binding.txtClave.text.toString()
        if (loginIntroducido == "" || contrasenaIntroducida == "") {
            Snackbar.make(
                binding.root, "No deje campos vacíos, por favor",
                Snackbar.LENGTH_SHORT
            ).show()
        } else {
            val usuario = bd.getUsuario(loginIntroducido, contrasenaIntroducida)
            if (usuario == false) {
                Snackbar.make(
                    binding.root, "Usuario no encontrado. Compruebe los datos y vuelva a intentarlo",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                openMainActivity(1)
            }
        }
    }

    private fun openMainActivity(validador:Int) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("validador", validador)
        startActivity(intent)
    }
}