package com.example.ut5ej6santamariafernando

interface Eventos {
    fun pulsacionCorta(coche:Coche, posicion:Int)

    fun pulsacionLarga(posicion:Int):Boolean
}