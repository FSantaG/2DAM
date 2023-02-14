package com.example.santamariafernando.modelo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class DBQueries (contexto: Context) {
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

    //OPERACIONES CON USUARIOS
    fun addUsuario(datosUsuario:List<String>) {
        val usuario = Usuario(
            datosUsuario[0],
            datosUsuario[1]
        )
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_USU_LOGIN, usuario.login)
        values.put(MyDBOpenHelper.COL_USU_CONTRASENA, usuario.contrasena)

        mBD.insert(MyDBOpenHelper.TABLA_USUARIOS, null, values)
    }

    fun getUsuario(username: String, pass: String): Boolean {
        var flag = false
        val cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_USUARIOS} " +
                    "WHERE ${MyDBOpenHelper.COL_USU_LOGIN} = '$username' " +
                    "AND ${MyDBOpenHelper.COL_USU_CONTRASENA} = '$pass'",
            null
        )
        if (cursor.moveToFirst()) {
            flag = true
        }
        if (!cursor.isClosed)
            cursor.close()
        return flag
    }

    //OPERACIONES CON CATEGORIAS
    fun addCategoria(datosCategoria:List<String>) {
        val categoria = Categoria(
            null,
            datosCategoria[0],
            datosCategoria[1]
        )
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_CAT_CODCATEGORIA, categoria.codigo)
        values.put(MyDBOpenHelper.COL_CAT_DENOMINACION, categoria.denominacion)
        values.put(MyDBOpenHelper.COL_CAT_IMAGEN, categoria.imagen)

        mBD.insert(MyDBOpenHelper.TABLA_CATEGORIAS, null, values)
    }

    fun getAllCategories(): MutableList<Categoria> {
        val lista: MutableList<Categoria> = ArrayList()
        val cursor: Cursor = mBD.query(
            MyDBOpenHelper.TABLA_CATEGORIAS,
            null, null,
            null, null,
            null, null
        )
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Categoria(
                        cursor.getInt(cursor.getColumnIndexOrThrow("cod_categoria")),
                        cursor.getString(cursor.getColumnIndexOrThrow("denominacion")),
                        cursor.getString(cursor.getColumnIndexOrThrow("imagen"))
                    )
                )
            } while (cursor.moveToNext())

        }
        if (!cursor.isClosed)
            cursor.close()
        return lista
    }

    //OPERACIONES CON PRODUCTOS
    fun addProducto(datosProducto:List<String>) {
        val producto = Producto(
            null,
            Integer.parseInt(datosProducto[0]),
            datosProducto[1],
            datosProducto[2].toDouble(),
            datosProducto[3],
            datosProducto[4]
        )
        val values = ContentValues()

        values.put(MyDBOpenHelper.COL_PROD_CODPRODUCTO, producto.codProducto)
        values.put(MyDBOpenHelper.COL_PROD_CODCATEGORIA, producto.codCategoria)
        values.put(MyDBOpenHelper.COL_PROD_DENOMINACION, producto.denominacion)
        values.put(MyDBOpenHelper.COL_PROD_PRECIO, producto.precio)
        values.put(MyDBOpenHelper.COL_PROD_EXCLUSIVO, producto.exclusivo)
        values.put(MyDBOpenHelper.COL_PROD_IMAGEN, producto.imagen)

        mBD.insert(MyDBOpenHelper.TABLA_PRODUCTOS, null, values)
    }

    fun getAllProductos(codigoCategoria:String): MutableList<Producto> {
        val lista: MutableList<Producto> = ArrayList()
        var cursor: Cursor = mBD.rawQuery(
            "SELECT * FROM ${MyDBOpenHelper.TABLA_PRODUCTOS} WHERE ${MyDBOpenHelper.COL_CAT_CODCATEGORIA} = $codigoCategoria",
            null
        )
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Producto(
                        cursor.getInt(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROD_CODPRODUCTO)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROD_CODCATEGORIA)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROD_DENOMINACION)),
                        cursor.getDouble(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROD_PRECIO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROD_EXCLUSIVO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROD_IMAGEN))
                    )
                )
            } while (cursor.moveToNext())
        }
        if (!cursor.isClosed)
            cursor.close()
        return lista
    }
}