package com.mjpg.tiendas2fragmentosvistamodelo.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.mjpg.tiendas2fragmentosvistamodelo.R
import com.mjpg.tiendas2fragmentosvistamodelo.databinding.ActivityMainBinding
import com.mjpg.tiendas2fragmentosvistamodelo.vistamodelo.VistaModelo
import com.mjpg.tiendas2fragmentosvistamodelo.vistamodelo.VistaModeloFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: VistaModelo

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentEditar: EditStoreFragment
    private lateinit var fragmentConsulta: Consulta
    private lateinit var fragmentManager: FragmentManager
    private lateinit var fragmentTransaction: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModelFactory = VistaModeloFactory(0)
        viewModel = ViewModelProvider(this, viewModelFactory).get(VistaModelo::class.java)
        fragmentManager = supportFragmentManager
        if (binding.fragmentLista == null)
            launchFragment(savedInstanceState)
        else {
            launchFragmentTablet(savedInstanceState)
        }
    }

    private fun launchFragment(savedInstanceState: Bundle?) {
        val fragment = Consulta()
        fragmentTransaction = fragmentManager.beginTransaction()
        if (savedInstanceState == null) {
            fragmentTransaction.add(R.id.frag_contenedor, fragment)
        } else {
            fragmentTransaction.replace(R.id.frag_contenedor, fragment)
        }
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun launchFragmentTablet(savedInstanceState: Bundle?) {
        // tablet
        fragmentConsulta = Consulta()
        fragmentEditar = EditStoreFragment()
        fragmentTransaction = fragmentManager.beginTransaction()
        if (savedInstanceState == null) {
            fragmentTransaction.add(R.id.fragmentLista, fragmentConsulta)
            fragmentTransaction.add(R.id.fragmentdetalle, fragmentEditar)
        } else {
            fragmentTransaction.replace(R.id.fragmentLista, fragmentConsulta)
            fragmentTransaction.replace(R.id.fragmentdetalle, fragmentEditar)
        }

        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun editar() {
        if (binding.fragmentdetalle == null) {
            val fragment = EditStoreFragment()
            fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frag_contenedor, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }



}