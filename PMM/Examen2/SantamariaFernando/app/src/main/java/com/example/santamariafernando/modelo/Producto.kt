package com.example.santamariafernando.modelo

data class Producto(val codProducto:Int?, val codCategoria:Int,
                    val denominacion:String, val precio:Double,
                    val exclusivo:String, val imagen:String) {
}