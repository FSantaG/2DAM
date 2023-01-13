package com.mjpg.basedatos.vista


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mjpg.basedatos.controlador.PuntosAdaptador
import com.mjpg.basedatos.dao.OperacionesDao
import com.mjpg.basedatos.databinding.ActivityConsultaBinding


class Consulta : AppCompatActivity() {
    private lateinit var binding: ActivityConsultaBinding
    private lateinit var linearLayout: LinearLayoutManager
private lateinit var bd: OperacionesDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConsultaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bd=OperacionesDao(this)
        configurarRecycler()
        binding.btnAlta.setOnClickListener {
            altaPuntosNuevos()
        }
    }

    private fun configurarRecycler() {
        linearLayout = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = linearLayout
        binding.recyclerview.setHasFixedSize(true)
    }


    override fun onResume() {
        super.onResume()
        binding.recyclerview.adapter = PuntosAdaptador(bd.getPuntos2(), this)
    }

    fun altaPuntosNuevos() {

       intent= Intent(this, DatosPuntos::class.java)

        startActivity(intent)



    }




}