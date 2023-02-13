package com.example.ej9santamariafernandobd.modelo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.COL_CIT_FECHA
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.COL_CIT_HORA
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.COL_CIT_NUMAFILIACION
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.COL_CIT_NUMCOLEGIADO
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.COL_PRO_CODTIPO
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.COL_PRO_NUMCOLEGIADO
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.COL_TIP_CODIGO
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.COL_TIP_DESCRIPCION
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.TABLA_CITAS
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.TABLA_PROFESIONALES
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.TABLA_TIPOS
import com.example.ej9santamariafernandobd.modelo.MyDBOpenHelper.Companion.TABLA_USUARIOS
import com.example.ej9santamariafernandobd.vistamodelo.AdaptadorCitas

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

    //todo OPERACIONES CON USUARIOS
    fun getAllTarjetas(): MutableList<Usuarios> {
        val lista: MutableList<Usuarios> = ArrayList()
        val cursor: Cursor = mBD.query(
            TABLA_USUARIOS,
            null, null,
            null, null,
            null, null
        )
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Usuarios(
                        cursor.getString(cursor.getColumnIndexOrThrow("num_afiliado")),
                        cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                    )
                )
            } while (cursor.moveToNext())

        }
        if (!cursor.isClosed)
            cursor.close()
        return lista
    }

    fun addUsuario(usuario: Usuarios):Long {
        val values = ContentValues()
        values.put("num_afiliado", usuario.numAfiliado)
        values.put("nombre", usuario.nombre)
        return mBD.insert(TABLA_USUARIOS, null, values)
    }

    //todo OPERACIONES CON PROFESIONALES(El TODO solo es para añadir visibilidad a los textos)
    fun addProfesional(datosProfesional:List<String>){
        val profesional = Profesionales(
            null,
            datosProfesional[0].toInt(),
            datosProfesional[1]
        )
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_PRO_NUMCOLEGIADO, profesional.numColegiado)
        values.put(MyDBOpenHelper.COL_PRO_CODTIPO, profesional.codigoTipo)
        values.put(MyDBOpenHelper.COL_PRO_NOMBRE, profesional.nombre)

        mBD.insert(MyDBOpenHelper.TABLA_PROFESIONALES, null, values)
    }

    //todo OPERACIONES CON TIPOS
    fun addTipo(tipo:String){
        val tipo = Tipos(
            null,
            tipo
        )
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_TIP_CODIGO, tipo.codigo)
        values.put(MyDBOpenHelper.COL_TIP_DESCRIPCION, tipo.descripcion)

        mBD.insert(MyDBOpenHelper.TABLA_TIPOS, null, values)
    }

    fun getTipoProfesional(numColegiado:Int):String{
        var tipo:String = ""
        var cursor:Cursor = mBD.rawQuery(
            "SELECT ${COL_TIP_DESCRIPCION} FROM ${TABLA_TIPOS} " +
                    "inner join ${TABLA_PROFESIONALES} on ${TABLA_PROFESIONALES}.${COL_PRO_CODTIPO} = ${TABLA_TIPOS}.${COL_TIP_CODIGO} " +
                    "where ${COL_PRO_NUMCOLEGIADO} = $numColegiado",
            null
        )
        if(cursor.moveToFirst()){
            tipo = cursor.getString(cursor.getColumnIndexOrThrow(COL_TIP_DESCRIPCION))
        }
        if(!cursor.isClosed)
            cursor.close()
        return tipo
    }

    //todo OPERACIONES CON CITAS
    fun getCitas(numAfiliacion:String): MutableList<Citas>{
        val lista:MutableList<Citas> = ArrayList()
        var cursor:Cursor = mBD.rawQuery(
            "SELECT * FROM ${TABLA_CITAS} WHERE ${COL_CIT_NUMAFILIACION} = '$numAfiliacion'",
            null
        )
        if(cursor.moveToFirst()){
            do{
                lista.add(
                    Citas(
                        cursor.getInt(cursor.getColumnIndexOrThrow(COL_CIT_FECHA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_CIT_FECHA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_CIT_HORA)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(COL_CIT_NUMCOLEGIADO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_CIT_NUMAFILIACION))
                    )
                )
            }while(cursor.moveToNext())
        }
        if(!cursor.isClosed)
            cursor.close()
        return lista
    }
}