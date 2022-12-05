package com.example.dicsantamariafernando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dicsantamariafernando.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    private val usuarios = listOf<Usuarios>(
        Usuarios("fsantag", "1234", 0),
        Usuarios("mperezg", "1234", 1),
        Usuarios("mjpg", "1234", 0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val user = binding.txtUser.text.toString()
            val pass = binding.txtPass.text.toString()
            var rol = 1
            var datosCorrectos = false
            for (usuario in usuarios) {
                if(usuario.login == user){
                    if(usuario.contraseña == pass){
                        datosCorrectos = true
                        rol = usuario.tipoUsuario
                        break
                    }
                }
            }

            if(datosCorrectos){
                val intent = Intent(this, CasosActivity::class.java)
                intent.putExtra("rol", rol)
                startActivity(intent)
            }else{
                Toast.makeText(this, R.string.userNotCorrect,
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}