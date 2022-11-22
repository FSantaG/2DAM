package com.mjpg.usuarios

data class Usuario(val id:Long, var nombre:String, var apellidos:String, var ruta:String){
    fun giveFullName() = "$nombre $apellidos"; //Cuando sólo tiene un return, puede hacerse de esta manera
}