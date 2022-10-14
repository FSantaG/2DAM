package com.example.ej31

class Motocicleta(marca:String, modelo:String, color:String, val numPlazas:Int, val tieneMaletero:Boolean):Vehiculo3(marca, modelo, color) {
    override fun mostrarDatos(){
        super.mostrarDatos();
        print(", $numPlazas plazas, ");
        if(tieneMaletero){
            print("Tiene maletero\n");
        }else{
            print("No tiene maletero\n");
        }
    }
}