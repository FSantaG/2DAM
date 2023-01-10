package com.example.ut5ej6santamariafernando

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ut5ej6santamariafernando.databinding.ActivityAgregarCocheBinding
import com.google.android.material.snackbar.Snackbar

class AgregarCocheActivity : AppCompatActivity() {
    private lateinit var  binding:ActivityAgregarCocheBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAgregarCocheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {
            if(!checkNulls()){
                Snackbar.make(
                    binding.root,
                    "Por favor, no deje valores nulos",
                    Snackbar.LENGTH_SHORT)
                    .show()
            }else{
                val listaAComprobar = intent.getParcelableExtra<ListaCoches>("lista")
                if (listaAComprobar != null) {
                    if(!checkPlateNumber(listaAComprobar)){
                        generateNewCar()
                    }else{
                        binding.txtMatricula.setError("Matrícula ya usada en otra reserva")
                    }
                }

            }
        }

        binding.btnCancelar.setOnClickListener {
            val nuevaLista = Intent()
            setResult(Activity.RESULT_CANCELED, nuevaLista)
            finish()
        }
    }

    private fun checkPlateNumber(listaAComprobar:ListaCoches):Boolean{
        var flag = false
        for (coche in listaAComprobar.lista) {
            if (coche.matricula == binding.txtMatricula.text.toString()) {
                flag = true
            }
        }
        return flag
    }

    private fun generateNewCar() {
        val fecha = binding.txtDia.text.toString() + "/" +
                binding.txtMes.text.toString() + "/" +
                binding.txtAnno.text.toString()
        val nuevoCoche = Coche(
            binding.txtDNI.text.toString(),
            binding.txtNombre.text.toString(),
            binding.txtApellidos.text.toString(),
            binding.txtEmail.text.toString(),
            binding.txtMatricula.text.toString(),
            binding.txtModelo.text.toString(),
            fecha,
            binding.txtObservaciones.text.toString(),
            false
        )
        val cocheResult = Intent()
        cocheResult.putExtra("nuevoCoche", nuevoCoche)
        setResult(RESULT_OK, cocheResult)
        finish()
    }

    private fun checkNulls():Boolean{
        var flag = false
        if(binding.txtDNI.text.toString() != "" &&
            binding.txtEmail.text.toString() != "" &&
            binding.txtDia.text.toString() != "" &&
            binding.txtMes.text.toString() != "" &&
            binding.txtAnno.text.toString() != "" &&
            binding.txtModelo.text.toString() != "" &&
            binding.txtMatricula.text.toString() != "" &&
            binding.txtObservaciones.text.toString() != "" &&
            binding.txtNombre.text.toString() != "" &&
            binding.txtApellidos.text.toString() != ""){
            flag = true
        }
        return flag
    }
}