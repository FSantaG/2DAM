package com.example.dicatecaalejandro

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicatecaalejandro.databinding.ActivityVisualizarCasoBinding
import com.google.android.material.snackbar.Snackbar

class VisualizarCaso : AppCompatActivity() {
    var dni: String = ""
    var telf: String = ""
    var correo: String = ""
    private lateinit var binding: ActivityVisualizarCasoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVisualizarCasoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cliente = intent.getParcelableExtra<Cliente>("cliente")

        binding.txtDni.text = cliente!!.dni
        binding.txtNombre.text = cliente.nombre
        binding.txtTelf.setText(cliente.telf)
        binding.txtEmail.setText(cliente.correo)

        binding.btnCancelar.setOnClickListener {
            binding.txtTelf.setText(cliente.telf)
            binding.txtEmail.setText(cliente.correo)
        }
        binding.btnGuardar.setOnClickListener {
            guardar()
        }
        binding.btnVolver.setOnClickListener {

            val intentResult: Intent = Intent().apply{
                putExtra("dni", dni)
                putExtra("telf", telf)
                putExtra("correo", correo)
            }
            setResult(Activity.RESULT_OK, intentResult)
            finish()
        }

    }

    private fun guardar() {
        dni = binding.txtDni.text.toString()
        telf = binding.txtTelf.text.toString()
        correo = binding.txtEmail.text.toString()

        Snackbar.make(
            binding.root,
            "Datos guardados con éxito",
            Snackbar.LENGTH_SHORT
        )
            .setAnchorView(binding.btnGuardar).show()
    }
}