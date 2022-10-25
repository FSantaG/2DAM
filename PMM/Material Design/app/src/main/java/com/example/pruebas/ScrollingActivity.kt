package com.example.pruebas

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
    }


}