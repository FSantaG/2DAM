package com.example.ut7ej7santamariafernando.controller

import android.content.Context
import android.database.Cursor
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ut7ej7santamariafernando.MyDBOpenHelper
import com.example.ut7ej7santamariafernando.R
import com.example.ut7ej7santamariafernando.databinding.ListaFaltasBinding

class FaltasAdapter(private val faltas:Cursor, private val listener: Eventos): RecyclerView.Adapter<FaltasAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.lista_faltas, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        faltas.moveToPosition(position)

        with(holder){
            binding.alumno.text = faltas.getString(faltas.getColumnIndexOrThrow(MyDBOpenHelper.COL_ALU_NOMBRE))
            binding.profesor.text = "Profesor: " + faltas.getString(faltas.getColumnIndexOrThrow(MyDBOpenHelper.COL_PROF_NOMBREPROFESOR))
            binding.fecha.text = faltas.getString(faltas.getColumnIndexOrThrow(MyDBOpenHelper.COL_FAL_FECHA))
            binding.hora.text = "Hora " + faltas.getString(faltas.getColumnIndexOrThrow(MyDBOpenHelper.COL_FAL_HORA))

            if (faltas.getString(faltas.getColumnIndexOrThrow(MyDBOpenHelper.COL_FAL_JUSTIFICADA)) == "0") {
                binding.falta.setBackgroundColor(Color.RED)
            }
            else {
                binding.falta.setBackgroundColor(Color.GREEN)
            }
            setListener(faltas, position)
        }
    }
    override fun getItemCount(): Int = faltas.count;

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ListaFaltasBinding.bind(view);
        fun setListener(faltas:Cursor, posicion:Int){
            binding.root.setOnClickListener(){
                listener.pulsacionCorta(faltas, posicion);
            }
        }
    }
}
