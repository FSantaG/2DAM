package com.example.pruebas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebas.databinding.ActivitySegundaActividadBinding

class SegundaActividad : AppCompatActivity() {
    private lateinit var binding:ActivitySegundaActividadBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivitySegundaActividadBinding.inflate(layoutInflater);
        setContentView(binding.root)

        var URL = intent.getStringExtra("url");
        binding.texto.text = URL;

        val usuario = intent.getParcelableExtra<Usuario>("usuario");
        binding.btnAceptar.setOnClickListener(){
            var i:Intent = Intent();
            i.putExtra("nombre", "regreso");
            setResult(Activity.RESULT_OK, i);
            finish();
        }
        binding.btnCancelar.setOnClickListener(){
            setResult((Activity.RESULT_CANCELED));
            finish();
        }
    }
}