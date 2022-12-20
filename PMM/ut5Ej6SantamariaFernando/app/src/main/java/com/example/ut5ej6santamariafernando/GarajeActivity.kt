package com.example.ut5ej6santamariafernando

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ut5ej6santamariafernando.databinding.ActivityGarajeBinding

class GarajeActivity : AppCompatActivity(), Eventos {

    private lateinit var binding:ActivityGarajeBinding
    private lateinit var linearLayout:LinearLayoutManager
    private var listaCoches = mutableListOf<Coche>(
        Coche("12345678X", "Manolo", "Pérez", "prueba@prueba.com", "1234XDD",
        "Seat Ibiza", "19/12/2022", "Coche de prueba", true),
        Coche("87654321X", "Pedro", "Gómez", "prueba@prueba.com", "1234XDD",
            "Seat León", "19/12/2022", "Coche de prueba", false),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGarajeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = GarageAdapter(listaCoches, this);
        linearLayout = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = linearLayout
        binding.recyclerview.setHasFixedSize(true)

        val loggedUsuario = intent.getParcelableExtra<Usuario>("usuarioIniciado")
        if(loggedUsuario?.rol == 1){
            binding.btnCrearRegistro.visibility = View.VISIBLE
        }else{
            binding.btnCrearRegistro.visibility = View.INVISIBLE
        }

        binding.btnCrearRegistro.setOnClickListener {
            val intent = Intent(this, AgregarCocheActivity::class.java)
            val listaCochesForResult = Lista(listaCoches)
            intent.putExtra("listaCoches", listaCochesForResult)
            resultActivity.launch(intent)
        }
    }

    val resultActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        val data: Intent? = result.data
        if(result.resultCode == Activity.RESULT_OK) {

        }
    }

    override fun pulsacionCorta(coche: Coche, posicion: Int) {
        TODO("Not yet implemented")
    }

    override fun pulsacionLarga(posicion: Int): Boolean {
        TODO("Not yet implemented")
    }
}