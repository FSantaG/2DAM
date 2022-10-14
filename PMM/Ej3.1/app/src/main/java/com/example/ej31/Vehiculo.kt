package com.example.ej31
//3.1.1 Clase Vehículo sin contructores
class Vehiculo {
    var marca:String = ""
        set(value){
            field = if(value.isEmpty()) "Empty" else value;
        }
        get(){
            return field;
        }

    var modelo:String = ""
        set(value){
            field = if(value.isEmpty()) "Empty" else value;
        }
        get(){
            return field;
        }

    var color:String = ""
        set(value){
            field = if(value.isEmpty()) "Empty" else value;
        }
        get(){
            return field;
        }
}