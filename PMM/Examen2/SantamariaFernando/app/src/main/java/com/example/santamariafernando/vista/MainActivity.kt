package com.example.santamariafernando.vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.santamariafernando.R
import com.example.santamariafernando.databinding.ActivityMainBinding
import com.example.santamariafernando.vistamodelo.VistaModelo
import com.example.santamariafernando.vistamodelo.VistaModeloFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: VistaModelo

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentVerCategorias: VerCategoriasFragment
    private lateinit var fragmentVerProductos: VerProductosFragment
    private lateinit var fragmentManager: FragmentManager
    private lateinit var fragmentTransaction: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModelFactory = VistaModeloFactory(0)
        viewModel = ViewModelProvider(this, viewModelFactory).get(VistaModelo::class.java)
        fragmentManager = supportFragmentManager
        if (binding.viewData == null)
            launchFragment(savedInstanceState)
        else {
            launchFragmentTablet(savedInstanceState)
        }
    }

    private fun launchFragment(savedInstanceState: Bundle?) {
        val fragment = VerCategoriasFragment()
        fragmentTransaction = fragmentManager.beginTransaction()
        if (savedInstanceState == null) {
            fragmentTransaction.add(R.id.fragmentContainer, fragment)
        } else {
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        }
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun launchFragmentTablet(savedInstanceState: Bundle?) {
        fragmentVerCategorias = VerCategoriasFragment()
        fragmentVerProductos = VerProductosFragment()
        fragmentTransaction = fragmentManager.beginTransaction()
        if (savedInstanceState == null) {
            fragmentTransaction.add(R.id.viewData, fragmentVerCategorias)
            fragmentTransaction.add(R.id.editData, fragmentVerProductos)
        } else {
            fragmentTransaction.replace(R.id.viewData, fragmentVerCategorias)
            fragmentTransaction.replace(R.id.editData, fragmentVerProductos)
        }

        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun verProductos(){
        if(binding.viewData == null){
            val fragment = VerProductosFragment()
            fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}