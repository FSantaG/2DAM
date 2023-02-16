package com.example.ej9santamariafernandobd.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.ej9santamariafernandobd.R
import com.example.ej9santamariafernandobd.databinding.FragmentAddCitasBinding
import com.example.ej9santamariafernandobd.databinding.FragmentAddTarjetasBinding
import com.example.ej9santamariafernandobd.modelo.DBQueries
import com.example.ej9santamariafernandobd.modelo.Usuarios
import com.example.ej9santamariafernandobd.vistamodelo.VistaModelo
import com.example.ej9santamariafernandobd.vistamodelo.VistaModeloFactory
import com.google.android.material.snackbar.Snackbar


class AddCitasFragment : Fragment() {
    private lateinit var mBinding: FragmentAddCitasBinding
    private var mActivity: MainActivity? = null
    private lateinit var db: DBQueries
    private lateinit var modelo: VistaModelo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentAddCitasBinding.inflate(inflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity = activity as? MainActivity
        val viewModelFactory= VistaModeloFactory("")

        modelo = ViewModelProvider(this.requireActivity(),viewModelFactory).get(VistaModelo::class.java)
        db = DBQueries(mActivity!!.applicationContext)

        val id = modelo.identificador.value

        mBinding.txtNumAfiliado.setText(id)

        val profesionalesRaw = resources.getStringArray(R.array.profesionales)
        var profesionalProcesado:List<String>
        var nombreProfesional = mutableListOf<String>()
        for(profesional in profesionalesRaw){
            profesionalProcesado = profesional.split("*")
            nombreProfesional.add(profesionalProcesado[1])
        }
        // access the spinner
        val spinner = mBinding.profesionales
        if (spinner != null) {
            val adapter = ArrayAdapter(
                requireActivity().getApplicationContext(), +
                android.R.layout.simple_spinner_item, nombreProfesional
            )
            spinner.adapter = adapter
        }
            /*mBinding.btnGuardar.setOnClickListener{
            val numAfiliado = mBinding.txtNumAfiliado.text.toString()
            val nombre = mBinding.txtNombreCompleto.text.toString()
            if(numAfiliado.isEmpty() || nombre.isEmpty()){
                Snackbar.make(mBinding.root, "Por favor, no deje campos vacíos", Snackbar.LENGTH_SHORT).show()
            }else{
                val usuarioNuevo = Usuarios(numAfiliado, nombre)
                db.addUsuario(usuarioNuevo)
                Snackbar.make(mBinding.root, "Usuario Agregado Correctamente", Snackbar.LENGTH_SHORT).show()
            }
        }*/

    }
}