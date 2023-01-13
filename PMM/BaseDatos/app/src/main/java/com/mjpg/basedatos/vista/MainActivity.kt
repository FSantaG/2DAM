package com.mjpg.basedatos.vista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import com.google.android.material.snackbar.Snackbar

import com.mjpg.basedatos.dao.OperacionesDao
import com.mjpg.basedatos.databinding.ActivityMainBinding
import com.mjpg.basedatos.modelo.Usuario
import com.mjpg.enero23.datos.Puntos

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bd: OperacionesDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bd = OperacionesDao(this)
        // RELLENAR CON DATOS
        val tablaUsuariosVacia = bd.tablaVaciaUsuarios()
        if (tablaUsuariosVacia) {
            insertarDatosUsuarios()
        }
        val tablaPuntosVacia = bd.tablaVaciaPuntos()
        if (tablaPuntosVacia) {
            altaPuntos()
        }
        val tablaTiposVacia = bd.tablaVaciaTipos()
        if (tablaTiposVacia) {
            altaTipos()
        }

        binding.btIniciar.setOnClickListener {
            comprobar()

        }
    }


    private fun comprobar() {
        val loginIntroducido = binding.usuario.text.toString()
        val contrasenaIntroducida = binding.contra.text.toString()
        if (isEmpty(loginIntroducido) || isEmpty(contrasenaIntroducida)) {
            Snackbar.make(
                binding.root, "Los campos no pueden estar vacíos",
                Snackbar.LENGTH_LONG
            ).show()
        } else {
            val usuarioEncontrado = bd.getUsuario(loginIntroducido, contrasenaIntroducida)
            if (usuarioEncontrado == null) {
                Snackbar.make(
                    binding.root, "Usuario no encontrado",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val intent = Intent(this, Consulta::class.java)
                startActivity(intent)
            }
        }
    }

    private fun insertarDatosUsuarios() {
        val usuario1 =
            Usuario(
                login = "adri",
                contra = "1234"
            )
        val usuario2 =
            Usuario(
                login = "pepe",
                contra = "001"
            )
        Thread {
            bd.addUsuario(usuario1)
            bd.addUsuario(usuario2)
        }.start()
    }

    private fun altaPuntos() {
        Thread {
            bd.addPunto(
                Puntos(
                    "123", 1, "Hipercor , Burgos",
                    "Via sin nombre , 09001", "Burgos",
                    "Conector tipo 2",
                    "Frente a entrada izquierda de Hipercor junto a Burger King Coordenadas 42.318258, -3.703157",
                    "Gratuito"
                )
            )
            bd.addPunto(
                Puntos(
                    "456", 4, "Mc-Donals Gamonal",
                    "205 Carretera Madrid-Irún 09007", "madrid",
                    "Conector tipo 2, Conector Tipo 1",
                    "Un punto a cada lado del parking. (Cubierto / descubierto)",
                    "Según tarifas JuicePass"
                )
            )
            bd.addPunto(
                Puntos(
                    "789", 3, "Parking, Plaza Mayor",
                    "8 Plaza de la Libertad 09004", "Burgos",
                    "Conector tipo 2",
                    "Descargar app EDP Move On",
                    "0,39 €/kw y penalización de tiempo extra de 0,05€/min"
                )
            )
        }.start()
    }

    private fun altaTipos(){
        Thread {
        bd.addTipo("Centro Comercial")
            bd.addTipo("Superficie")
            bd.addTipo("Parking")
            bd.addTipo( "Restaurante")
        }.start()

    }

}