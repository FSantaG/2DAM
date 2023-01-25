package com.example.ut7ej8santamariafernando.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.ut7ej8santamariafernando.Model.Usuario

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

    fun addUsuario(datosUsuario:List<String>){
        val usuario = Usuario(
            null,
            datosUsuario[0],
            datosUsuario[1],
            datosUsuario[2]
        )
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_US_ID, usuario.id)
        values.put(MyDBOpenHelper.COL_US_LOGIN, usuario.login)
        values.put(MyDBOpenHelper.COL_US_CLAVE, usuario.clave)
        values.put(MyDBOpenHelper.COL_US_PERFIL, usuario.perfil)

        mBD.insert(MyDBOpenHelper.TABLA_USUARIO, null, values)
    }

    fun getUsuario(username: String, pass: String): Usuario? {
        var usuarioEncontrado: Usuario? = null
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_USUARIO} " +
                    "WHERE ${MyDBOpenHelper.COL_US_LOGIN} = '$username' " +
                    "AND ${MyDBOpenHelper.COL_US_CLAVE} = '$pass'",
            null
        )
        if (cursor.moveToFirst()) {
            usuarioEncontrado = Usuario(
                cursor.getInt(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_US_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_US_LOGIN)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_US_CLAVE)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_US_PERFIL))
            )

        }
        if (!cursor.isClosed)
            cursor.close()

        return usuarioEncontrado

    }
}