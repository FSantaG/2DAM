package com.example.ut7ej7santamariafernando

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
            val DATABASE_NAME = "Ut7Ej7SantamariaFernando.db"

            val TABLA_ALUMNOS = "alumnos"
            val COL_ALU_CODIGOALUMNO = "cod_alumno"
            val COL_ALU_NOMBRE = "nombre"

            val TABLA_PROFESOR = "profesor"
            val COL_PROF_DNIPROF = "dni_profesor" //Este es el código del profesor
            val COL_PROF_USUARIO = "nombre_usuario"
            val COL_PROF_CONTRA = "clave"
            val COL_PROF_NOMBREPROFESOR = "nombre_profesor"

            val TABLA_FALTAS = "faltas-alumno"
            val COL_FAL_CODIGO = "codigo"
            val COL_FAL_CODIGOALUMNO = COL_ALU_CODIGOALUMNO
            val COL_FAL_FECHA = "fecha"
            val COL_FAL_HORA = "hora"
            val COL_FAL_CODIGOPROFE = "cod_profesor"
            val COL_FAL_JUSTIFICADA = "justificada"
            val COL_FAL_OBSERVACIONES = "observaciones"

            val TABLA_ALUPROF = "profesor-alumno"
            val COL_ALPR_CODIGO = "codigo"
            val COL_ALPR_CODIGOALUMNO = COL_ALU_CODIGOALUMNO
            val COL_ALPR_CODIGOPROFESOR = COL_FAL_CODIGOPROFE

        }

    override fun onCreate(database: SQLiteDatabase?) {
        try {
            var queryList = listOf<String>(
                "CREATE TABLE $TABLA_ALUMNOS (" +
                        "$COL_ALU_CODIGOALUMNO INTEGER," +
                        "$COL_ALU_NOMBRE TEXT NOT NULL," +
                        "PRIMARY KEY($COL_ALU_CODIGOALUMNO AUTOINCREMENT)" +
                        ")",
                "CREATE TABLE $TABLA_PROFESOR (" +
                        "$COL_PROF_DNIPROF TEXT," +
                        "$COL_PROF_USUARIO TEXT," +
                        "$COL_PROF_CONTRA TEXT," +
                        "$COL_PROF_NOMBREPROFESOR TEXT," +
                        "PRIMARY KEY($COL_PROF_DNIPROF)" +
                        ")",
                "CREATE TABLE $TABLA_FALTAS (" +
                        "$COL_FAL_CODIGO INTEGER," +
                        "$COL_FAL_CODIGOALUMNO INTEGER NOT NULL," +
                        "$COL_FAL_FECHA TEXT NOT NULL," +
                        "$COL_FAL_HORA INTEGER NOT NULL CHECK($COL_FAL_HORA >= 1 AND $COL_FAL_HORA <= 6)," +
                        "$COL_FAL_CODIGOPROFE INTEGER NOT NULL," +
                        "$COL_FAL_JUSTIFICADA INTEGER NOT NULL CHECK($COL_FAL_JUSTIFICADA < 2 AND $COL_FAL_JUSTIFICADA > -1)," +
                        "$COL_FAL_OBSERVACIONES TEXT," +
                        "FOREIGN KEY($COL_FAL_CODIGOALUMNO) REFERENCES $TABLA_ALUMNOS($COL_ALU_CODIGOALUMNO)," +
                        "FOREIGN KEY($COL_FAL_CODIGOPROFE) REFERENCES $TABLA_PROFESOR($COL_PROF_DNIPROF)," +
                        "PRIMARY KEY($COL_FAL_CODIGO AUTOINCREMENT)" +
                        ")",
                "CREATE TABLE $TABLA_ALUPROF (" +
                        "$COL_ALPR_CODIGO INTEGER," +
                        "$COL_ALPR_CODIGOALUMNO INTEGER," +
                        "$COL_ALPR_CODIGOPROFESOR INTEGER," +
                        "FOREIGN KEY($COL_ALPR_CODIGOPROFESOR) REFERENCES $TABLA_PROFESOR($COL_PROF_DNIPROF)," +
                        "FOREIGN KEY($COL_ALPR_CODIGOALUMNO) REFERENCES $TABLA_ALUMNOS($COL_ALU_CODIGOALUMNO)," +
                        "PRIMARY KEY($COL_ALPR_CODIGO AUTOINCREMENT)" +
                        ")"
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