package com.example.e1mdsantamariafernando

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.e1mdsantamariafernando.databinding.ActivityMainBinding
import com.example.e1mdsantamariafernando.databinding.FragmentFirstBinding
import com.example.e1mdsantamariafernando.databinding.FragmentSecondBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration;
    private lateinit var binding: ActivityMainBinding;
    private lateinit var bindingLogin: FragmentFirstBinding;
    private lateinit var bindingAuthor: FragmentSecondBinding;

    private var failedLogin: Int = 0;
    private var userCredential = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        bindingLogin = FragmentFirstBinding.inflate(layoutInflater)
        bindingAuthor = FragmentSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            setContentView(bindingLogin.root);
        }

        binding.btnCredits.setOnClickListener{
            setContentView(bindingAuthor.root);
        }

        bindingAuthor.btnBack.setOnClickListener{
            setContentView(binding.root);
        }

        bindingLogin.btnLogin.setOnClickListener{
            this.failedLogin++;
            if(this.failedLogin == 3){
                Toast.makeText(applicationContext, getString(R.string.shutdownMessage), Toast.LENGTH_LONG).show();
                finishAffinity(); //Cierra la aplicación
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}