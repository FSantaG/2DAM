package com.example.ut7ej8santamariafernando.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ut7ej8santamariafernando.databinding.ActivityVerDatosEventoBinding
import com.example.ut7ej8santamariafernando.databinding.ActivityVerEventosBinding
import com.example.ut7ej8santamariafernando.db.DBQueries
import com.google.android.material.snackbar.Snackbar

class VerDatosEventoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerDatosEventoBinding
    private lateinit var bd: DBQueries

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVerDatosEventoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = DBQueries(this)

        val codUsuario = intent.getIntExtra("codUsuario", -1)
        val codEvento = intent.getIntExtra("codEvento", -1)

        val eventoSeleccionado = bd.obtenerEventoSeleccionado(codEvento)

        binding.nombre.text = eventoSeleccionado!!.titulo
        binding.descripcion.text = eventoSeleccionado!!.descripcion
        binding.fecha.text = eventoSeleccionado!!.fecha
        binding.hora.text = eventoSeleccionado!!.hora


        binding.btnApuntar.setOnClickListener { apuntarseEvento(codUsuario, codEvento) }
        binding.btnAnular.setOnClickListener { desapuntarseEvento(codUsuario, codEvento) }
    }



    private fun apuntarseEvento(codUsuario: Int, codEvento: Int) {
        if (!bd.existsEventoUsuario(codUsuario, codEvento)) {
            bd.addEventoUsuario(codUsuario, codEvento)
            Snackbar.make(binding.root, "Se ha apuntado correctamente al evento", Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(binding.root, "No se ha podido apuntar porque ya estaba apuntado de antes", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun desapuntarseEvento(codUsuario: Int, codEvento: Int) {
        if (!bd.existsEventoUsuario(codUsuario, codEvento)) {
            Snackbar.make(binding.root, "No estaba apuntado a este evento", Snackbar.LENGTH_SHORT).show()
        } else {
            bd.removeEventoUsuario(codUsuario, codEvento)
            Snackbar.make(binding.root, "Ha cancelado su asistencia satisfactoriamente", Snackbar.LENGTH_SHORT).show()
        }
    }
}