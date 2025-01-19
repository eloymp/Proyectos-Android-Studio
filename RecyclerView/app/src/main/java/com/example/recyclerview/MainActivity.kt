package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adaptador: AdapterAnimal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ajustar los insets para evitar solapamiento con las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configuración del RecyclerView
        val rvAnimales = findViewById<RecyclerView>(R.id.rvAnimales)
        rvAnimales.setHasFixedSize(true) // Optimización para listas de tamaño fijo
        rvAnimales.layoutManager = LinearLayoutManager(this)

        // Configuración del adaptador
        adaptador = AdapterAnimal(crearListaAnimales(), this)  // Cambié adapterAnimal por AdapterAnimal
        rvAnimales.adapter = adaptador
    }

    // Función para crear una lista de ejemplo de animales
    private fun crearListaAnimales(): MutableList<Animal> {
        return mutableListOf(
            Animal("Perro", "Perro", R.drawable.perro),
            Animal("Tigre", "Tigre", R.drawable.tigre),
            Animal("Zorro", "Zorro", R.drawable.zorro),
            Animal("Gato", "Gato", R.drawable.gato),
            Animal("mapache", "mapache", R.drawable.mapache),
            Animal("cisne", "cisne", R.drawable.cisne),
            Animal("gorrion", "gorrion", R.drawable.gorrion),
            Animal("erizo", "erizo", R.drawable.erizo),
            Animal("oveja", "oveja", R.drawable.oveja),


            )
    }
}
