package com.example.broadcastmodoavion


import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var reciver: ModoAvion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configuración de EdgeToEdge (si lo necesitas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicialización del BroadcastReceiver
        reciver = ModoAvion()

        // Registramos el receptor para escuchar cambios en el modo avión
        val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(reciver, filter)
    }

    override fun onStop() {
        super.onStop()
        // Desregistramos el receptor cuando la actividad se detiene
        unregisterReceiver(reciver)
    }
}
