package com.example.dicsantamariafernando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dicsantamariafernando.databinding.ActivityClienteBinding

class ClienteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityClienteBinding;
    private val listaClientes = mutableListOf<Cliente>(
        Cliente("12345678A", "Manolo Fernandez", "684763481", "manolo.fernandez@correprueba.com"),
        Cliente("87654321X", "Pedro García", "669817365", "pegarciaasociados@correprueba.com")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var datoExistente = false;
        lateinit var clienteModificar:Cliente
        var posicionCliente = 0
        val dni = intent.getStringExtra("dni")
        for (cliente in listaClientes) {
            if(cliente.dni == dni){
                posicionCliente = listaClientes.indexOf(cliente)
                clienteModificar = cliente
                datoExistente = true
                break
            }
        }

        comprobarFlag(datoExistente, clienteModificar)

        binding.btnGuardar.setOnClickListener {
            listaClientes[posicionCliente].email = binding.email.text.toString()
            listaClientes[posicionCliente].telefono = binding.telefono.text.toString()
            Toast.makeText(
                this, "Cambios realizados con éxito",
                Toast.LENGTH_SHORT
            )
                .show()
            rellenarValores(clienteModificar)
        }

        binding.btnCancelar.setOnClickListener {
            rellenarValores(clienteModificar)
        }

        binding.btnVolver.setOnClickListener{
            finish()
        }
    }

    private fun comprobarFlag(
        datoExistente: Boolean,
        clienteModificar: Cliente
    ) {
        if (datoExistente) {
            rellenarValores(clienteModificar)
        } else {
            Toast.makeText(
                this, R.string.clientNotFound,
                Toast.LENGTH_SHORT
            )
                .show()
            finish()
        }
    }

    private fun rellenarValores(clienteModificar: Cliente) {
        binding.dni.setText(clienteModificar.dni)
        binding.nombre.setText(clienteModificar.nombre)
        binding.telefono.setText(clienteModificar.telefono)
        binding.email.setText(clienteModificar.email)
    }
}