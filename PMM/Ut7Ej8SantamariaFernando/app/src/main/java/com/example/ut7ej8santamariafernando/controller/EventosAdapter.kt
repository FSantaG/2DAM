package com.example.ut7ej8santamariafernando.controller

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ut7ej8santamariafernando.R
import com.example.ut7ej8santamariafernando.databinding.ListaEventosBinding
import com.example.ut7ej8santamariafernando.db.MyDBOpenHelper

class EventosAdapter (private var cursor: Cursor, private var context: Context, private val listener: Eventos)
: RecyclerView.Adapter<EventosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.lista_eventos, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {
            cursor.moveToPosition(position)
            binding.titulo.text =
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_EV_TITULO))
            binding.descripcion.text =
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBOpenHelper.COL_EV_DESCRIPCION))
            setListener(cursor,position)
        }

    }

    override fun getItemCount(): Int = cursor.count

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ListaEventosBinding.bind(view)

        fun setListener(cursor: Cursor,posicion : Int) {
            binding.root.setOnClickListener {
                listener.pulsacionLarga(cursor,posicion)
            }
        }
    }

}



