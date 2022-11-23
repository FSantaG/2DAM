package com.mjpg.usuarios

interface Eventos {
    fun pulsacionCorta(usuario:Usuario, posicion:Int)

    fun pulsacionLarga(posicion:Int):Boolean
}