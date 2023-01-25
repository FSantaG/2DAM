package com.example.ut7ej8santamariafernando.view

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ut7ej8santamariafernando.controller.Eventos
import com.example.ut7ej8santamariafernando.controller.EventosAdapter
import com.example.ut7ej8santamariafernando.databinding.ActivityVerEventosBinding
import com.example.ut7ej8santamariafernando.db.DBQueries
import com.example.ut7ej8santamariafernando.db.MyDBOpenHelper

class VerEventosActivity : AppCompatActivity(), Eventos {
    private lateinit var binding: ActivityVerEventosBinding
    private lateinit var linearLayout: LinearLayoutManager
    private lateinit var bd: DBQueries

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerEventosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bd = DBQueries(this)
        configurarRecycler()
    }

    private fun configurarRecycler() {
        linearLayout = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = linearLayout
        binding.recyclerview.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        binding.recyclerview.adapter = EventosAdapter(bd.getEventos(), this,this)
    }

    override fun pulsacionLarga(cursor: Cursor, posicion: Int): Boolean {
        val codUsuario = intent.getIntExtra("codUsuario",-1)
        var codEvento: String
        cursor.moveToPosition(posicion)
        codEvento=cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_EV_ID))
        val intent = Intent(this, VerDatosEventoActivity::class.java)
        intent.putExtra("codUsuario",codUsuario)
        intent.putExtra("codEvento", codEvento.toInt())
        startActivity(intent)

        return true
    }
}