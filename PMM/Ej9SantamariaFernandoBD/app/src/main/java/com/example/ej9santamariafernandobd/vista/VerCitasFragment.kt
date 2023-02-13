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
import com.example.ej9santamariafernandobd.databinding.FragmentVerCitasBinding
import com.example.ej9santamariafernandobd.modelo.Citas
import com.example.ej9santamariafernandobd.modelo.DBQueries
import com.example.ej9santamariafernandobd.vistamodelo.*

class VerCitasFragment : Fragment(), EventosListener {
        private lateinit var adaptador: AdaptadorCitas
        private lateinit var gridLayout: GridLayoutManager
        private lateinit var db: DBQueries
        private lateinit var mBinding: FragmentVerCitasBinding
        private var mActivity: MainActivity? = null
        private lateinit var citas: MutableList<Citas>
        private lateinit var modelo: VistaModelo

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            mBinding = FragmentVerCitasBinding.inflate(inflater, container, false)
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
            mActivity?.addCita()
        }
    }

    private fun configurarRecycler() {
        adaptador = AdaptadorCitas(mutableListOf(), this)
        gridLayout = GridLayoutManager(mActivity!!.applicationContext, 2)
        getAllCitas()
        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = gridLayout
            adapter = adaptador
        }
    }

    private fun getAllCitas() {

        consultaCorrutinas()
    }

    private fun consultaCorrutinas() {
        val numAfiliacion = modelo.identificador.value

        citas = db.getCitas(numAfiliacion.toString())

        adaptador.setCitas(citas)

    }

    override fun verCitas(numAfiliado: String) {

    }
}