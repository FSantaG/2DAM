package com.example.ej9santamariafernandobd.bd

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class MyDBOpenHelper (
    context: Context,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "ut7ej7SantamariaFernando.db"

        val TABLA_USUARIOS = "USUARIOS"
        val COL_USU_NUMAFILIACION = "num_afiliado" //TEXT length 20 PK
        val COL_USU_NOMBRE = "nombre" //TEXT length 40

        val TABLA_TIPOS = "TIPOS"
        val COL_TIP_CODIGO = "codigo_tipo" //INT AUTOINCREMENT PK
        val COL_TIP_DESCRIPCION = "descripcion" //TEXT length 20

        val TABLA_PROFESIONALES = "PROFESIONALES"
        val COL_PRO_NUMCOLEGIADO = "num_colegiado" //INT PK
        val COL_PRO_CODTIPO = COL_TIP_CODIGO //INT FK REFERENCES COL_TIP_CODIGO
        val COL_PRO_NOMBRE = "nombre" //TEXT

        val TABLA_PROFESIONALES_USUARIOS = "PROFESIONALES_USUARIOS"
        val COL_PRUS_ID = "id"
        val COL_PRUS_NUMCOLEGIADO = COL_PRO_NUMCOLEGIADO
        val COL_PRUS_NUMAFILIACION = COL_USU_NUMAFILIACION

    }

    override fun onCreate(database: SQLiteDatabase?) {
        try {
            var queryList = listOf<String>(
                ""
            )
            for(query in queryList) {
                database!!.execSQL(query)
            }

        } catch (e: SQLiteException) {
        }
    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}