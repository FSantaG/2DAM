package com.example.e5mdsantamariafernando

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.e5mdsantamariafernando.databinding.EspecialidadesBinding

class EspecialidadAdapter(private val especialidades:List<Especialidad>, private val listener:Eventos): RecyclerView.Adapter<EspecialidadAdapter.ViewHolder>() {

    private lateinit var context: Context;

    //SIEMPRE SE HACE ESTO
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context; //Dónde se infla esto
        val view = LayoutInflater.from(context).inflate(R.layout.especialidades, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.specializationName.text = especialidades[position].nombre;
            binding.specialityVacancy.text = "Plazas: ${especialidades[position].numPlazas.toString()}";
            binding.specializationId.text = especialidades[position].code;
            setListener(especialidades[position], position);
        }
    }
    override fun getItemCount(): Int = especialidades.size;

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = EspecialidadesBinding.bind(view);
        fun setListener(especialidad:Especialidad, posicion:Int){
            binding.root.setOnLongClickListener(){
                listener.pulsacionLarga(posicion)
            }
        }
    }
}