package com.example.santamariafernando.vistamodelo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class VistaModeloFactory(private val numCategoria:Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(VistaModelo::class.java)){
            return VistaModelo(numCategoria)as T
        }
        throw  IllegalArgumentException("Clase Vista-Modelo Desconocida")

    }
}