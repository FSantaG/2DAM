package com.example.ut7ej8santamariafernando.view

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ut7ej8santamariafernando.databinding.ActivityCrearEventoBinding
import com.example.ut7ej8santamariafernando.db.DBQueries
import com.example.ut7ej8santamariafernando.model.Evento
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class CrearEventoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCrearEventoBinding
    private lateinit var bd: DBQueries

    private var fecha: String = ""
    private var hora: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bd = DBQueries(this)
        binding = ActivityCrearEventoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gestionFecha()
        gestionHora()

        binding.btnAceptar.setOnClickListener {
            guardarEvento()
        }
        binding.btnCancelar.setOnClickListener {
            finish()
        }

    }

    private fun guardarEvento() {

        val formato = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val fechaActual = LocalDate.now().format(formato)
        val fechaAhora = LocalDate.parse(fechaActual, DateTimeFormatter.ofPattern("d-M-y"))


        val titulo = binding.txtNombre.text.toString().trim()
        val descripcion = binding.txtDescripcion.text.toString().trim()

        if (fecha.isEmpty() || hora.isEmpty() || titulo.isEmpty() || descripcion.isEmpty()) {
            Snackbar.make(binding.root,
                "No deje campos vacíos, por favor",
                Snackbar.LENGTH_SHORT)
                .show()
        } else if (bd.existEvento(fecha, hora)) {
            Snackbar.make(binding.root,
                "Ya existe un evento conertado para la selección fecha/hora seleccionados",
                Snackbar.LENGTH_SHORT)
                .show()
        } else if (LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d-M-y")).isBefore(fechaAhora)) {
            Snackbar.make(binding.root,
                "La fecha seleccionada se ubica en el pasado.",
                Snackbar.LENGTH_SHORT)
                .show()
        } else {
            val eventoNuevo = Evento(null, fecha, hora, titulo, descripcion)
            bd.addEvento(eventoNuevo)

            Toast.makeText(this,
                "Evento creado satisfactoriamente",
                Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun gestionFecha() {
        val datePicker = binding.DatePicker

        val f = Calendar.getInstance()
        datePicker.init(
            f.get(Calendar.YEAR), f.get(Calendar.MONTH),
            f.get(Calendar.DAY_OF_MONTH)

        ) { _, anno, mes, dia ->
            val mes = mes + 1
            fecha = "$dia-0$mes-$anno"
        }
    }

    private fun gestionHora() {
        binding.btnHora.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                hora = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
    }

}