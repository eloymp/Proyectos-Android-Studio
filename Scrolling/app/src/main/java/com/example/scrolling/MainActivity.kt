package com.example.scrolling

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Asegúrate de que esta función está correctamente implementada.
        setContentView(R.layout.activity_main)

        // Ajustar los insets para las barras del sistema.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configuración del FloatingActionButton y BottomAppBar.
        val bflotante = findViewById<FloatingActionButton>(R.id.floating)
        val bNavegacion = findViewById<BottomAppBar>(R.id.barraNavegacion)

        bflotante.setOnClickListener {
            if (bNavegacion.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) {
                bNavegacion.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            } else {
                bNavegacion.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }
        bNavegacion.setNavigationOnClickListener{
            //Si quisieramos irnos a la anterior página con el botón pondríamos esta linea de código
            //onBackPressedDispatcher.onBackPressed()

            //Como no tenemos ninguna página anterior en el botón terminamos la actividad (Cerramos la aplicación)
            finishAffinity()
        }
    }

    // Método para inflar el menú.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // Método para manejar las selecciones del menú.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.configuracion -> {
                // Lógica para la opción "Configuración".
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}