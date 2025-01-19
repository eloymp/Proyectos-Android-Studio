package com.example.fragmentos2

import android.os.Bundle
import android.widget.Button
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

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        button1.setOnClickListener{
            val transaccion=supportFragmentManager.beginTransaction()
            val fragmento=FragmentoAzul()
            transaccion.replace(R.id.Contenedor, fragmento)
            transaccion.addToBackStack(null)
            transaccion.commit()
        }
        button2.setOnClickListener{
            val transaccion=supportFragmentManager.beginTransaction()
            val fragmento=FragmentoNaranja()
            transaccion.replace(R.id.Contenedor, fragmento)
            transaccion.addToBackStack(null)
            transaccion.commit()
        }
        button3.setOnClickListener{
            val transaccion=supportFragmentManager.beginTransaction()
            val fragmento=FragmentoRosa()
            transaccion.replace(R.id.Contenedor, fragmento)
            transaccion.addToBackStack(null)
            transaccion.commit()
        }

    }
}