package com.example.e1mdsantamariafernando

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.e1mdsantamariafernando.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var failedLogin = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater);
        setContentView(binding.root)

        var users = mapOf("sa" to "1234", "usuario1" to "password1", "usuario2" to "password2");

        binding.btnLogin.setOnClickListener{
            var flag = false;
            var username = ""
            val user = binding.txtUser.text.toString();
            var pass = binding.txtPass.text.toString();

            users.forEach{registeredUser ->
                if(user == registeredUser.key){
                    if(pass == registeredUser.value) {
                        flag = true;
                        username = registeredUser.key;
                    }
                }
            }

            if(flag){
                val intent = Intent(this, WelcomeActivity::class.java);
                intent.putExtra("username", username.toString());
                startActivity(intent);
            }else{
                failedLogin++;
                if(failedLogin >= 3){
                    Toast.makeText(applicationContext, getString(R.string.shutdownMessage), Toast.LENGTH_LONG).show();
                    finish(); //Cierra la aplicación
                    System.exit(0) //Cierra la aplicación por completo
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