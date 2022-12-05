package com.example.dicsantamariafernando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicsantamariafernando.databinding.ActivityCasosBinding

class CasosActivity : AppCompatActivity(), Eventos {
    private lateinit var binding:ActivityCasosBinding
    private lateinit var linearLayout:LinearLayoutManager
    private var rol = 0;

    private var listaCasos = mutableListOf<Caso>(
        Caso("157A", "Caso 1", "05/12/2022", "Caso de Prueba", "12345678A", false),
        Caso("245F", "Caso 2", "05/12/2022", "Caso de Prueba 2", "12345678A", true),
        Caso("361X", "Caso 3", "05/12/2022", "Caso de Prueba 3", "87654321X", false)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCasosBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.recyclerview.adapter = CasosAdapter(listaCasos, this);
        linearLayout = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = linearLayout;
        binding.recyclerview.setHasFixedSize(true);

        rol = intent.getIntExtra("rol", 1);
    }

    override fun pulsacionCorta(caso: Caso, posicion: Int) {
        val intent = Intent(this, ClienteActivity::class.java)
        intent.putExtra("dni", caso.dniCliente)
        startActivity(intent)
    }

    override fun pulsacionLarga(posicion: Int):Boolean {
        if(rol == 1) {
            if(!listaCasos[posicion].estado){
                listaCasos[posicion].estado = true;
                Toast.makeText(this, R.string.caseEstateChanged, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, R.string.caseAlreadyClosed, Toast.LENGTH_SHORT).show()
            }
        }
        return true;
    }
}

