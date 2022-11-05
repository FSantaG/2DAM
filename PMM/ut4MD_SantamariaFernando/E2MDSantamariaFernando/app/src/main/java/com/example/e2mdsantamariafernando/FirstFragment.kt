package com.example.e2mdsantamariafernando

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.e2mdsantamariafernando.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //Mantiene el primer dígito en memoria
    private var dig1: Int = 0;
    //Mantiene el segundo dígito en memoria
    private var dig2: Int = 0;
    //Mantiene el operador en memoria
    private var mathOperator: String = "";

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        //Aquí empiezan los eventos
        //números
        binding.btn0.setOnClickListener{
            checkEmpty("0");
        }
        binding.btn1.setOnClickListener{
            checkEmpty("1");
        }
        binding.btn2.setOnClickListener{
            checkEmpty("2");
        }
        binding.btn3.setOnClickListener{
            checkEmpty("3");
        }
        binding.btn4.setOnClickListener{
            checkEmpty("4");
        }
        binding.btn5.setOnClickListener{
            checkEmpty("5");
        }
        binding.btn6.setOnClickListener{
            checkEmpty("6");
        }
        binding.btn7.setOnClickListener{
            checkEmpty("7");
        }
        binding.btn8.setOnClickListener{
            checkEmpty("8");
        }
        binding.btn9.setOnClickListener{
            checkEmpty("9");
        }
        //Operadores

        binding.btnPlus.setOnClickListener {
            if(dig1 == 0){
                dig1 = binding.calc.text.toString().toInt();
            }else{
                dig2  = binding.calc.text.toString().toInt();
                dig1 = dig1 + dig2;
            }
            binding.calc.text = "0";
            mathOperator = "+";
        }
        binding.btnMinus.setOnClickListener {
            if(dig1 == 0){
                dig1 = binding.calc.text.toString().toInt();
            }else{
                dig2  = binding.calc.text.toString().toInt();
                dig1 = dig1 - dig2;
            }
            binding.calc.text = "0";
            mathOperator = "-";
        }
        binding.btnMultiply.setOnClickListener {
            if(dig1 == 0){
                dig1 = binding.calc.text.toString().toInt();
            }else{
                dig2  = binding.calc.text.toString().toInt();
                dig1 = dig1 * dig2;
            }
            binding.calc.text = "0";
            mathOperator = "×";
        }
        binding.btnDivide.setOnClickListener {
            if(dig1 == 0){
                dig1 = binding.calc.text.toString().toInt();
            }else{
                dig2  = binding.calc.text.toString().toInt();
                dig1 = dig1 / dig2;
            }
            binding.calc.text = "0";
            mathOperator = "÷";
        }
        binding.btnEquals.setOnClickListener{
            dig2  = binding.calc.text.toString().toInt();
            when(mathOperator){
                "+" -> binding.calc.text = (dig1 + dig2).toString();
                "-" -> binding.calc.text = (dig1 - dig2).toString();
                "×" -> binding.calc.text = (dig1 * dig2).toString();
                "÷" -> binding.calc.text = (dig1 / dig2).toString();
            }
        }

        //Botón AC (Poner a 0)
        binding.btnReset.setOnClickListener{
            setToZero();
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Comprueba si se han introducido dígitos diferentes a cero para incrementar el número.
     */
    fun checkEmpty(valor: String){
        if(binding.calc.text == "0"){
            binding.calc.text = valor;
        }else{
            var tmp = binding.calc.text.toString() + valor;
            binding.calc.text = tmp;
        }
    }

    /**
     * Establece el dígito mostrado a 0, y borra las operaciones realizadas
     */
    fun setToZero(){
        binding.calc.text = "0";
        mathOperator = "";
        dig1 = 0;
        dig2 = 0;
    }
}