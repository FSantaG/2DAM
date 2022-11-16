package com.example.e1mdsantamariafernando

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.e1mdsantamariafernando.databinding.ActivityAutorBinding
import com.example.e1mdsantamariafernando.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var failedLogin = 0;
    //Mover esto abajo
    private lateinit var superUser:Usuario;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater);
        setContentView(binding.root)

        superUser = intent.getParcelableExtra<Usuario>("usuario")!!;

        binding.btnLogin.setOnClickListener{
            var user = binding.txtUser.text.toString();
            var pass = binding.txtPass.text.toString();

            if(user == superUser?.nomUsuario){
                if(pass == superUser?.pass){
                    val nombre = superUser?.nombre;
                    Toast.makeText(applicationContext, getString(R.string.welcome) + nombre, Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    failedLogin++;
                    if(failedLogin >= 3){
                        Toast.makeText(applicationContext, getString(R.string.shutdownMessage), Toast.LENGTH_LONG).show();
                        finishAffinity(); //Cierra la aplicación
                    }else {
                        Toast.makeText(
                            applicationContext,
                            getString(R.string.failedLogin) + "\n Quedan " + (3-failedLogin).toString() + " intentos",
                            Toast.LENGTH_LONG
                        ).show();
                    }
                }
            }else{
                failedLogin++;
                if(failedLogin >= 3){
                    Toast.makeText(applicationContext, getString(R.string.shutdownMessage), Toast.LENGTH_LONG).show();
                    finishAffinity(); //Cierra la aplicación
                }else {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.failedLogin) + "\n Quedan " + (3-failedLogin).toString() + " intentos",
                        Toast.LENGTH_LONG
                    ).show();
                }
            }



        }
    }
}