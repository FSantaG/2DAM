package com.example.ut5ej6santamariafernando

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ut5ej6santamariafernando.databinding.ActivityGarajeBinding
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AlertDialog.Builder

class GarajeActivity : AppCompatActivity(), Eventos {

    private lateinit var binding:ActivityGarajeBinding
    private lateinit var linearLayout:LinearLayoutManager

    private lateinit var loggedUsuario:Usuario
    private var listaCoches = arrayListOf<Coche>(
        Coche("12345678X", "Manolo", "Pérez", "prueba@prueba.com", "1234XDD",
        "Seat Ibiza", "19/12/2022", "Coche de prueba", true),
        Coche("87654321X", "Pedro", "Gómez", "prueba@prueba.com", "4321DGH",
            "Seat León", "19/12/2022", "Coche de prueba", false),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGarajeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerview.adapter = GarageAdapter(listaCoches, this);
        linearLayout = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = linearLayout
        binding.recyclerview.setHasFixedSize(true)

        loggedUsuario = intent.getParcelableExtra<Usuario>("usuarioIniciado")!!
        if(loggedUsuario.rol == 1){
            binding.btnCrearRegistro.visibility = View.VISIBLE
        }else{
            binding.btnCrearRegistro.visibility = View.INVISIBLE
        }

        binding.btnCrearRegistro.setOnClickListener {
            val intent = Intent(this, AgregarCocheActivity::class.java)
            intent.putExtra("lista", ListaCoches(listaCoches))
            resultActivity.launch(intent)
        }
    }

    val resultActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        val data: Intent? = result.data
        if(result.resultCode == Activity.RESULT_OK) {
            var nuevoCoche = data?.getParcelableExtra<Coche>("nuevoCoche")
            if (nuevoCoche != null) {
                listaCoches.add(nuevoCoche)
            }
            binding.recyclerview.adapter?.notifyDataSetChanged()
        }
    }

    override fun pulsacionCorta(coche: Coche, posicion: Int) {
        if(loggedUsuario.rol == 1){
            if(listaCoches[posicion].estado){
                listaCoches.removeAt(posicion)
                binding.recyclerview.adapter?.notifyDataSetChanged()
            }
        }
    }
    override fun pulsacionLarga(posicion: Int): Boolean {
        if(loggedUsuario.rol == 0 && listaCoches[posicion].estado == false){
            sendEmail(posicion)
        }
        return true
    }

    private fun sendEmail(posicion: Int) {
        val builder = Builder(this@GarajeActivity)
        builder.setTitle("¿Está seguro?")
        builder.setMessage(
            "Realizar esta operación mandará un correo al cliente.\n" +
                    "NO ES REVERSIBLE"
        )

        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            listaCoches[posicion].estado = true
            binding.recyclerview.adapter?.notifyDataSetChanged()
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, listaCoches[posicion].email)
                putExtra(Intent.EXTRA_SUBJECT, R.string.emailMessage)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
        builder.setNeutralButton(android.R.string.cancel, null)
        builder.show()
    }
}