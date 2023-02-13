package com.example.ej9santamariafernandobd.vistamodelo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ej9santamariafernandobd.R
import com.example.ej9santamariafernandobd.databinding.ItemCitasBinding
import com.example.ej9santamariafernandobd.modelo.Citas
import com.example.ej9santamariafernandobd.modelo.DBQueries

class AdaptadorCitas (
    private var citas: MutableList<Citas>,
    private var listener: EventosListener

) : RecyclerView.Adapter<AdaptadorCitas.ViewHolder>() {

    private lateinit var contexto: Context
    private lateinit var db:DBQueries

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCitasBinding.bind(view)

        fun setListener(citas: Citas) {

            with(binding.root) {
                setOnClickListener { listener.verCitas(citas.numAfiliado) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        db = DBQueries(contexto)
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_citas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cita = citas.get(position)
        with(holder) {
            setListener(cita)
            binding.dateTime.text = cita.fecha + " a las " + cita.hora
            binding.type.text = "Presencial" //TODO: Añadir aquí campo
            binding.speciality.text = db.getTipoProfesional(cita.numColegiado)
        }

    }

    override fun getItemCount(): Int = citas.size


    fun setCitas(citas: MutableList<Citas>) {
        this.citas = citas
        notifyDataSetChanged()
    }

}