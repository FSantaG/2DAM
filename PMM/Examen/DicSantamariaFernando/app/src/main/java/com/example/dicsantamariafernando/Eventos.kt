package com.example.dicsantamariafernando

interface Eventos {
    fun pulsacionCorta(caso:Caso, posicion:Int)

    fun pulsacionLarga(posicion:Int):Boolean
}