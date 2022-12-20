package com.example.ut5ej6santamariafernando

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ut5ej6santamariafernando.databinding.ActivityAgregarCocheBinding
import com.google.android.material.snackbar.Snackbar

class AgregarCocheActivity : AppCompatActivity() {
    private lateinit var  binding:ActivityAgregarCocheBinding
    private lateinit var listaCoches:MutableList<Coche>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAgregarCocheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var listaCochesPrevia = intent.getParcelableExtra<Lista>("listaCoches")
        listaCoches = listaCochesPrevia?.listaVehiculos!!

        binding.btnGuardar.setOnClickListener {
            if(!checkNulls()){

            }else{

            }
        }
    }

    public fun checkNulls():Boolean{
        var flag = false;
        //TODO: Añadir el if masivo de chequeo de variables
        return flag
    }
}