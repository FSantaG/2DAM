package com.example.ej31

class Coche(marca:String, modelo:String, color:String, val numPuertas:Int, val numPlazas:Int):Vehiculo3(marca, modelo, color) {
    override fun mostrarDatos(){
        super.mostrarDatos();
        print(", $numPuertas puertas, $numPlazas plazas");
    }
}