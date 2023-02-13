package com.example.ej9santamariafernandobd.vistamodelo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class VistaModeloFactory(private val numAfiliado:String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(VistaModelo::class.java)){
            return VistaModelo(numAfiliado)as T
        }
        throw  IllegalArgumentException("Clase Vista-Modelo Desconocida")

    }
}