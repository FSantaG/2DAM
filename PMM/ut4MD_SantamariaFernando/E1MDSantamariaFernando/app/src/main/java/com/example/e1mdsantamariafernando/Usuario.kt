package com.example.e1mdsantamariafernando

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Usuario(var nomUsuario:String, var pass:String, var nombre:String):Parcelable {

}