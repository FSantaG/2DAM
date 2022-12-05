package com.example.e5mdsantamariafernando

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e5mdsantamariafernando.databinding.ActivityInformacionBinding

class InformacionActivity : AppCompatActivity(), Eventos {
    private lateinit var binding: ActivityInformacionBinding;
    private lateinit var linearLayout: LinearLayoutManager;
    private var specialityList = listOf<Especialidad>(
        Especialidad("189A", "Alergología", 50),
        Especialidad("392X", "Anestesiología", 100),
        Especialidad("268V", "Angiología", 150),
        Especialidad("175L", "Cardiología", 75),
        Especialidad("847S", "Endocrinología", 30),
        Especialidad("455F", "Estomatología", 42),
        Especialidad("155E", "Farmacología Clínica", 60),
        Especialidad("893E", "Gastroenterología", 100),
        Especialidad("876L", "Genética", 550),
        Especialidad("748C", "Geriatría", 21),
        Especialidad("470Q", "Hematología", 5),
        Especialidad("097V", "Hepatología", 76),
        Especialidad("462A","Infectología", 80),
        Especialidad("439K", "Medicina aeroespacial", 70),
        Especialidad("426K", "Medicina del deporte", 98),
        Especialidad("235N", "Medicina familiar y comunitaria", 59),
        Especialidad("745C", "Medicina física y rehabilitación", 67),
        Especialidad("470L", "Medicina forense", 69),
        Especialidad("621A","Medicina intensiva", 10),
        Especialidad("965F", "Medicina interna", 7),
        Especialidad("397Z", "Medicina preventiva y salud pública", 65),
        Especialidad("222Y", "Medicina del trabajo", 55),
        Especialidad("683P", "Nefrología", 97),
        Especialidad("912P", "Neumología", 67),
        Especialidad("313Y", "Neurología", 80),
        Especialidad("468X", "Nutriología", 89),
        Especialidad("918G", "Oncología médica", 58),
        Especialidad("111N", "Oncología radioterápica", 60),
        Especialidad("826Y", "Pediatría", 33),
        Especialidad("457K", "Psiquiatría", 54),
        Especialidad("824Z", "Reumatología", 20),
        Especialidad("600G", "Toxicología", 3)
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
        var specialityCode:Intent = Intent();
        specialityCode.putExtra("code", specialityList[posicion].code.toString())
        setResult(Activity.RESULT_OK, specialityCode)
        finish();
        return true;
    }
}