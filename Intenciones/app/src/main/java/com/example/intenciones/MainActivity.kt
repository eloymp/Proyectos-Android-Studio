package com.example.intenciones

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
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

    // Función para compartir texto
    fun compartir(view: View) {
        startActivity(
            Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Mira al sitio que he encontrado https://educamosclm.castillalamancha.es/")
            }
        )
    }

    // Función para abrir una página web
    fun abrirPagina(view: View) {
        startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse("https://educamosclm.castillalamancha.es/"))
        )
    }

    // Función para llamar a un teléfono
    fun llamarTelefono(view: View) {
        startActivity(
            Intent(Intent.ACTION_DIAL, Uri.parse("tel:969231260"))
        )
    }

    // Función para abrir un mapa con coordenadas
    fun verMapa(view: View) {
        startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse("geo:40.07407173897146,-2.1433909909458895"))
        )
    }

    // Función para tomar una foto
    fun tomarFoto(view: View) {
        startActivity(
            Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        )
    }

    // Función para mandar un correo
    fun mandarCorreo(view: View) {
        startActivity(
            Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "asunto")
                putExtra(Intent.EXTRA_TEXT, "texto del correo")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("nombre@gmail.com"))
            }
        )
    }

    // Función para ver la vista de Street View
    fun streetView(view: View) {
        startActivity(
            Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll=40.07407173897146,-2.1433909909458895&cbp=0,250,0,0,0"))
        )
    }
}