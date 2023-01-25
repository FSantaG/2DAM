package com.example.ut7ej8santamariafernando.controller

import android.database.Cursor

interface Eventos {
    fun pulsacionLarga(cursor: Cursor, posicion : Int):Boolean
}