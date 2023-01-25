package com.example.ut7ej7santamariafernando.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.annotation.RequiresApi
import com.example.ut7ej7santamariafernando.db.DBQueries
import com.example.ut7ej7santamariafernando.model.Faltas
import com.example.ut7ej7santamariafernando.databinding.ActivityCrearFaltaBinding
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class CrearFaltaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCrearFaltaBinding
    private lateinit var bd: DBQueries
    private lateinit var fecha:String
    private lateinit var falta: Faltas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCrearFaltaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertarFecha()

        binding.btnGuardar.setOnClickListener{
            guardar()
        }
    }

    private fun guardar() {
        val codAlumno =binding.txtCodAlumno.text.toString()
        val hora = binding.txtHora.text.toString()
        val observaciones = binding.txtObservaciones.text.toString()
        val codProfesor = intent.getStringExtra("dniProf")

        val fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        val fechaAhora = LocalDate.parse(fechaActual, DateTimeFormatter.ofPattern("d-M-y"))

        if (TextUtils.isEmpty(codAlumno)||TextUtils.isEmpty(hora)||fecha.isEmpty()) {
            Snackbar.make(binding.root, "Rellene todos los campos", Snackbar.LENGTH_SHORT).show()
        } else if (!bd.existeAlumno(codAlumno.toInt())) {
            Snackbar.make(binding.root, "No existe el alumno con ese codigo", Snackbar.LENGTH_SHORT).show()
            binding.txtCodAlumno.setText("")
            binding.txtCodAlumno.requestFocus()
        } else if (hora.toInt() > 6) {
            Snackbar.make(binding.root, "Hora no valida (1-6)", Snackbar.LENGTH_SHORT).show()
        } else if (LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d-M-y"))
                .isAfter(fechaAhora)) {
            Snackbar.make(binding.root, "La fecha es mayor a la actual", Snackbar.LENGTH_SHORT).show()
        } else if (bd.existFalta(codAlumno.toInt(), fecha, hora.toInt())) {
            Snackbar.make(binding.root, "Falta duplicada", Snackbar.LENGTH_SHORT).show()

            if (bd.existFaltaProfesor(codProfesor)) {
                Snackbar.make(binding.root, "Falta puesta por ti", Snackbar.LENGTH_SHORT).show()
                finish()
            }
        } else {
            falta = Faltas(null, codAlumno.toInt(), fecha, hora.toInt(), codProfesor.toString(), 0, observaciones)
            Snackbar.make(binding.root, "Falta puesta correctamente", Snackbar.LENGTH_SHORT).show()
            bd.addFalta(falta)
        }
    }


    private fun insertarFecha() {
        val datePicker = binding.fecha
        val f = Calendar.getInstance()
        datePicker.init(
            f.get(Calendar.YEAR), f.get(Calendar.MONTH),
            f.get(Calendar.DAY_OF_MONTH)

        ) { _, anno, mes, dia ->
            val mes= mes + 1
            fecha = "$dia/$mes/$anno"
        }
    }
}