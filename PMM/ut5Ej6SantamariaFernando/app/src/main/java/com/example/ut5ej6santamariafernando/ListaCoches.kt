package com.example.ut5ej6santamariafernando

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class ListaCoches(var lista:ArrayList<Coche>) : Parcelable {
}