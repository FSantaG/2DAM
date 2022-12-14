package com.mjpg.solicitudpermisos

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.mjpg.solicitudpermisos.databinding.ActivityMainBinding
import android.Manifest
import androidx.core.app.ActivityCompat


import android.content.pm.PackageManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog.Builder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val PERMISOLLAMADA= 234




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnWebpage.setOnClickListener {
            openNav()
        }



        binding.btnCallphone.setOnClickListener {
            //Para teléfonos antiguos
            callOldTelephone()
        }



        binding.btnCallphone2.setOnClickListener {
            //Para teléfonos nuevos
            callNewTelephone()
        }


        }

    private fun callNewTelephone() {
        when {
            ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED -> {
                val intent = Intent(
                    Intent.ACTION_CALL,
                    Uri.parse("tel:965555555")
                )
                startActivity(intent)
            }

            shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE) -> {
                Snackbar.make(
                    binding.rootlayout, "POR CONTRATO Este permiso es peligroso" +
                            "y es para poder llamar por teléfono",
                    Snackbar.LENGTH_LONG
                ).show()

                val builder = Builder(this@MainActivity)
                builder.setTitle("Permiso para llamar")
                builder.setMessage("Puede resultar interesante indicar porqué.")

                builder.setPositiveButton(android.R.string.ok) { _, _ ->
                    Snackbar.make(
                        binding.rootlayout,
                        "Se acepta y se vuelve a pedir permiso",
                        Snackbar.LENGTH_LONG
                    ).show()


                    requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE)

                }
                builder.setNeutralButton(android.R.string.cancel, null)
                builder.show()
            }
            else -> {

                requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE)
            }
        }
    }

    private fun callOldTelephone() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {

            //Informa que el permiso no está concedido (No obligatorio)
            Snackbar.make(
                binding.rootlayout,
                "No está concedido el permiso para llamar",
                Snackbar.LENGTH_LONG
            ).show()

            //Si es la primera vez que muestra el mensaje, sólo muestra el mensaje.
            //Si no, explica los motivos por los que se requiere el permiso
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this, Manifest.permission.CALL_PHONE
                )
            ) {

                Snackbar.make(
                    binding.rootlayout, "Este permiso es peligroso " +
                            "y es para poder llamar por teléfono...............",
                    Snackbar.LENGTH_LONG
                ).show()
                val builder = Builder(this)
                builder.setTitle("Permiso para llamar")
                builder.setMessage("Puede resultar interesante indicar porqué.")


                builder.setPositiveButton(android.R.string.ok) { _, _ ->
                    Snackbar.make(
                        binding.rootlayout,
                        "Se acepta y se vuelve a pedir permiso",
                        Snackbar.LENGTH_LONG
                    ).show()
                    //Pide el permiso al usuario para que lo acepte o lo cancele
                    ActivityCompat.requestPermissions(
                        this, arrayOf(Manifest.permission.CALL_PHONE),
                        PERMISOLLAMADA
                    )
                }

                builder.setNeutralButton(android.R.string.cancel, null)
                builder.show()
            } else {


                Snackbar.make(
                    binding.rootlayout, "No se da una explicación.",
                    Snackbar.LENGTH_LONG
                ).show()
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.CALL_PHONE),
                    PERMISOLLAMADA
                )
            }
        } else {
            Snackbar.make(
                binding.rootlayout, "El permiso ya está concedido.",
                Snackbar.LENGTH_LONG
            ).show()

            val intent = Intent(
                Intent.ACTION_CALL,
                Uri.parse("tel:965555555")
            )
            startActivity(intent)
        }
    }

    private fun openNav() {
        val intent = Intent(
            //Abre el navegador
            Intent.ACTION_VIEW,
            //Interpretador de una página web. Parsea a formato URI
            Uri.parse("https://developer.android.com/")
        )
        //Comprueba si existe o no una aplicación que permita abrir webs
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Snackbar.make(
                binding.rootlayout,
                " No se encuentra un navegador",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }


    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)

            when (requestCode) {
               PERMISOLLAMADA -> {
                    Log.d("DEBUG", "${grantResults[0]} ${permissions[0]}")
                    if ((grantResults.isNotEmpty() && grantResults[0]
                                == PackageManager.PERMISSION_GRANTED)
                    ) {
                        Snackbar.make(
                            binding.rootlayout, " Permiso concedido",
                            Snackbar.LENGTH_LONG
                        ).show()

                    } else {
                        Snackbar.make(
                            binding.rootlayout, " Permiso rechazado",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                    return
                }
                else -> {
                    Snackbar.make(
                        binding.rootlayout, "Se pasa de los permisos.",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                Snackbar.make(
                    binding.rootlayout, " Permiso concedido",
                    Snackbar.LENGTH_LONG
                ).show()
                val intent = Intent(
                    Intent.ACTION_CALL,
                    Uri.parse("tel:965555555")
                )
                startActivity(intent)

            } else {
                Snackbar.make(
                    binding.rootlayout, " Permiso  no concedido",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

}