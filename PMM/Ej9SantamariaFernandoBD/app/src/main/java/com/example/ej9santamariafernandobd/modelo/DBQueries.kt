package com.example.ej9santamariafernandobd.modelo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DBQueries(contexto: Context) {
    private val mBD: SQLiteDatabase


    init {
        val estructura = MyDBOpenHelper(
            contexto,
            MyDBOpenHelper.DATABASE_NAME,
            null,
            MyDBOpenHelper.DATABASE_VERSION
        )
        mBD = estructura.writableDatabase
    }

    fun checkEmptyTable(tabla:String): Boolean {
        val vacia: Boolean
        val cursor: Cursor = mBD.query(
            tabla, null, null,
            null, null, null, null
        )
        vacia = !cursor.moveToFirst()
        cursor.close()
        return vacia
    }

    //todo OPERACIONES CON PROFESIONALES(El TODO solo es para añadir visibilidad a los textos)
    fun addProfesional(datosProfesional:List<String>){
        val profesional = Profesionales(
            null,
            datosProfesional[0].toInt(),
            datosProfesional[1]
        )
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_PRO_NUMCOLEGIADO, profesional.numColegiado)
        values.put(MyDBOpenHelper.COL_PRO_CODTIPO, profesional.codigoTipo)
        values.put(MyDBOpenHelper.COL_PRO_NOMBRE, profesional.nombre)

        mBD.insert(MyDBOpenHelper.TABLA_PROFESIONALES, null, values)
    }

    //todo OPERACIONES CON TIPOS
    fun addTipo(tipo:String){
        val tipo = Tipos(
            null,
            tipo
        )
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_TIP_CODIGO, tipo.codigo)
        values.put(MyDBOpenHelper.COL_TIP_DESCRIPCION, tipo.descripcion)

        mBD.insert(MyDBOpenHelper.TABLA_TIPOS, null, values)
    }
}