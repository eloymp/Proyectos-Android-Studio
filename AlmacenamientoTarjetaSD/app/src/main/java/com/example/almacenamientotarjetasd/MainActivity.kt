package com.example.almacenamientotarjetasd

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
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
            try{
                val tarjeta=baseContext.getExternalFilesDir(null)?.absolutePath
                ///storage/emulated/0/Android/data/com.example.almacenamientotarjetasd/files
                val file=File(tarjeta,et1.text.toString())
                val osw=OutputStreamWriter(FileOutputStream(file))
                osw.write(et2.text.toString())
                osw.flush()
                osw.close()
                Toast.makeText(this, "Los datos fueron grabados correctamente", Toast.LENGTH_SHORT).show()
                et1.setText("")
                et2.setText("")

            }catch(ioe:IOException){
                Toast.makeText(this, "No se pudo grabar", Toast.LENGTH_SHORT).show()
            }
        }

        boton2.setOnClickListener {
            val tarjeta = baseContext.getExternalFilesDir(null)?.absolutePath
            val file=File(tarjeta,et1.text.toString())
            try{
                val fIn = FileInputStream(file)
                val archivo = InputStreamReader(fIn)
                val br = BufferedReader(archivo)
                var linea=br.readLine()
                val todo=StringBuilder()
                while(linea!=null){
                    todo.append(linea+"\n")
                    linea=br.readLine()
                }
                br.close()
                archivo.close()
                et2.setText(todo)
            }catch(e:IOException){
                Toast.makeText(this, "No se pudo leer", Toast.LENGTH_SHORT).show()
            }
        }
    }
}