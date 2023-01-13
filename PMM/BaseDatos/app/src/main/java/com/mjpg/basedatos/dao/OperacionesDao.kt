package com.mjpg.basedatos.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.mjpg.basedatos.bd.MyDBOpenHelper
import com.mjpg.basedatos.modelo.Usuario
import com.mjpg.enero23.datos.Puntos
import com.mjpg.enero23.datos.Tipo
import java.util.ArrayList

class OperacionesDao(contexto: Context) {

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

    fun addUsuario(usuario: Usuario) {
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_LOGIN, usuario.login)
        values.put(MyDBOpenHelper.COL_CONTRA, usuario.contra)
        mBD.insert(MyDBOpenHelper.TABLA_USUARIOS, null, values)
    }

    fun getUsuario(login: String, contrasena: String): Usuario? {
        var usuarioEncontrado: Usuario? = null
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_USUARIOS} " +
                    "WHERE ${MyDBOpenHelper.COL_LOGIN} = '$login' " +
                    "AND ${MyDBOpenHelper.COL_CONTRA} = '$contrasena'",
            null
        )
        if (cursor.moveToFirst()) {
            usuarioEncontrado = Usuario(
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_LOGIN)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_CONTRA))
            )

        }
        if (!cursor.isClosed)
            cursor.close()

        return usuarioEncontrado
    }

    fun tablaVaciaUsuarios(): Boolean {
        val vacia: Boolean
        val cursor: Cursor = mBD.query(
            MyDBOpenHelper.TABLA_USUARIOS, null, null,
            null, null, null, null
        )
        vacia = !cursor.moveToFirst()
        cursor.close()
        return vacia
    }


    fun addPunto(punto: Puntos) {
        val values = ContentValues()
        values.put(MyDBOpenHelper.COL_CODIGO, punto.codigo)
        values.put(MyDBOpenHelper.COL_CODTIPO, punto.tipo)
        values.put(MyDBOpenHelper.COL_DENOMINACION, punto.deno)
        values.put(MyDBOpenHelper.COL_DIRECCION, punto.dire)
        values.put(MyDBOpenHelper.COL_PROVINCIA, punto.prov)
        values.put(MyDBOpenHelper.COL_CARGADORES, punto.cargadores)
        values.put(MyDBOpenHelper.COL_INDICACIONES, punto.indicaciones)
        values.put(MyDBOpenHelper.COL_PRECIO, punto.precio)

        mBD.insert(MyDBOpenHelper.TABLA_PUNTOS, null, values)
    }

    fun getPuntos2(): Cursor {
        return mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_PUNTOS} ",
            null
        )
    }

    fun getPuntos(): MutableList<Puntos> {
        val lista: MutableList<Puntos> = ArrayList()
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_PUNTOS} ",
            null
        )
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Puntos(
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_CODIGO)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_CODTIPO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_DENOMINACION)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_DIRECCION)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROVINCIA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_CARGADORES)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PRECIO))

                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return lista
    }

    fun tablaVaciaPuntos(): Boolean {
        val vacia: Boolean
        val cursor: Cursor = mBD.query(
            MyDBOpenHelper.TABLA_PUNTOS, null, null,
            null, null, null, null
        )
        vacia = !cursor.moveToFirst()
        cursor.close()
        return vacia
    }

    fun existePunto(codigo: String): Boolean {
        val resultado: Boolean
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_PUNTOS} where " +
                    "${MyDBOpenHelper.COL_CODIGO}='$codigo' ",
            null
        )
        resultado = cursor.moveToFirst()
        cursor.close()
        return resultado

    }



    fun tablaVaciaTipos(): Boolean {
        val vacia: Boolean
        val cursor: Cursor = mBD.query(
            MyDBOpenHelper.TABLA_TIPOS, null, null,
            null, null, null, null
        )
        vacia = !cursor.moveToFirst()
        cursor.close()
        return vacia
    }
    fun addTipo(deno: String) {
        val values = ContentValues()
        values.put(MyDBOpenHelper.COL_DENO, deno)
        mBD.insert(MyDBOpenHelper.TABLA_TIPOS, null, values)
    }

    fun existeTipo(codigo: Int): Boolean {
        val resultado: Boolean
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_TIPOS} where " +
                    "${MyDBOpenHelper.COl_TIPO}='$codigo' ",
            null
        )
        resultado = cursor.moveToFirst()
        cursor.close()
        return resultado

    }
    fun getUnTipo(codigo: Int):Tipo? {
        var tipo:Tipo?=null
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_TIPOS} where " +
                    "${MyDBOpenHelper.COl_TIPO}='$codigo' ",
            null
        )
        if(cursor.moveToFirst()) {
            tipo = Tipo(
                cursor.getInt(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COl_TIPO)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_DENO))
            )
        }
        cursor.close()
        return tipo

    }
}
