package com.example.ut7ej8santamariafernando.view

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ut7ej8santamariafernando.databinding.ActivityMenuOpcionesBinding

class MenuOpcionesActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMenuOpcionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuOpcionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idUsuario = intent.getStringExtra("userId")
        val rolUsuario = intent.getStringExtra("role")

        binding.btnAddEvento.visibility = View.GONE
        binding.btnModificarEventos.visibility=View.GONE
        binding.btnConsultarEventos.visibility=View.GONE

        if (rolUsuario.equals("U")) {
            binding.btnAddEvento.visibility = View.GONE
            binding.btnModificarEventos.visibility=View.GONE
            binding.btnConsultarEventos.visibility=View.VISIBLE
        } else {
            binding.btnAddEvento.visibility = View.VISIBLE
            binding.btnModificarEventos.visibility=View.VISIBLE
            binding.btnConsultarEventos.visibility=View.VISIBLE
        }

        binding.btnConsultarEventos.setOnClickListener {
            val intent = Intent(this, VerEventosActivity::class.java)
            startActivity(intent)
        }

        binding.btnModificarEventos.setOnClickListener{
            val intent = Intent(this, ModificarEventoActivity::class.java)
            startActivity(intent)
        }

        binding.btnAddEvento.setOnClickListener{
            val intent = Intent(this, CrearEventoActivity::class.java)
            startActivity(intent)
        }
    }
}