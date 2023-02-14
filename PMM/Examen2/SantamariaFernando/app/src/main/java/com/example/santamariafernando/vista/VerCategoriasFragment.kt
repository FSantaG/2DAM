package com.example.santamariafernando.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.santamariafernando.R
import com.example.santamariafernando.databinding.FragmentVerCategoriasBinding
import com.example.santamariafernando.modelo.Categoria
import com.example.santamariafernando.modelo.DBQueries
import com.example.santamariafernando.vistamodelo.AdaptadorCategorias
import com.example.santamariafernando.vistamodelo.EventosListener
import com.example.santamariafernando.vistamodelo.VistaModelo
import com.example.santamariafernando.vistamodelo.VistaModeloFactory

class VerCategoriasFragment: Fragment(), EventosListener {
    private lateinit var adaptador: AdaptadorCategorias
    private lateinit var linearLayout: LinearLayoutManager
    private lateinit var db: DBQueries
    private lateinit var mBinding: FragmentVerCategoriasBinding
    private var mActivity: MainActivity? = null
    private lateinit var categorias: MutableList<Categoria>
    private lateinit var modelo: VistaModelo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentVerCategoriasBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpActionBar()
        db = DBQueries(mActivity!!.applicationContext)
        configurarRecycler()
    }



    private fun setUpActionBar() {

        mActivity = activity as? MainActivity
        val viewModelFactory= VistaModeloFactory(0)

        modelo = ViewModelProvider(this.requireActivity(),viewModelFactory).get(VistaModelo::class.java)

    }

    private fun configurarRecycler() {
        adaptador = AdaptadorCategorias(mutableListOf(), this)
        linearLayout = LinearLayoutManager(mActivity!!.applicationContext)
        getAllCategories()
        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayout
            adapter = adaptador
        }
    }

    private fun getAllCategories() {
        consultaCorrutinas()
    }

    private fun consultaCorrutinas() {
        categorias = db.getAllCategories()
        adaptador.setCategorias(categorias)

    }


    /**
     * Eventos listener
     */

    override fun verProductos(codCategoria: Int?) {
        if (codCategoria != null) {
            modelo.setIdentificador(codCategoria)
            mActivity!!.verProductos()
        }
    }

}