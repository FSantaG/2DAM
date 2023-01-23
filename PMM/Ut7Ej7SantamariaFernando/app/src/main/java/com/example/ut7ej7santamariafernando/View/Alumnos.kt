package com.example.ut7ej7santamariafernando.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ut7ej7santamariafernando.databinding.ActivityAlumnosBinding
import com.example.ut7ej7santamariafernando.Controller.FaltasAdapter

class Alumnos : AppCompatActivity() {
    private lateinit var binding: ActivityAlumnosBinding
    private lateinit var linearLayout: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlumnosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = FaltasAdapter(listaAlumnos, this);
        linearLayout = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = linearLayout
        binding.recyclerview.setHasFixedSize(true)
    }
}