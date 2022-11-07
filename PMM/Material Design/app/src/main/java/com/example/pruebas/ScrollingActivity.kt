package com.example.pruebas

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.URLUtil
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pruebas.databinding.ActivityScrollingBinding
import com.google.android.material.bottomappbar.BottomAppBar

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.btnAdd.setOnClickListener {
            if (binding.barra.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_END) {
                binding.barra.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER;
            } else {
                binding.barra.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            }
            binding.barra.setNavigationOnClickListener {
                Snackbar.make(
                    binding.root,
                    getString(R.string.buttonContentDesc),
                    Snackbar.LENGTH_LONG
                ).setAnchorView(binding.btnAdd).setAction("Botón Acción") {
                    Toast.makeText(this, "Mensaje Toast", Toast.LENGTH_LONG).show()
                }.show();
            }
        };
        cargarImagen();
        binding.content.etUrl.setOnFocusChangeListener{ view, focus ->
            val url = binding.content.etUrl.text.toString();
            var error:String?=null;
            if(!focus){
                if(url.isEmpty()){
                    error = getString(R.string.espacioVacio);
                }else{
                    if(URLUtil.isValidUrl(url)){
                        cargarImagen(url);
                        error = null;
                    }else{
                        error = getString(R.string.direccion);
                    }
                }
                binding.content.etUrl.error = error;
                binding.content.titURL.error = error;
            }
        }
    }

    private fun cargarImagen(url:String="https://fs-prod-cdn.nintendo-europe.com/media/images/08_content_images/games_6/nintendo_switch_7/nswitch_kirbyandtheforgottenland/KirbyAndTheForgottenLand_Intro_SideImg_Kirby.png"){
        Glide.with(this)
            .load(url)
            //.centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)//ALL -> Guarda imagen real + modificada
            .into(binding.content.kirbymagen)
    }


}