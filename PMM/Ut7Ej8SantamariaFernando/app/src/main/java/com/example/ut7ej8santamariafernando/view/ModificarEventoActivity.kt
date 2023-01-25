package com.example.ut7ej8santamariafernando.view

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ut7ej8santamariafernando.databinding.ActivityModificarEventoBinding
import com.example.ut7ej8santamariafernando.db.DBQueries
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class ModificarEventoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityModificarEventoBinding
    private lateinit var bd: DBQueries
    private var fecha: String = ""
    private var hora: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityModificarEventoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = DBQueries(this)

        seleccionarFecha()
        dialogoHora()

        binding.btnAceptar.setOnClickListener {
            actualizarEvento()
        }
        binding.btnCancelar.setOnClickListener {
            finish()
        }
    }

    private fun actualizarEvento() {

        val titulo = binding.txtNombre.text.toString().trim()

        val formato = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val fechaActual = LocalDate.now().format(formato)
        val fechaAhora = LocalDate.parse(fechaActual, DateTimeFormatter.ofPattern("d-M-y"))

        if (fecha.isEmpty() || hora.isEmpty() || titulo.isEmpty()) {
            Snackbar.make(binding.root, "No deje campos vacíos (Revise bien que haya introducido la fecha y la hora)", Snackbar.LENGTH_SHORT)
                .show()
        } else if (LocalDate.parse(fecha, DateTimeFormatter.ofPattern("d-M-y")).isBefore(fechaAhora)) {
            Snackbar.make(binding.root, "La fecha introducida se encuentra en el pasado", Snackbar.LENGTH_SHORT).show()
        } else if (bd.existEvento(fecha, hora)) {
            Snackbar.make(binding.root, "Ya existe un evento en el día y hora introducidos. Por favor, busque otra", Snackbar.LENGTH_SHORT)
                .show()
        } else {
            bd.updateEvento(titulo, fecha, hora)
            Toast.makeText(this, "Evento Actualizado", Toast.LENGTH_SHORT).show()
            finish()
        }
    }


    private fun seleccionarFecha() {
        val datePicker = binding.DatePicker
        val f = Calendar.getInstance()
        datePicker.init(
            f.get(Calendar.YEAR), f.get(Calendar.MONTH),
            f.get(Calendar.DAY_OF_MONTH)

        ) { _, anno, mes, dia ->
            val mes = mes + 1
            fecha = "$dia-$mes-$anno"
        }
    }


    private fun dialogoHora() {
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