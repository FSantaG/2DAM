package com.example.ej9santamariafernandobd.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ej9santamariafernandobd.R
import com.example.ej9santamariafernandobd.databinding.FragmentVerTarjetasBinding
import com.example.ej9santamariafernandobd.modelo.DBQueries
import com.example.ej9santamariafernandobd.modelo.Usuarios
import com.example.ej9santamariafernandobd.vistamodelo.AdaptadorTarjetas
import com.example.ej9santamariafernandobd.vistamodelo.EventosListener
import com.example.ej9santamariafernandobd.vistamodelo.VistaModelo
import com.example.ej9santamariafernandobd.vistamodelo.VistaModeloFactory


class VerTarjetasFragment: Fragment(), EventosListener {
    private lateinit var adaptador: AdaptadorTarjetas
    private lateinit var gridLayout: GridLayoutManager
    private lateinit var db: DBQueries
    private lateinit var mBinding: FragmentVerTarjetasBinding
    private var mActivity: MainActivity? = null
    private lateinit var tarjetas: MutableList<Usuarios>
    private lateinit var modelo: VistaModelo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentVerTarjetasBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpActionBar()
        db = DBQueries(mActivity!!.applicationContext)
        configurarRecycler()
        val observador2= Observer<String> {
            if( it.equals("")){
                configurarRecycler()
            }

        }
        modelo.identificador.observe(this.viewLifecycleOwner, observador2)
    }



    private fun setUpActionBar() {

        mActivity = activity as? MainActivity
        val viewModelFactory= VistaModeloFactory("")

        modelo = ViewModelProvider(this.requireActivity(),viewModelFactory).get(VistaModelo::class.java)
        mBinding.fab.setOnClickListener {
            modelo.setIdentificador("-1L")
            mActivity?.addTarjeta()
        }
    }

    private fun configurarRecycler() {
        adaptador = AdaptadorTarjetas(mutableListOf(), this)
        gridLayout = GridLayoutManager(mActivity!!.applicationContext, 2)
        getAllTiendas()
        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun getAllTiendas() {

        consultaCorrutinas()
    }

    private fun consultaCorrutinas() {

        tarjetas = db.getAllTarjetas()

        adaptador.setTarjetas(tarjetas)

    }


    /**
     * Eventos listener
     */

    override fun verCitas(numAfiliado: String) {
        modelo.setIdentificador(numAfiliado)
        mActivity!!.verCitas()
    }


}