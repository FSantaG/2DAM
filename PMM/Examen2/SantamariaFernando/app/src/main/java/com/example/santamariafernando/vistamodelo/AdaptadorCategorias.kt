package com.example.santamariafernando.vistamodelo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.santamariafernando.R
import com.example.santamariafernando.databinding.ItemCategoriaBinding
import com.example.santamariafernando.modelo.Categoria

class AdaptadorCategorias(
    private var categorias: MutableList<Categoria>,
    private var listener: EventosListener

    ) : RecyclerView.Adapter<AdaptadorCategorias.ViewHolder>() {

        private lateinit var contexto: Context


        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val binding = ItemCategoriaBinding.bind(view)

            fun setListener(categoria: Categoria) {

                with(binding.root) {
                    setOnClickListener { listener.verProductos(categoria.codigo) }
                }
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            contexto = parent.context
            val view = LayoutInflater.from(contexto).inflate(R.layout.item_categoria, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val categoria = categorias.get(position)
            with(holder) {
                setListener(categoria)
                binding.CategoryName.text = categoria.denominacion
                Glide.with(contexto)
                    .load(categoria.imagen)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.catImg)
            }

        }

        override fun getItemCount(): Int = categorias.size

    fun setCategorias(categorias: MutableList<Categoria>) {
        this.categorias = categorias
        notifyDataSetChanged()
    }
}