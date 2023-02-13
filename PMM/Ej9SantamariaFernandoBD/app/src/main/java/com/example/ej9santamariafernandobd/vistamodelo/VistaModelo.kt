package com.example.ej9santamariafernandobd.vistamodelo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VistaModelo(  numAfiliado:String): ViewModel() {
    var _identificador= MutableLiveData(numAfiliado)
    val identificador: LiveData<String>
        get()=_identificador
    init{
        _identificador= MutableLiveData("")
    }


    fun setIdentificador(numAfiliado:String ) {
        _identificador.value=numAfiliado
    }

}