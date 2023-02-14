package com.example.santamariafernando.vistamodelo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.santamariafernando.R
import com.example.santamariafernando.databinding.ItemProductoBinding
import com.example.santamariafernando.modelo.DBQueries
import com.example.santamariafernando.modelo.Producto

class AdaptadorProductos(
    private var productos: MutableList<Producto>,
    private var listener: EventosListener

) : RecyclerView.Adapter<AdaptadorProductos.ViewHolder>() {

    private lateinit var contexto: Context
    private lateinit var db: DBQueries

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemProductoBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        contexto = parent.context
        db = DBQueries(contexto)
        val view = LayoutInflater.from(contexto).inflate(R.layout.item_producto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = productos.get(position)
        with(holder) {
            binding.productName.text = producto.denominacion
            binding.price.text = producto.precio.toString()
            Glide.with(contexto)
                .load(producto.imagen)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.catImg)
        }

    }

    override fun getItemCount(): Int = productos.size


    fun setProductos(productos: MutableList<Producto>) {
        this.productos = productos
        notifyDataSetChanged()
    }
}