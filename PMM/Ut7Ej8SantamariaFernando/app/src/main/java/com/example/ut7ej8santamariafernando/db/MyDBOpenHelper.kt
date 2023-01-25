package com.example.ut7ej8santamariafernando.db

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
            val DATABASE_NAME = "Ut7Ej8SantamariaFernando.db"

            val TABLA_EVENTOS = "EVENTOS"
            val COL_EV_ID = "id_evento"
            val COL_EV_FECHA = "fecha"
            val COL_EV_HORA = "hora"
            val COL_EV_TITULO = "titulo"
            val COL_EV_DESCRIPCION = "descripcion"

            val TABLA_USUARIO = "USUARIO"
            val COL_US_ID = "id_usuario"
            val COL_US_LOGIN = "login"
            val COL_US_CLAVE = "contrasena"
            val COL_US_PERFIL = "perfil"

            val TABLA_USER_EVENTO = "USUARIO_EVENTO"
            val COL_USEV_ID = "id"
            val COL_USEV_ID_USUARIO = COL_US_ID
            val COL_USEV_ID_EVENTO = COL_EV_ID
        }

        override fun onCreate(database: SQLiteDatabase?) {
            try {
                var queryList = listOf<String>(
                    "CREATE TABLE ${TABLA_EVENTOS} (" +
                            "${COL_EV_ID} INTEGER," +
                            "${COL_EV_FECHA} TEXT," +
                            "${COL_EV_HORA} TEXT," +
                            "${COL_EV_TITULO} TEXT," +
                            "${COL_EV_DESCRIPCION} TEXT," +
                            "PRIMARY KEY(${COL_EV_ID} AUTOINCREMENT)" +
                            ");",
                    "CREATE TABLE ${TABLA_USUARIO} (" +
                            "${COL_US_ID} INTEGER," +
                            "${COL_US_LOGIN} TEXT," +
                            "${COL_US_CLAVE} TEXT," +
                            "${COL_US_PERFIL} TEXT," +
                            "CHECK(${COL_US_PERFIL} = 'A' OR ${COL_US_PERFIL} = 'U')," +
                            "PRIMARY KEY(${COL_US_ID} AUTOINCREMENT)" +
                            ");",
                    "CREATE TABLE ${TABLA_USER_EVENTO} (" +
                            "${COL_USEV_ID} INTEGER," +
                            "${COL_USEV_ID_USUARIO} INTEGER," +
                            "${COL_USEV_ID_EVENTO} INTEGER," +
                            "FOREIGN KEY(${COL_USEV_ID_USUARIO}) REFERENCES ${TABLA_USUARIO}(${COL_US_ID})," +
                            "FOREIGN KEY(${COL_USEV_ID_EVENTO}) REFERENCES ${TABLA_EVENTOS}(${COL_EV_ID})," +
                            "PRIMARY KEY(${COL_USEV_ID} AUTOINCREMENT)" +
                            ");"
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