package com.example.santamariafernando.vistamodelo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VistaModelo(  numCategoria:Int): ViewModel() {
    var _identificador= MutableLiveData(numCategoria)
    val identificador: LiveData<Int>
        get()=_identificador
    init{
        _identificador= MutableLiveData(0)
    }


    fun setIdentificador(numCategoria:Int ) {
        _identificador.value=numCategoria
    }
}