package com.example.ut7ej8santamariafernando.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ut7ej8santamariafernando.DB.DBQueries
import com.example.ut7ej8santamariafernando.databinding.ActivityLoginBinding
import com.example.ut7ej8santamariafernando.databinding.ActivitySplashScreenBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    private lateinit var bd: DBQueries

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = DBQueries(this)

        binding.btnInicioSesion.setOnClickListener {
            comprobar()
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
            val usuarioLogueado = bd.getUsuario(loginIntroducido, contrasenaIntroducida)
            if (usuarioLogueado == null) {
                Snackbar.make(
                    binding.root, "Usuario no encontrado. Compruebe los datos y vuelva a intentarlo",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, MenuOpcionesActivity::class.java)
                intent.putExtra("userId", usuarioLogueado.id)
                intent.putExtra("Role", usuarioLogueado.perfil)
                startActivity(intent)
            }
        }
    }
}