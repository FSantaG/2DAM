package com.example.ut7ej7santamariafernando.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ut7ej7santamariafernando.DB_Ops.DBQueries
import com.example.ut7ej7santamariafernando.MyDBOpenHelper
import com.example.ut7ej7santamariafernando.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var bd:DBQueries

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        bd = DBQueries(this)
        if(bd.checkEmptyTable(MyDBOpenHelper.TABLA_ALUMNOS)){
            altaAlumnos()
        }
        if(bd.checkEmptyTable(MyDBOpenHelper.TABLA_PROFESOR)){
            altaProfesores()
        }
        if(bd.checkEmptyTable(MyDBOpenHelper.TABLA_FALTAS)){
            altaFaltas()
        }
        if(bd.checkEmptyTable(MyDBOpenHelper.TABLA_ALUPROF)){
            altaAluProf()
        }

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
                val profesor = bd.getProfesor(loginIntroducido, contrasenaIntroducida)
                if (profesor == null) {
                    Snackbar.make(
                        binding.root, "Usuario no encontrado. Compruebe los datos y vuelva a intentarlo",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    Snackbar.make(
                        binding.root, "Usuario encontrado. Esto funciona",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    //val intent = Intent(this, Consulta::class.java)
                    //startActivity(intent)
                }
            }
    }

    private fun altaAlumnos() {

    }

    private fun altaProfesores() {

    }

    private fun altaFaltas() {

    }

    private fun altaAluProf() {

    }
}