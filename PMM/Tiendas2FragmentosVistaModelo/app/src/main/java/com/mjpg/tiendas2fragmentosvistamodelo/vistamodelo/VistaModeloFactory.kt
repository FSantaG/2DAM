package com.mjpg.tiendas2fragmentosvistamodelo.vistamodelo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class VistaModeloFactory(private val id:Long):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(VistaModelo::class.java)){
           return VistaModelo(id)as T
       }
        throw  IllegalArgumentException(" Clase view model desconocida")

    }
}