package com.example.ut5ej6santamariafernando

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario(val nombreUsuario:String, val clave:String, val rol:Int = 0):Parcelable{

}
