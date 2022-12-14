package com.example.ut5ej6santamariafernando

data class Coche (var dni:String, var nombre:String, var apellidos:String, var email:String,
                  var Matricula:String, var modeloCoche:String, var fechaEntrega:String, var observaciones:String, var estado:Boolean){
    public fun obtenerNombreCompleto():String{
        return nombre + " " + apellidos;
    }
}