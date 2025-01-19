package com.example.ejemplomenu

import android.widget.Toast
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val message = when (item.itemId) {
            R.id.subitem1 -> "Lunes seleccionado"
            R.id.subitem2 -> "Martes seleccionado"
            R.id.subitem3 -> "Miércoles seleccionado"
            R.id.subitem4 -> "Jueves seleccionado"
            R.id.subitem5 -> "Viernes seleccionado"
            R.id.subitem6 -> "Sábado seleccionado"
            R.id.subitem7 -> "Domingo seleccionado"

            R.id.subitem8 -> "Enero seleccionado"
            R.id.subitem9 -> "Febrero seleccionado"
            R.id.subitem10 -> "Marzo seleccionado"
            R.id.subitem11 -> "Abril seleccionado"
            R.id.subitem12 -> "Mayo seleccionado"
            R.id.subitem13 -> "Junio seleccionado"
            R.id.subitem14 -> "Julio seleccionado"
            R.id.subitem15 -> "Agosto seleccionado"
            R.id.subitem16 -> "Septiembre seleccionado"
            R.id.subitem17 -> "Octubre seleccionado"
            R.id.subitem18 -> "Noviembre seleccionado"
            R.id.subitem19 -> "Diciembre seleccionado"
            else -> return super.onOptionsItemSelected(item)
        }

        // Muestra el mensaje Toast
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        return true
    }
}