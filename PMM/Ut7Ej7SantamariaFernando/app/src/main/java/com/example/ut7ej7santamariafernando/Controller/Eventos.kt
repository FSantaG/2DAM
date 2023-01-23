package com.example.ut7ej7santamariafernando.Controller

import com.example.ut7ej7santamariafernando.Model.Alumno

interface Eventos {
    fun pulsacionCorta(alumno: Alumno, posicion:Int)
}