package com.example.serviciomusica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        val btnDetener = findViewById<Button>(R.id.btnDetener)

        btnIniciar.setOnClickListener {
            val intent = Intent(this, ServicioMusica::class.java)
            startService(intent)
        }

        btnDetener.setOnClickListener {
            val intent = Intent(this, ServicioMusica::class.java)
            stopService(intent)
        }
    }
}

