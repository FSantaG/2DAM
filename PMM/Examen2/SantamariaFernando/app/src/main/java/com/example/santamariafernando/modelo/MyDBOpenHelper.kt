package com.example.santamariafernando.modelo

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
        val DATABASE_NAME = "EMPRESA.db"

        val TABLA_USUARIOS = "USUARIOS"
        val COL_USU_LOGIN = "login" //TEXT PK
        val COL_USU_CONTRASENA = "contrasena" //TEXT

        val TABLA_CATEGORIAS = "CATEGORIAS"
        val COL_CAT_CODCATEGORIA = "cod_categoria" //INT PK AUTOINCREMENT
        val COL_CAT_DENOMINACION = "denominacion" //TEXT
        val COL_CAT_IMAGEN = "imagen" //TEXT

        val TABLA_PRODUCTOS = "PRODUCTOS"
        val COL_PROD_CODPRODUCTO = "cod_producto" //INT PK AUTOINCREMENT
        val COL_PROD_CODCATEGORIA = COL_CAT_CODCATEGORIA //INT FK CATEGORIA(cod_categoria)
        val COL_PROD_DENOMINACION = "denominacion" //TEXT
        val COL_PROD_PRECIO = "precio" //NUMERIC
        val COL_PROD_EXCLUSIVO = "exclusivo" //TEXT (SI/NO)
        val COL_PROD_IMAGEN = "imagen" //TEXT
    }

    override fun onCreate(database: SQLiteDatabase?) {
        try {
            var queryList = listOf<String>(
                "CREATE TABLE ${TABLA_USUARIOS} ( " +
                        "${COL_USU_LOGIN} TEXT, " +
                        "${COL_USU_CONTRASENA} TEXT, " +
                        "PRIMARY KEY(${COL_USU_LOGIN})" +
                        ");",
                "CREATE TABLE ${TABLA_CATEGORIAS} (" +
                        "${COL_CAT_CODCATEGORIA} INTEGER, " +
                        "${COL_CAT_DENOMINACION} TEXT, " +
                        "${COL_CAT_IMAGEN} TEXT, " +
                        "PRIMARY KEY(${COL_CAT_CODCATEGORIA} AUTOINCREMENT)" +
                        ");",
                "CREATE TABLE ${TABLA_PRODUCTOS} (" +
                        "${COL_PROD_CODPRODUCTO} INTEGER," +
                        "${COL_PROD_CODCATEGORIA} INTEGER," +
                        "${COL_PROD_DENOMINACION} TEXT," +
                        "${COL_PROD_PRECIO} NUMERIC," +
                        "${COL_PROD_EXCLUSIVO} TEXT CHECK(${COL_PROD_EXCLUSIVO} = 'SI' OR ${COL_PROD_EXCLUSIVO} = 'NO')," +
                        "${COL_PROD_IMAGEN} TEXT," +
                        "PRIMARY KEY(${COL_PROD_CODPRODUCTO} AUTOINCREMENT)" +
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