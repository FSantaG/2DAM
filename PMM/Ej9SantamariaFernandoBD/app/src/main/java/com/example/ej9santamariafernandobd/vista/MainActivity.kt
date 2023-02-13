package com.example.ej9santamariafernandobd.vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.ej9santamariafernandobd.R
import com.example.ej9santamariafernandobd.databinding.ActivityMainBinding
import com.example.ej9santamariafernandobd.vistamodelo.VistaModelo
import com.example.ej9santamariafernandobd.vistamodelo.VistaModeloFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: VistaModelo

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentEditarCitas: AddTarjetasFragment
    private lateinit var fragmentVerTarjetas: VerTarjetasFragment
    private lateinit var fragmentManager: FragmentManager
    private lateinit var fragmentTransaction: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModelFactory = VistaModeloFactory("")
        viewModel = ViewModelProvider(this, viewModelFactory).get(VistaModelo::class.java)
        fragmentManager = supportFragmentManager
        if (binding.viewData == null)
            launchFragment(savedInstanceState)
        else {
            launchFragmentTablet(savedInstanceState)
        }
    }

    private fun launchFragment(savedInstanceState: Bundle?) {
        val fragment = VerTarjetasFragment()
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
        fragmentVerTarjetas = VerTarjetasFragment()
        fragmentEditarCitas = AddTarjetasFragment()
        fragmentTransaction = fragmentManager.beginTransaction()
        if (savedInstanceState == null) {
            fragmentTransaction.add(R.id.viewData, fragmentVerTarjetas)
            fragmentTransaction.add(R.id.editData, fragmentEditarCitas)
        } else {
            fragmentTransaction.replace(R.id.viewData, fragmentVerTarjetas)
            fragmentTransaction.replace(R.id.editData, fragmentEditarCitas)
        }

        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun addTarjeta() {
        if (binding.editData == null) {
            val fragment = AddTarjetasFragment()
            fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    fun addCita(){
        if (binding.editData == null) {
            val fragment = AddCitasFragment()
            fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    fun verCitas(){
        if(binding.viewData == null){
            val fragment = VerCitasFragment()
            fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }
}