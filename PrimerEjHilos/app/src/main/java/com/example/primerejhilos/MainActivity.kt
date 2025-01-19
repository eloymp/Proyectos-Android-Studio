package com.example.primerejhilos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var corriendo = false
    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val tv: TextView = findViewById(R.id.textView)
        val btnIniciar: Button = findViewById(R.id.btnIniciar)
        val btnPausar: Button = findViewById(R.id.btnPausar)
        val btnReiniciar: Button = findViewById(R.id.btnReiniciar)

        //Hilo
        Thread {
            while (true) {
                if (corriendo) {
                    runOnUiThread { tv.text = "Contador = "+ contador }
                    contador++
                    Thread.sleep(1000)
                }
            }
        }.start()

        //Botones
        btnIniciar.setOnClickListener {
            corriendo = true
        }

        btnPausar.setOnClickListener {
            corriendo = false
        }

        btnReiniciar.setOnClickListener {
            corriendo = false
            contador = 0
            tv.text = "Contador = "+ contador
        }
    }
}

