package com.example.dicatecaalejandro

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicatecaalejandro.databinding.ActivityCasosBinding

class Casos : AppCompatActivity(), Eventos {
    private var casos = mutableListOf(
        Caso("1", "Caso1", "25-12-2022", "caso dificil", "12345678A", true),
        Caso("2", "Caso2", "25-12-2022", "caso facil", "12345678A", true),
        Caso("3", "Caso3", "25-12-2022", "asesinato", "987654321B", true),
        Caso("4", "Caso4", "25-12-2022", "suicidio", "987654321B", true),
        Caso("5", "Caso5", "25-12-2022", "robo", "75395146C", true),
        Caso("6", "Caso6", "25-12-2022", "fallecimiento", "75395146C", true),
        Caso("7", "Caso7", "25-12-2022", "divorcio", "12378965D", true),
        Caso("8", "Caso8", "25-12-2022", "despido", "12378965D", true),
        Caso("9", "Caso9", "25-12-2022", "secuestro", "96374185E", true),
        Caso("10", "Caso10", "25-12-2022", "maltrato", "96374185E", true),
    )
    private var clientes = mutableListOf(
        Cliente("12345678A", "Mario", "156782428", "marioExaminado@gmail.com"),
        Cliente("987654321B", "María", "156782428", "maria.excursion@gmail.com"),
        Cliente("75395146C", "Josefino", "156782428", "josefinardo@gmail.com"),
        Cliente("12378965D", "Bartolomé", "156782428", "barto@gmail.com"),
        Cliente("96374185E", "Axel", "156782428", "axelBlaze@gmail.com"),
    )
    private lateinit var binding: ActivityCasosBinding
    private lateinit var linearLayout: LinearLayoutManager
    private var tipo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCasosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tipo = intent.getIntExtra("tipo", 0)
        cargarRecycler()
    }

    override fun pulsacionCorta(caso: Caso, pos: Int) {
        val user = clientes.indexOf(Cliente(caso.dniCliente))
        if (user != -1) {
            val cliente: Cliente = clientes[user]
            llamada(cliente)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun pulsacionLarga(pos: Int): Boolean {
        val caso = casos.get(pos)

        if (tipo == 1) {
            if(caso.estado) {
                caso.estado = false
                Toast.makeText(this, "El caso se ha cerrado", Toast.LENGTH_LONG).show()
                //cargarRecycler()
                binding.recyclerview.adapter?.notifyDataSetChanged()
            } else {
                mensajeToast("Este caso ya esta crrado")
            }
        }
        else {
            mensajeToast("No tienes permiso para realizar esta acción")
        }
        return true
    }

    private fun mensajeToast(mensaje: String) {
        Toast.makeText(
            this,
            mensaje,
            Toast.LENGTH_LONG
        )
            .show()
    }

    private fun cargarRecycler() {
        binding.recyclerview.adapter = CasosAdapter(casos, this)
        linearLayout = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = linearLayout
        binding.recyclerview.setHasFixedSize(true)
    }

    private fun llamada(cliente: Cliente) {
        val intent = Intent(this, VisualizarCaso::class.java)
        intent.putExtra("cliente", cliente)
        resultadoActividad.launch(intent)
    }

    private val resultadoActividad =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultado ->
            val datos: Intent? = resultado.data
            if (resultado.resultCode == Activity.RESULT_OK) {
                val dni2= datos?.getStringExtra("dni")
                val telf2 = datos?.getStringExtra("telf")
                val correo2 = datos?.getStringExtra("correo")

                val pos = clientes.indexOf(Cliente(dni2.toString()))
                if (pos != -1) {
                    val cliente = clientes[pos]
                    cliente.telf = telf2.toString()
                    cliente.correo = correo2.toString()
                }
            } else {
                Toast.makeText(this, "Se ha cancelado la actividad", Toast.LENGTH_LONG).show()
            }
        }


}


