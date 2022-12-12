package com.example.dicatecaalejandro

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Cliente(var dni: String, var nombre: String = "", var telf: String = "", var correo: String = "") : Parcelable {
        override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cliente

        if (dni != other.dni) return false

        return true
    }

    override fun hashCode(): Int {
        return dni.hashCode()
    }



}