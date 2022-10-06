package com.example.ej31

fun main(){
    //Ejercicio 1
    println("Ejercicio 1");
    var veh1 = Vehiculo();
    veh1.marca = "Seat";
    veh1.modelo = "Panda";
    veh1.color = "Amarillo";

    var veh2 = Vehiculo();
    veh2.marca = "Renault";
    veh2.modelo = "Captur";
    veh2.color = "Marrón";

    var veh3 = Vehiculo();
    veh3.marca = "Opel";
    veh3.modelo = "Corsa";
    veh3.color = "Azúl";
    var listaVehiculos = listOf(veh1, veh2, veh3);

    for(item in listaVehiculos){
        println(item.marca + ", " + item.modelo + ", " + item.color);
    }

    //Ejercicio 2
    println("\nEjercicio 2");
    var veh11 = Vehiculo2("Mercedes", "Iq", "Blanco");
    var veh12 = Vehiculo2("Honda", "Civic", "Amarillo");
    var veh13 = Vehiculo2("Renault", "Clio", "Verde");
    var listaVehiculos2 = listOf(veh11, veh12, veh13);

    for(item in listaVehiculos2){
        println(item.marca + ", " + item.modelo + ", " + item.color);
    }

    //Ejercicio 3
    println("\nEjercicio 3");
    var veh111 = Coche("Citröen", "C4", "Negro", 5, 7);
    var veh112 = Coche("Toyota", "Corolla", "Marrón", 5, 5);
    var veh113 = Motocicleta("Suzuki", "GSX-S125", "Negro", 2, true);
    var veh114 = Motocicleta("Yamaha", "mt-07", "Blanco",1, false);
    var listaVehiculos3 = listOf(veh111, veh112, veh113, veh114);

    for(item in listaVehiculos3){
        item.mostrarDatos();
        println();
    }
}