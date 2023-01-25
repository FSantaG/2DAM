package com.example.ut7ej7santamariafernando.view

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ut7ej7santamariafernando.controller.Eventos
import com.example.ut7ej7santamariafernando.controller.FaltasAdapter
import com.example.ut7ej7santamariafernando.db.DBQueries
import com.example.ut7ej7santamariafernando.databinding.ActivityRegistroFaltasBinding
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AlertDialog.Builder

class RegistroFaltasActivity : AppCompatActivity(), Eventos {
    private lateinit var binding:ActivityRegistroFaltasBinding
    private lateinit var linearLayout: LinearLayoutManager
    private lateinit var bd: DBQueries
    private lateinit var dniProf:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dniProf = intent.getStringExtra("dniProf").toString()
        bd= DBQueries(this)

        binding = ActivityRegistroFaltasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayout= LinearLayoutManager(this)
        binding.recyclerview.layoutManager = linearLayout
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.adapter = FaltasAdapter(bd.getFalta(dniProf), this)

        binding.btnCrearRegistro.setOnClickListener{
            val intent = Intent(this, CrearFaltaActivity::class.java)
            intent.putExtra("dniProf", dniProf)
            startActivity(intent)
        }
    }

    override fun pulsacionCorta(cursor: Cursor, posicion: Int) {
        modificarEstado(posicion)
    }

    fun modificarEstado(posicion:Int){
        val builder = Builder(this@RegistroFaltasActivity)
        builder.setTitle("¡Alerta!")
        builder.setMessage(
            "Va a modificar el estado de la falta de un alumno. ¿Está usted seguro?"
        )

        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            bd.justificarFalta(posicion+1)
            Snackbar.make(binding.root,"Se ha justificado la falta correctamente",Snackbar.LENGTH_SHORT).show()
            startActivity(getIntent())
        }
        builder.setNeutralButton(android.R.string.cancel, null)
        builder.show()
    }
}