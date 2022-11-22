package com.example.e3mdsantamariafernando

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
import com.example.e3mdsantamariafernando.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var primeNumbersList = mutableMapOf<Int, Int>(1 to 2);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.output.requestFocus();

        binding.btnSearch.setOnClickListener {
            var errorMsg:String? = null;
            val inputText = binding.searchValue.text.toString();
            if(isNumber(inputText) && inputText.toInt() > 0){
                errorMsg = null;
                val primeNumber:Int = findPrimeDigit(inputText.toInt());
                binding.output.text = getString(R.string.msgOutputPt1) + inputText + getString(R.string.msgOutputPt2) + primeNumber;
            }else if(inputText.toInt() == 0){
                errorMsg = getString(R.string.moreThanZero);
            }
            else{
                errorMsg = getString(R.string.notNumberError);
            }
            binding.searchValue.error = errorMsg;
        }

    }


    /**
     * Comprueba si una cadena de texto introducida es un número o no
     * @param s Resultado a comprobar
     * @return Resultado de la comprobación
     */
    fun isNumber(s: String): Boolean {
        return try {
            s.toInt()
            true
        } catch (ex: NumberFormatException) {
            false
        }
    }

    /**
     *Encuentra el número primo de la posición dada por el usuario
     * @param position Posición del número primo a buscas
     * @return El número primo buscado
     */
    private fun findPrimeDigit(position:Int):Int {
        //¿Se ha encotnrado el primo situado en la posición dada
        var positionGivenPrimeFound = false;
        //¿Es primo?
        var isPrime:Boolean = true;
        //Posible número primo
        var possiblePM:Int;
        //Contador de primos
        var counter:Int;
        //Número Primo devuelto
        var primeNumber:Int = 1;
        if(primeNumbersList.containsKey(position)){
            primeNumber = primeNumbersList[position]!!;
        }else {
            counter = primeNumbersList.size;
            possiblePM = primeNumbersList[primeNumbersList.size]!!;
            possiblePM ++;
            while (!positionGivenPrimeFound) {
                isPrime = true;
                for (i in 2..possiblePM / 2) {
                    if (possiblePM % i == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    counter++;
                    primeNumbersList.put(counter, possiblePM);
                    if (counter == position) {
                        primeNumber = possiblePM;
                        positionGivenPrimeFound = true;
                    }
                }
                possiblePM++;
            }
        }
        return primeNumber;
    }
}