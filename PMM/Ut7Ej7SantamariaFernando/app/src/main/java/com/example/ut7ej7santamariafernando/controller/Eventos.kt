package com.example.ut7ej7santamariafernando.controller

import android.database.Cursor

interface Eventos {
    fun pulsacionCorta(cursor: Cursor, posicion:Int)
}