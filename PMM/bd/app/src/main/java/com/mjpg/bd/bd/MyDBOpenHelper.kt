package com.mjpg.bd.bd

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

        val TABLA_USUARIOS = "usuarios"
        val COL_LOGIN = "login"
        val COL_CONTRA = "contra"

    }

    /**
     * Se crean las tablas de la base de datos
     */

    override fun onCreate(db: SQLiteDatabase?) {
        try {

            val crearTablaUsuarios =
                "CREATE TABLE $TABLA_USUARIOS (" +
                        "$COL_LOGIN TEXT PRIMARY KEY , " +
                        "$COL_CONTRA TEXT)"
            db!!.execSQL(crearTablaUsuarios)


        } catch (e: SQLiteException) {
        }
    }

    /*
    *Si se cambia la versión, se ejecuta este método con todos los datos que tenga
     */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


}
