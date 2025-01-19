package com.example.emp_lanzaeldado

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lanzarButton: Button = findViewById(R.id.lanzar_button)
        lanzarButton.setOnClickListener { lanzadado() }
    }
    private fun lanzadado() {
        Toast.makeText(this, "Boton pulsado",Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "Lanza dado!"
        val randomint=(1..6).random()
        resultText.text = randomint.toString()
    }
}