package com.mjpg.basedatos.bd

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class MyDBOpenHelper(
    context: Context,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "enero.db"
        val TABLA_PUNTOS = "puntos"
        val TABLA_TIPOS = "tipos"
        val TABLA_USUARIOS = "usuarios"
        val COL_LOGIN = "login"
        val COL_CONTRA = "contra"
        val COL_CODIGO = "codigo"
        val COL_CODTIPO = "codtipo"
        val COL_DENOMINACION = "denominacion"
        val COL_DIRECCION = "direccion"
        val COL_PROVINCIA = "provincia"
        val COL_CARGADORES = "cargadores"
        val COL_INDICACIONES = "indicaciones"
        val COL_PRECIO = "precio"
        val COl_TIPO="codigoTipo"
        val COL_DENO="denominacion"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        try {

            val crearTablaUsuarios =
                "CREATE TABLE $TABLA_USUARIOS (" +
                        "$COL_LOGIN TEXT PRIMARY KEY , " +
                        "$COL_CONTRA TEXT)"
            db!!.execSQL(crearTablaUsuarios)
            val crearTablaPuntos = "CREATE TABLE $TABLA_PUNTOS (" +
                    "$COL_CODIGO TEXT PRIMARY KEY , " +
                    "$COL_CODTIPO INTEGER," +
                    "$COL_DENOMINACION TEXT," +
                    "$COL_DIRECCION TEXT," +
                    "$COL_PROVINCIA TEXT," +
                    "$COL_CARGADORES TEXT," +
                    "$COL_INDICACIONES TEXT," +
                    "$COL_PRECIO TEXT" +
                    ")"
            db!!.execSQL(crearTablaPuntos)
            val crearTablaEstablecimientos =
                "CREATE TABLE $TABLA_TIPOS (" +
                        "$COl_TIPO INTEGER PRIMARY KEY AUTOINCREMENT , " +
                        "$COL_DENO TEXT)"
            db!!.execSQL(crearTablaEstablecimientos)
        } catch (e: SQLiteException) {
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


}
