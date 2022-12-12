package com.example.dicatecaalejandro

import android.view.View

interface Eventos {
    fun pulsacionCorta(caso: Caso, pos: Int)
    fun pulsacionLarga(pos: Int): Boolean
}