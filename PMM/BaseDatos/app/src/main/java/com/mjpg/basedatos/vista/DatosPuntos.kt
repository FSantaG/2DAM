package com.mjpg.basedatos.vista
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mjpg.basedatos.dao.OperacionesDao
import com.mjpg.basedatos.databinding.ActivityDatosPuntosBinding
import com.mjpg.enero23.datos.Puntos


class DatosPuntos : AppCompatActivity() {
    private lateinit var binding: ActivityDatosPuntosBinding
    private lateinit var bd: OperacionesDao
    private lateinit  var punto: Puntos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatosPuntosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bd = OperacionesDao(this)
        binding.btCancelar.setOnClickListener { limpiar() }
        binding.btRegresar.setOnClickListener { regresar() }
        binding.btGuardar.setOnClickListener { guardar() }


    }

    private fun regresar() {

       finishAndRemoveTask()

    }

    override fun onBackPressed() {
        // super.onBackPressed()
        regresar()
    }

    private fun guardar() {
        val codigo = binding.txtCodigo.text.toString()
        val tipo = Integer.parseInt(binding.txtEstablecimiento.text.toString())
        val deno = binding.txtDenominacion.text.toString()
        val dire = binding.txtDireccion.text.toString()
        val prov = binding.txtDireccion.text.toString()
        val indicaciones = binding.txtIndicaciones.text.toString()
        val precio = binding.txtPrecio.text.toString()
        val cargador = binding.txtCargadores.text.toString()
        if (!bd.existePunto(codigo)) {

            if (bd.existeTipo(tipo)) {
                punto = Puntos(codigo, tipo, deno, dire, prov, cargador, indicaciones, precio)
                bd.addPunto(punto)
                limpiar()

            }
            else{
                Toast.makeText(this, " No existe el tipo de Establecimiento", Toast.LENGTH_LONG).show()
            }

        }
        else{
            Toast.makeText(this, " Codigo Duplicado", Toast.LENGTH_LONG).show()
        }


    }


    private fun limpiar() {
        with(binding) {
            txtCodigo.setText("")
            txtCargadores.setText("")
            txtDenominacion.setText("")
            txtDireccion.setText("")
            txtIndicaciones.setText("")
            txtEstablecimiento.setText("")
            txtProvincia.setText("")
            txtPrecio.setText("")


        }

    }
}



