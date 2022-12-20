package com.example.ut5ej6santamariafernando

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coche (var dni:String, var nombre:String, var apellidos:String, var email:String,
                  var matricula:String, var modeloCoche:String, var fechaEntrega:String, var observaciones:String, var estado:Boolean) :
    Parcelable {
    public fun obtenerNombreCompleto():String{
        return nombre + " " + apellidos;
    }
}