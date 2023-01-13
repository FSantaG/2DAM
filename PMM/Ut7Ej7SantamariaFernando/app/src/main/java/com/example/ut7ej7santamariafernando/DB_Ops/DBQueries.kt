package com.example.ut7ej7santamariafernando.DB_Ops

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.ut7ej7santamariafernando.Model.Profesor
import com.example.ut7ej7santamariafernando.MyDBOpenHelper

class DBQueries(contexto:Context) {
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

    fun getProfesor(username: String, pass: String): Profesor? {
        var profesorEncontrado: Profesor? = null
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_PROFESOR} " +
                    "WHERE ${MyDBOpenHelper.COL_PROF_USUARIO} = '$username' " +
                    "AND ${MyDBOpenHelper.COL_PROF_CONTRA} = '$pass'",
            null
        )
        if (cursor.moveToFirst()) {
            profesorEncontrado = Profesor(
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROF_DNIPROF)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROF_USUARIO)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROF_CONTRA)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROF_NOMBREPROFESOR))
            )

        }
        if (!cursor.isClosed)
            cursor.close()

        return profesorEncontrado

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