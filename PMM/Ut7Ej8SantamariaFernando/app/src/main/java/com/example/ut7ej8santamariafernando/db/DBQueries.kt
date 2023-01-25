package com.example.ut7ej8santamariafernando.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.ut7ej8santamariafernando.model.Evento
import com.example.ut7ej8santamariafernando.model.Usuario

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

    fun getEventos(): Cursor {
        return mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_EVENTOS} ",
            null
        )
    }

    fun addEvento(evento: Evento){
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_EV_ID, evento.id)
        values.put(MyDBOpenHelper.COL_EV_FECHA, evento.fecha)
        values.put(MyDBOpenHelper.COL_EV_HORA, evento.hora)
        values.put(MyDBOpenHelper.COL_EV_TITULO, evento.titulo)
        values.put(MyDBOpenHelper.COL_EV_DESCRIPCION, evento.descripcion)

        mBD.insert(MyDBOpenHelper.TABLA_EVENTOS, null, values)

    }

    fun existEvento(fecha: String, hora: String): Boolean {
        val resultado: Boolean
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_EVENTOS} " +
                    "WHERE ${MyDBOpenHelper.COL_EV_FECHA} = '$fecha' " +
                    "AND ${MyDBOpenHelper.COL_EV_HORA} = '$hora'", null
        )
        resultado = cursor.moveToFirst()
        cursor.close()

        return resultado
    }

    fun updateEvento(titulo: String, fecha: String, hora: String) {
        val values = ContentValues()
        values.put(MyDBOpenHelper.COL_EV_FECHA, fecha)
        values.put(MyDBOpenHelper.COL_EV_HORA, hora)
        mBD.update(
            MyDBOpenHelper.TABLA_EVENTOS,
            values, "${MyDBOpenHelper.COL_EV_TITULO} = '$titulo' ", null
        )
    }

    fun obtenerEventoSeleccionado(codEvento: Int): Evento?{
        var evento: Evento? = null
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_EVENTOS} " +
                    "WHERE ${MyDBOpenHelper.COL_EV_ID} = '$codEvento' ", null
        )

        if (cursor.moveToFirst()) {
            evento = Evento(
                cursor.getInt(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_EV_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_EV_FECHA)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_EV_HORA)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_EV_TITULO)),
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_EV_DESCRIPCION))
            )
        }
        if (!cursor.isClosed)
            cursor.close()

        return evento
    }

    fun addEventoUsuario(codUsuario: Int, codEvento: Int) {
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_USEV_ID_USUARIO, codUsuario)
        values.put(MyDBOpenHelper.COL_USEV_ID_EVENTO, codEvento)

        mBD.insert(MyDBOpenHelper.TABLA_USER_EVENTO, null, values)
    }

    fun removeEventoUsuario(codUsuario: Int, codEvento: Int) {
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_USEV_ID_USUARIO, codUsuario)
        values.put(MyDBOpenHelper.COL_USEV_ID_EVENTO, codEvento)

        mBD.delete(
            MyDBOpenHelper.TABLA_USER_EVENTO,
            "${MyDBOpenHelper.COL_USEV_ID_USUARIO} = '$codUsuario'" +
                    "AND ${MyDBOpenHelper.COL_USEV_ID_EVENTO} = '$codEvento' ",
            null
        )
    }

    fun existsEventoUsuario(codUsuario: Int, codEvento: Int): Boolean {
        val resultado: Boolean
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_USER_EVENTO} " +
                    "WHERE ${MyDBOpenHelper.COL_USEV_ID_USUARIO} = '$codUsuario' " +
                    "AND ${MyDBOpenHelper.COL_USEV_ID_EVENTO} = '$codEvento'", null
        )
        resultado = cursor.moveToFirst()
        cursor.close()

        return resultado
    }
}