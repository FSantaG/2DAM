package com.example.ut7ej7santamariafernando.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.ut7ej7santamariafernando.model.AluProf
import com.example.ut7ej7santamariafernando.model.Alumno
import com.example.ut7ej7santamariafernando.model.Faltas
import com.example.ut7ej7santamariafernando.model.Profesor
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

    fun addAlumno(alumno: Alumno) {
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_ALU_CODIGOALUMNO, alumno.codigo)
        values.put(MyDBOpenHelper.COL_ALU_NOMBRE, alumno.nombre)
        mBD.insert(MyDBOpenHelper.TABLA_ALUMNOS, null, values)
    }

    /*fun getAlumno(codigoProfesor:String) : MutableList<Alumno>{
        var alumnos: MutableList<Alumno> = ArrayList()
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_ALUMNOS} " +
                    "WHERE ${MyDBOpenHelper.COL_ALU_CODIGOALUMNO} IN (" +
                    "SELECT ${MyDBOpenHelper.COL_ALU_CODIGOALUMNO} FROM ${MyDBOpenHelper.TABLA_ALUMNOS} " +
                    "WHERE ${MyDBOpenHelper.COL_ALPR_CODIGOPROFESOR} = ${codigoProfesor})'",
            null
        )
        if (cursor.moveToFirst()) {
            do{
                alumnos.add(
                    Alumno(
                        cursor.getInt(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_ALU_CODIGOALUMNO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_ALU_NOMBRE))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed) {
            cursor.close()
        }
        return alumnos
    }*/

    fun addProfesor(profesor: Profesor){
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_PROF_DNIPROF, profesor.dni)
        values.put(MyDBOpenHelper.COL_PROF_USUARIO, profesor.usuario)
        values.put(MyDBOpenHelper.COL_PROF_CONTRA, profesor.clave)
        values.put(MyDBOpenHelper.COL_PROF_NOMBREPROFESOR, profesor.nombre)
        mBD.insert(MyDBOpenHelper.TABLA_PROFESOR, null, values)
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

    fun addFalta(falta:Faltas){
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_FAL_CODIGO, falta.codigo)
        values.put(MyDBOpenHelper.COL_FAL_CODIGOALUMNO, falta.alumno)
        values.put(MyDBOpenHelper.COL_FAL_FECHA, falta.fecha)
        values.put(MyDBOpenHelper.COL_FAL_HORA, falta.hora)
        values.put(MyDBOpenHelper.COL_FAL_CODIGOPROFE, falta.profesor)
        values.put(MyDBOpenHelper.COL_FAL_JUSTIFICADA, falta.justificada)
        values.put(MyDBOpenHelper.COL_FAL_OBSERVACIONES, falta.observaciones)
        mBD.insert(MyDBOpenHelper.TABLA_FALTAS, null, values)
    }

    fun getFalta(dniProf: String): Cursor {
        val faltas = mBD.rawQuery(
            "SELECT ${MyDBOpenHelper.TABLA_ALUMNOS}.${MyDBOpenHelper.COL_ALU_NOMBRE}, ${MyDBOpenHelper.TABLA_PROFESOR}.${MyDBOpenHelper.COL_PROF_NOMBREPROFESOR}, ${MyDBOpenHelper.TABLA_FALTAS}.${MyDBOpenHelper.COL_FAL_FECHA}, ${MyDBOpenHelper.TABLA_FALTAS}.${MyDBOpenHelper.COL_FAL_HORA}, ${MyDBOpenHelper.TABLA_FALTAS}.${MyDBOpenHelper.COL_FAL_JUSTIFICADA}\n " +
                    "FROM ${MyDBOpenHelper.TABLA_FALTAS}\n" +
                    "INNER JOIN ${MyDBOpenHelper.TABLA_ALUMNOS} ON ${MyDBOpenHelper.TABLA_ALUMNOS}.${MyDBOpenHelper.COL_ALU_CODIGOALUMNO} = ${MyDBOpenHelper.TABLA_FALTAS}.${MyDBOpenHelper.COL_FAL_CODIGOALUMNO}\n" +
                    "INNER JOIN ${MyDBOpenHelper.TABLA_PROFESOR} ON ${MyDBOpenHelper.TABLA_PROFESOR}.${MyDBOpenHelper.COL_PROF_DNIPROF} = ${MyDBOpenHelper.TABLA_FALTAS}.${MyDBOpenHelper.COL_FAL_CODIGOPROFE}\n" +
                    "WHERE ${MyDBOpenHelper.TABLA_FALTAS}.${MyDBOpenHelper.COL_FAL_CODIGOPROFE} = \"${dniProf}\"",
            null
        )
        return faltas;
    }

    fun existeAlumno(codAlumno: Int): Boolean {
        val resultado: Boolean
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_ALUMNOS} " +
                "WHERE ${MyDBOpenHelper.COL_FAL_CODIGOALUMNO} = '$codAlumno' ", null
        )
        resultado = cursor.moveToFirst()
        cursor.close()

        return resultado
    }

    fun existFalta(codAlumno: Int, fecha: String, hora: Int): Boolean {
        val resultado: Boolean
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_FALTAS} " +
                    "WHERE ${MyDBOpenHelper.COL_FAL_CODIGOALUMNO} = '$codAlumno' " + "AND ${MyDBOpenHelper.COL_FAL_FECHA} = '$fecha' " +
                    "AND ${MyDBOpenHelper.COL_FAL_HORA} = '$hora'", null
        )
        resultado = cursor.moveToFirst()
        cursor.close()

        return resultado
    }

    fun existFaltaProfesor(codProfesor: String?): Boolean {
        val resultado: Boolean
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_FALTAS} " +
                    "WHERE ${MyDBOpenHelper.COL_FAL_CODIGOPROFE} = '$codProfesor' ", null
        )
        resultado = cursor.moveToFirst()
        cursor.close()

        return resultado
    }

    fun addAluProf(aluProf: AluProf){
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_ALPR_CODIGO, aluProf.codigo)
        values.put(MyDBOpenHelper.COL_ALPR_CODIGOALUMNO, aluProf.alumno)
        values.put(MyDBOpenHelper.COL_ALPR_CODIGOPROFESOR, aluProf.profesor)
        mBD.insert(MyDBOpenHelper.TABLA_ALUPROF, null, values)
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

    fun justificarFalta(idUsuario:Int){
        val values = ContentValues()
        values.put(MyDBOpenHelper.COL_FAL_JUSTIFICADA, 1)

        mBD.update(
            MyDBOpenHelper.TABLA_FALTAS,
            values,
            "${MyDBOpenHelper.COL_FAL_CODIGOALUMNO} = ${idUsuario}",
            null
        )
    }
}