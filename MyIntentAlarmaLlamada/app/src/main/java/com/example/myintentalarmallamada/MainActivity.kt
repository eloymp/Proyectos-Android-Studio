package com.example.myintentalarmallamada

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Declaración de variables para cada elemento de la interfaz
    private val etMensaje: EditText by lazy { findViewById(R.id.etMensaje) }
    private val etHora: EditText by lazy { findViewById(R.id.etHora) }
    private val etMinutos: EditText by lazy { findViewById(R.id.etMinutos) }
    private val etNumero: EditText by lazy { findViewById(R.id.etNumero) }
    private val buttonAlarma: Button by lazy { findViewById(R.id.buttonAlarma) }
    private val buttonLlamar: Button by lazy { findViewById(R.id.buttonLlamar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configuración del evento onClick para establecer una alarma
        buttonAlarma.setOnClickListener {
            val mensaje = etMensaje.text.toString()
            val hora = etHora.text.toString().toIntOrNull()
            val minutos = etMinutos.text.toString().toIntOrNull()

            if (hora != null && minutos != null) {
                createAlarm(mensaje, hora, minutos)
            } else {
                Toast.makeText(this, "Introduce una hora y minutos válidos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configuración del evento onClick para realizar una llamada
        buttonLlamar.setOnClickListener {
            val numero = etNumero.text.toString()
            hacerLlamada(numero)
        }
    }

    // Función para crear una alarma
    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        Toast.makeText(this, "Por aqui",Toast.LENGTH_SHORT).show()

        //if (intent.resolveActivity(packageManager) != null) {
            Toast.makeText(this, "Por aqui 2",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        //}
    }

    // Función para realizar una llamada
    private fun hacerLlamada(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = android.net.Uri.parse("tel:$phoneNumber")
        }
        //if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        //}
    }
}