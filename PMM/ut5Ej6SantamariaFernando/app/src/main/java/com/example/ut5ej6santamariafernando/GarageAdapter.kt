package com.example.ut5ej6santamariafernando

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ut5ej6santamariafernando.databinding.ListaEncargosBinding

class GarageAdapter(private val coches:List<Coche>, private val listener:Eventos): RecyclerView.Adapter<GarageAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.lista_encargos, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.nombreCompleto.text = coches.get(position).obtenerNombreCompleto()
            binding.matricula.text = coches.get(position).matricula
            binding.modeloCoche.text = coches.get(position).modeloCoche
            binding.fechaEntrega.text = coches.get(position).fechaEntrega
            binding.dni.text = coches.get(position).dni
            if(coches.get(position).estado){
                binding.coche.setBackgroundColor(Color.GREEN)
            }else{
                binding.coche.setBackgroundColor(Color.RED)
            }

            setListener(coches.get(position), position)
        }
    }
    override fun getItemCount(): Int = coches.size;

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ListaEncargosBinding.bind(view);
        fun setListener(coches:Coche, posicion:Int){
            binding.root.setOnClickListener(){
                listener.pulsacionCorta(coches, posicion);
            }
            binding.root.setOnLongClickListener(){
                listener.pulsacionLarga(posicion)

            }
        }
    }
}