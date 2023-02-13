package com.example.ej9santamariafernandobd.vista

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ej9santamariafernandobd.R
import com.example.ej9santamariafernandobd.databinding.FragmentAddTarjetasBinding
import com.example.ej9santamariafernandobd.modelo.DBQueries
import com.example.ej9santamariafernandobd.modelo.Usuarios
import com.example.ej9santamariafernandobd.vistamodelo.VistaModelo
import com.example.ej9santamariafernandobd.vistamodelo.VistaModeloFactory
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout


class AddTarjetasFragment : Fragment() {
    private lateinit var mBinding: FragmentAddTarjetasBinding
    private var mActivity: MainActivity? = null
    private lateinit var db: DBQueries
    private lateinit var modelo: VistaModelo


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAddTarjetasBinding.inflate(inflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity = activity as? MainActivity
        val viewModelFactory= VistaModeloFactory("")

        modelo = ViewModelProvider(this.requireActivity(),viewModelFactory).get(VistaModelo::class.java)
        db = DBQueries(mActivity!!.applicationContext)

        val id = modelo.identificador.value

        mBinding.btnGuardar.setOnClickListener{
            val numAfiliado = mBinding.txtNumAfiliado.text.toString()
            val nombre = mBinding.txtNombreCompleto.text.toString()
            if(numAfiliado.isEmpty() || nombre.isEmpty()){
                Snackbar.make(mBinding.root, "Por favor, no deje campos vacíos", Snackbar.LENGTH_SHORT).setAnchorView(mBinding.btnGuardar).show()
            }else{
                val usuarioNuevo = Usuarios(numAfiliado, nombre)
                db.addUsuario(usuarioNuevo)
                Snackbar.make(mBinding.root, "Usuario Agregado Correctamente", Snackbar.LENGTH_SHORT).setAnchorView(mBinding.btnGuardar).show()
            }
        }


    }

}