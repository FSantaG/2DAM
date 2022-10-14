package com.example.ej31
//3.1.3 Añadir posibilidad de herencia
open class Vehiculo3(val marca:String, val modelo:String, val color:String) {
    open fun mostrarDatos(){
        print("$marca, $modelo, $color");
    }
}