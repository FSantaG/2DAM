package com.example.dicsantamariafernando

data class Caso(
    val codigo:String, val denominacion:String, val fechaApertura:String, val observaciones:String,
    val dniCliente:String, var estado:Boolean
) {
}