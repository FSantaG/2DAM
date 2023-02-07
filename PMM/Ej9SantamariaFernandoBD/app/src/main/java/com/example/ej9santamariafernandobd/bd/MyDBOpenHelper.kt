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
        val DATABASE_NAME = "CSSantamariaFernando.db"

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

        val TABLA_CITAS = "CITAS"
        val COL_CIT_ID = "id_cita"
        val COL_CIT_FECHA = "fecha"
        val COL_CIT_HORA = "hora"
        val COL_CIT_NUMCOLEGIADO = COL_PRO_NUMCOLEGIADO
        val COL_CIT_NUMAFILIACION = COL_USU_NUMAFILIACION
    }

    override fun onCreate(database: SQLiteDatabase?) {
        try {
            var queryList = listOf<String>(
                "CREATE TABLE ${TABLA_USUARIOS} (" +
                        "${COL_USU_NUMAFILIACION} TEXT UNIQUE CHECK(length(${COL_USU_NUMAFILIACION}) <= 20)," +
                        "${COL_USU_NOMBRE} TEXT CHECK(length(${COL_USU_NOMBRE}) <= 40)," +
                        "PRIMARY KEY(${COL_USU_NUMAFILIACION})" +
                        ");",
                "CREATE TABLE ${TABLA_TIPOS} (" +
                        "${COL_TIP_CODIGO} INTEGER," +
                        "${COL_TIP_DESCRIPCION} TEXT CHECK(length(${COL_TIP_DESCRIPCION}) <= 20)," +
                        "PRIMARY KEY (${COL_TIP_CODIGO} AUTOINCREMENT)" +
                        ");",
                "CREATE TABLE ${TABLA_PROFESIONALES} (" +
                        "${COL_PRO_NUMCOLEGIADO} INTEGER," +
                        "${COL_PRO_CODTIPO} INTEGER," +
                        "${COL_PRO_NOMBRE} TEXT," +
                        "FOREIGN KEY(${COL_PRO_CODTIPO}) REFERENCES ${TABLA_TIPOS}(${COL_TIP_CODIGO})," +
                        "PRIMARY KEY(${COL_PRO_NUMCOLEGIADO} AUTOINCREMENT)" +
                        ");",
                "CREATE TABLE ${TABLA_PROFESIONALES_USUARIOS} (" +
                        "${COL_PRUS_ID} INTEGER," +
                        "${COL_PRUS_NUMCOLEGIADO} INTEGER," +
                        "${COL_PRUS_NUMAFILIACION} TEXT CHECK(length(${COL_PRUS_NUMAFILIACION}) <= 20)," +
                        "FOREIGN KEY(${COL_PRUS_NUMCOLEGIADO}) REFERENCES ${TABLA_PROFESIONALES}(${COL_PRO_NUMCOLEGIADO})," +
                        "PRIMARY KEY(${COL_PRUS_ID} AUTOINCREMENT)," +
                        "FOREIGN KEY(${COL_PRUS_NUMAFILIACION}) REFERENCES ${TABLA_USUARIOS}(${COL_USU_NUMAFILIACION})" +
                        ");",
                "CREATE TABLE ${TABLA_CITAS} (" +
                        "${COL_CIT_ID} INTEGER," +
                        "${COL_CIT_FECHA} TEXT," +
                        "${COL_CIT_HORA} TEXT," +
                        "${COL_CIT_NUMCOLEGIADO} INTEGER," +
                        "${COL_CIT_NUMAFILIACION} TEXT CHECK(length(${COL_CIT_NUMAFILIACION}) <= 20," +
                        "PRIMARY KEY(${COL_CIT_ID} AUTOINCREMENT)," +
                        "FOREIGN KEY(${COL_CIT_NUMCOLEGIADO}) REFERENCES ${TABLA_PROFESIONALES}(${COL_PRO_NUMCOLEGIADO})," +
                        "FOREIGN KEY(${COL_CIT_NUMAFILIACION}) REFERENCES ${TABLA_USUARIOS}(${COL_USU_NUMAFILIACION})" +
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