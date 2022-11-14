package com.example.pruebas

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
/**
 * Cómo mandar una clase a una activity nueva
 * Se escribe data class
 * @Parcelize arriba
 * Introducir entre paréntesis los parámetros de la clase
 * Dentro de la actividad padre: intent.putExtra
 */
data class Usuario(var nombre:String, var edad:Int):Parcelable {

}