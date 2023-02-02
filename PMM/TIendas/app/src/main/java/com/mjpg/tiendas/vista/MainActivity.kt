package com.mjpg.tiendas.vista


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mjpg.tiendas.*
import com.mjpg.tiendas.databinding.ActivityMainBinding
import com.mjpg.tiendas.interfaces.Comunicar

class MainActivity : AppCompatActivity(), Comunicar {

    private lateinit var binding: ActivityMainBinding

private lateinit var fragmentEditar: EditStoreFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Aunque se esté usando distintos activity_main.xml, el propio programa
        //interpretará qué layout usar según las características del móvil
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (binding.fragmentLista == null)
            launchFragment(savedInstanceState)
        else{
            // tablet
        fragmentEditar = EditStoreFragment()
            val args = Bundle()
            args.putLong(getString(R.string.arg_id),-1)
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fragmentdetalle, fragmentEditar)
                 fragmentTransaction.addToBackStack(null)
                   fragmentTransaction.commit()


        }
    }

    private fun launchFragment(savedInstanceState: Bundle?) {
        val fragment = Consulta()//Se pone el nombre del fragment que se va a usar
        val fragmentManager = supportFragmentManager //Gestor de fragmentos en Android
        val fragmentTransaction = fragmentManager.beginTransaction() //PAra trabajar con fragmentos de mi activity en este momento
        if (savedInstanceState == null) {
            fragmentTransaction.add(R.id.frag_contenedor, fragment)//Se introduce el lugar donde se va a colocar el fragmento
        } else {
            fragmentTransaction.replace(R.id.frag_contenedor, fragment)
        }
        fragmentTransaction.addToBackStack(null) //Elimina parcialmente la utilidad del botón de retroceder del móvil, permitiendo que no se cierre la activity al pulsarlo
        fragmentTransaction.commit()
    }

    override fun editar(id: Long) {
        val fragmentManager = supportFragmentManager
        val args = Bundle()
        args.putLong(getString(R.string.arg_id), id)
        val fragment = EditStoreFragment()
        fragment.arguments = args
        if (binding.fragmentdetalle == null) {
            val fragmentTransaction = fragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.frag_contenedor, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        else{
            fragmentEditar.cambio(id)
        }
    }

    override fun anadir() {
        val args = Bundle()
        args.putLong(getString(R.string.arg_id), -1)

        val fragmentManager = supportFragmentManager
        val fragment = EditStoreFragment()
        fragment.arguments = args
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (binding.fragmentdetalle == null) {
            fragmentTransaction.replace(R.id.frag_contenedor, fragment)
        } else {
            fragmentTransaction.replace(R.id.fragmentdetalle, fragment)
        }
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}