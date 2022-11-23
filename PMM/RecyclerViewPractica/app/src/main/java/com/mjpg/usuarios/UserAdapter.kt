package com.mjpg.usuarios

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mjpg.usuarios.databinding.ItemUsersAltBinding

class UserAdapter(private val usuarios:List<Usuario>, private val listener:Eventos): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var context: Context;

    //SIEMPRE SE HACE ESTO
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context; //Dónde se infla esto
        val view = LayoutInflater.from(context).inflate(R.layout.item_users_alt, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.tvName.text = usuarios.get(position).nombre;
            binding.tvOrder.text = usuarios.get(position).id.toString();
            setListener(usuarios.get(position), position);
            Glide.with(context)
                .load(usuarios.get(position).ruta)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgPhoto)
            }
        }
    override fun getItemCount(): Int = usuarios.size;

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
            val binding = ItemUsersAltBinding.bind(view);
            fun setListener(usuario:Usuario, posicion:Int){
                binding.root.setOnClickListener(){
                    listener.pulsacionCorta(usuario, posicion);
                }
                binding.root.setOnLongClickListener(){
                    listener.pulsacionLarga(posicion)
                }
            }
        }



    }
