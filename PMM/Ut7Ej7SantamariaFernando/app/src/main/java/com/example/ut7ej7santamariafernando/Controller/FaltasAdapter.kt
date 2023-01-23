package com.example.ut7ej7santamariafernando.Controller

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ut7ej7santamariafernando.Model.Faltas
import com.example.ut7ej7santamariafernando.R
import com.example.ut7ej7santamariafernando.databinding.ListaAlumnosBinding

class FaltasAdapter(private val faltas:List<Faltas>, private val listener: Eventos): RecyclerView.Adapter<FaltasAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.lista_alumnos) //TODO: Probar por qué da error esto
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.alumno.text = faltas.get(position).nombre
            binding.codAlumno.text = faltas.get(position).codigo.toString()

            setListener(alumnos.get(position), position)
        }
    }
    override fun getItemCount(): Int = faltas.size;

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ListaAlumnosBinding.bind(view);
        fun setListener(faltas:Faltas, posicion:Int){
            binding.root.setOnClickListener(){
                listener.pulsacionCorta(faltas, posicion);
            }
        }
    }
}
