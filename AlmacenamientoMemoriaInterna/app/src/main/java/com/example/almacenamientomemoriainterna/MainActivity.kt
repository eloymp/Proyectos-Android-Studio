package com.example.almacenamientomemoriainterna

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {
    private lateinit var boton1: Button
    private lateinit var boton2: Button
    private lateinit var et1: EditText
    private lateinit var et2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton1 = findViewById(R.id.boton1)
        boton2 = findViewById(R.id.boton2)
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        boton1.setOnClickListener {
            val nomarchivo = et1.text.toString().replace('/', '-')
            try {
                val archivo = OutputStreamWriter(openFileOutput(nomarchivo, Activity.MODE_PRIVATE))
                archivo.write(et2.text.toString())
                archivo.flush()
                archivo.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            Toast.makeText(this,"Los datos han sido grabados",Toast.LENGTH_SHORT).show()
            et1.text.clear()
            et2.text.clear()
        }

        boton2.setOnClickListener {
            val nomarchivo = et1.text.toString().replace('/', '-')
            if (fileList().contains(nomarchivo)) {
                try {
                    val archivo = InputStreamReader(openFileInput(nomarchivo))
                    val br = BufferedReader(archivo)
                    var linea = br.readLine()
                    val todo = StringBuilder()
                    while (linea != null) {
                        todo.append(linea+"\n")
                        linea = br.readLine()
                    }
                    br.close()
                    archivo.close()
                    et2.setText(todo)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            } else {
                Toast.makeText(this, "No hay datos grabados para dicha fecha", Toast.LENGTH_LONG).show()
                et2.setText("")
            }
        }
    }
}
