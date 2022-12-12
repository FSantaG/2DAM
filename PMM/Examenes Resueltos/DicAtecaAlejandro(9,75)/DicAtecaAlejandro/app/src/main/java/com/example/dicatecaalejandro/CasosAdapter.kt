package com.example.dicatecaalejandro

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicatecaalejandro.databinding.ActivityItemCasosBinding

class CasosAdapter(private val casos: List<Caso>, private val listener: Eventos): RecyclerView.Adapter<CasosAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ActivityItemCasosBinding.bind(view)
        fun setListener(caso: Caso, pos: Int){

            binding.root.setOnClickListener{
                listener.pulsacionCorta(caso, pos)
            }
            binding.root.setOnLongClickListener {
                listener.pulsacionLarga(pos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.activity_item_casos, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val caso = casos.get(position)
        with(holder) {
            binding.Code.text = caso.codigo
            binding.dni.text = caso.dniCliente
            binding.Denominacion.text = caso.denominacion
            if(caso.estado){
                binding.fondo.setBackgroundColor(Color.WHITE)
            } else {
                binding.fondo.setBackgroundColor(Color.RED)
            }
            setListener(caso, position)
        }
    }

    override fun getItemCount(): Int = casos.size
}