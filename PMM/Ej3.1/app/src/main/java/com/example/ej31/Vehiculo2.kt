package com.example.ej31
//3.1.2 Añadir constructor primario (init)
class Vehiculo2(marca:String, modelo:String, color:String) {
    var marca:String;
    var modelo:String;
    var color:String;

    init{
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }
}