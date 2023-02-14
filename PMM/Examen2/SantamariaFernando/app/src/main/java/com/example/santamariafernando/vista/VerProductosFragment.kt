package com.example.santamariafernando.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.santamariafernando.R
import com.example.santamariafernando.databinding.FragmentVerProductosBinding
import com.example.santamariafernando.modelo.DBQueries
import com.example.santamariafernando.modelo.Producto
import com.example.santamariafernando.vistamodelo.AdaptadorProductos
import com.example.santamariafernando.vistamodelo.EventosListener
import com.example.santamariafernando.vistamodelo.VistaModelo
import com.example.santamariafernando.vistamodelo.VistaModeloFactory

class VerProductosFragment : Fragment(), EventosListener {
    private lateinit var adaptador: AdaptadorProductos
    private lateinit var linearLayout: LinearLayoutManager
    private lateinit var db: DBQueries
    private lateinit var mBinding: FragmentVerProductosBinding
    private var mActivity: MainActivity? = null
    private lateinit var citas: MutableList<Producto>
    private lateinit var modelo: VistaModelo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentVerProductosBinding.inflate(inflater, container, false)
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
        adaptador = AdaptadorProductos(mutableListOf(), this)
        linearLayout = LinearLayoutManager(mActivity!!.applicationContext)
        getAllCitas()
        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayout
            adapter = adaptador
        }
    }

    private fun getAllCitas() {

        consultaCorrutinas()
    }

    private fun consultaCorrutinas() {
        val numCategoria = modelo.identificador.value
        citas = db.getAllProductos(numCategoria.toString())
        adaptador.setProductos(citas)

    }

    override fun verProductos(idCategoria: Int?) {

    }
}