package com.example.e5mdsantamariafernando

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.e5mdsantamariafernando.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegistroBinding;
    private val registeredUsers = mutableListOf<String>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener{
            calling()
        }

        binding.btnCreateRequest.setOnClickListener{
            val dni = binding.txtDni.text.toString();
            if(checkValues()) {
                registerUser(dni)
            }
        }

        binding.btnCancelRequest.setOnClickListener{
            finish()
        }

        binding.btnCloseApp.setOnClickListener{
            System.exit(0)
        }

    }



    val resultActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        val data: Intent? = result.data
        if(result.resultCode == Activity.RESULT_OK) {
            val cadena = data?.getStringExtra("code")
            binding.txtCode.setText(data?.getStringExtra("code"))
        }
    }

    private fun calling(){
        val intent = Intent(this, InformacionActivity::class.java)
        resultActivity.launch(intent)
    }

    private fun checkValues(): Boolean {
        var flag = true
        if(binding.txtDni.text.toString() == ""){
            binding.txtDni.error = "Valor obligatorio"
            flag = false
        }else if(binding.txtFullName.text.toString() == ""){
            binding.txtFullName.error = "Valor obligatorio"
            flag = false
        }else if(binding.txtYear.text.toString() == ""){
            binding.txtYear.error = "Valor obligatorio"
            flag = false
        }else if(binding.txtCode.text.toString() == ""){
            binding.txtCode.error = "Valor obligatorio"
            flag = false
        }
        return flag
    }
    private fun registerUser(dni: String) {
        if (!registeredUsers.contains(dni)) {
            registeredUsers.add(dni)
            Toast.makeText(this, R.string.registeredUser, Toast.LENGTH_SHORT).show()
            resetValues();
        } else {
            Toast.makeText(this, R.string.registeredUserError, Toast.LENGTH_SHORT).show()
        }
    }

    private fun resetValues(){
        binding.txtDni.setText("")
        binding.txtCode.setText("")
        binding.txtYear.setText("")
        binding.txtFullName.setText("")
    }

}