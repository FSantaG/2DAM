package com.example.e5mdsantamariafernando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e5mdsantamariafernando.databinding.ActivityInformacionBinding

class InformacionActivity : AppCompatActivity(), Eventos {
    private lateinit var binding: ActivityInformacionBinding;
    private lateinit var linearLayout: LinearLayoutManager;
    //TODO: Añadir el tercer valor a las especialidades
    private var specialityList = listOf<Especialidad>(
        Especialidad(1, "Alergología"),
        Especialidad(2, "Anestesiología"),
        Especialidad(3, "Angiología"),
        Especialidad(4, "Cardiología"),
        Especialidad(5, "Endocrinología"),
        Especialidad(6, "Estomatología"),
        Especialidad(7, "Farmacología Clínica"),
        Especialidad(8, "Gastroenterología"),
        Especialidad(9, "Genética"),
        Especialidad(10, "Geriatría"),
        Especialidad(11, "Hematología"),
        Especialidad(12, "Hepatología"),
        Especialidad(13, "Infectología"),
        Especialidad(14, "Medicina aeroespacial"),
        Especialidad(15, "Medicina del deporte"),
        Especialidad(16, "Medicina familiar y comunitaria"),
        Especialidad(17, "Medicina física y rehabilitación"),
        Especialidad(18, "Medicina forense"),
        Especialidad(19, "Medicina intensiva"),
        Especialidad(20, "Medicina interna"),
        Especialidad(21, "Medicina preventiva y salud pública"),
        Especialidad(22, "Medicina del trabajo"),
        Especialidad(23, "Nefrología"),
        Especialidad(24, "Neumología"),
        Especialidad(25, "Neurología"),
        Especialidad(26, "Nutriología"),
        Especialidad(27, "Oncología médica"),
        Especialidad(28, "Oncología radioterápica"),
        Especialidad(29, "Pediatría"),
        Especialidad(30, "Psiquiatría"),
        Especialidad(31, "Reumatología"),
        Especialidad(32, "Toxicología")
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacionBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.recyclerview.adapter = EspecialidadAdapter(specialityList, this);
        linearLayout = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = linearLayout;
        binding.recyclerview.setHasFixedSize(true);
    }

    override fun pulsacionLarga(posicion: Int):Boolean {
        val intent = Intent(this, RegistroActivity::class.java);
        intent.putExtra("code", posicion+1);
        startActivity(intent)
        return true;
    }
}