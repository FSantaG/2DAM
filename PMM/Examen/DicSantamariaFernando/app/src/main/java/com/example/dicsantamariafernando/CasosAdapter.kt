package com.example.dicsantamariafernando

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicsantamariafernando.databinding.CasosDisponiblesBinding

class CasosAdapter(private val caso:List<Caso>, private val listener:Eventos): RecyclerView.Adapter<CasosAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.casos_disponibles, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.codigoCaso.text = caso.get(position).codigo
            binding.denominacion.text = caso.get(position).denominacion
            binding.dniCliente.text = caso.get(position).dniCliente
            if(caso.get(position).estado){
                binding.caso.setBackgroundColor(Color.RED)
            }else{
                binding.caso.setBackgroundColor(Color.GREEN)
            }

            setListener(caso.get(position), position)
        }
    }
    override fun getItemCount(): Int = caso.size;

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = CasosDisponiblesBinding.bind(view);
        fun setListener(caso:Caso, posicion:Int){
            binding.root.setOnClickListener(){
                listener.pulsacionCorta(caso, posicion);
            }
            binding.root.setOnLongClickListener(){
                listener.pulsacionLarga(posicion)
            }
        }
    }



}