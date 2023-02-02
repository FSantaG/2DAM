package com.example.ut7ej7santamariafernando.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ut7ej7santamariafernando.db.DBQueries
import com.example.ut7ej7santamariafernando.model.AluProf
import com.example.ut7ej7santamariafernando.model.Alumno
import com.example.ut7ej7santamariafernando.model.Faltas
import com.example.ut7ej7santamariafernando.model.Profesor
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
                    val intent = Intent(this, RegistroFaltasActivity::class.java)
                    intent.putExtra("dniProf", profesor.dni)
                    startActivity(intent)
                }
            }
    }

    private fun altaAlumnos() {
        val alumnoPrueba1 = Alumno(
            null,"José"
        )
        val alumnoPrueba2 = Alumno(
            null, "María"
        )
        Thread {
            bd.addAlumno(alumnoPrueba1)
            bd.addAlumno(alumnoPrueba2)
        }.start()
    }

    private fun altaProfesores() {
        val profPrueba1 = Profesor(
            "12345678A", "plopezg", "123", "Pedro López"
        )
        val profPrueba2 = Profesor(
            "12345678Z", "ljimenezr", "123", "Laura Jimenez Ruiz"
        )

        Thread {
            bd.addProfesor(profPrueba1)
            bd.addProfesor(profPrueba2)

        }.start()
    }

    private fun altaAluProf() {
        val aluProfPrueba = AluProf(
        null, 1, "12345678A"
        )
        Thread {
            bd.addAluProf(aluProfPrueba)
        }.start()
    }
}