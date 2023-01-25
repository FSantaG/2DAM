package com.example.ut7ej7santamariafernando.model

data class Faltas(var codigo:Int?, var alumno:Int, var fecha:String,
             var hora:Int, var profesor:String, var justificada:Int, var observaciones:String="") {
}