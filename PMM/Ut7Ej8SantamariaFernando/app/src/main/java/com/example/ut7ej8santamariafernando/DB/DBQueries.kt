package com.example.ut7ej8santamariafernando.DB

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
}