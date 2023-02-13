package com.example.ej9santamariafernandobd.vistamodelo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ej9santamariafernandobd.R
import com.example.ej9santamariafernandobd.databinding.ItemTarjetasBinding
import com.example.ej9santamariafernandobd.modelo.Usuarios

class AdaptadorTarjetas(
    private var usuarios: MutableList<Usuarios>,
    private var listener: EventosListener

) : RecyclerView.Adapter<AdaptadorTarjetas.ViewHolder>() {

    private lateinit var contexto: Context


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemTarjetasBinding.bind(view)

        fun setListener(usuarios: Usuarios) {

            with(binding.root) {
                setOnClickListener { listener.verCitas(usuarios.numAfiliado) }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_tarjetas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = usuarios.get(position)
        with(holder) {
            setListener(usuario)
            binding.userName.text = usuario.nombre
            binding.afiliationNumber.text = usuario.numAfiliado
        }

    }

    override fun getItemCount(): Int = usuarios.size


    fun setTarjetas(usuarios: MutableList<Usuarios>) {
        this.usuarios = usuarios
        notifyDataSetChanged()
    }



}