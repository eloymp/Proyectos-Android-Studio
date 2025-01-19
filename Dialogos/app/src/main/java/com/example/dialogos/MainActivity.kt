package com.example.dialogos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

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
        val cal = Calendar.getInstance()
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("Algo ha ido mal. ¿Deseas reintentar?")
            builder.setPositiveButton(android.R.string.ok) { _, _ ->
                Toast.makeText(this, "Has aceptado", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("Cancelar", null)
            builder.setNeutralButton("Recordar mas tarde", null)
            builder.show()
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val listenerFecha = DatePickerDialog.OnDateSetListener { _, anyo, mes, dia ->
                Toast.makeText(
                    this,
                    "$dia/${mes + 1}/$anyo",
                    Toast.LENGTH_LONG
                ).show()
            }
            DatePickerDialog(
                this,
                listenerFecha,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        val button3 = findViewById<Button>(R.id.button3)

        button3.setOnClickListener {
            val listenerHora = TimePickerDialog.OnTimeSetListener { _, hora, minutos ->
                Toast.makeText(
                    this,
                    "$hora:$minutos",
                    Toast.LENGTH_LONG
                ).show()
            }
            TimePickerDialog(
                this,
                listenerHora,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        val button4=findViewById<Button>(R.id.button4)
        button4.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Login")
            val inflater = layoutInflater
            builder.setView(inflater.inflate(R.layout.layout_dialogo, null))
            builder.setPositiveButton(android.R.string.ok){dialogo, _ ->
                val etNombre=(dialogo as AlertDialog).findViewById<EditText>(R.id.etNombre)
                val nombre = etNombre?.text.toString()
                Toast.makeText(this, "Hola $nombre", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("Cancelar", null)
            builder.setNeutralButton("Recordar mas tarde", null)
            builder.show()
        }

        val button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener {
            // Opciones que se mostrarán en el diálogo
            val opciones = arrayOf("Opción 1", "Opción 2", "Opción 3", "Opción 4") //Crea un array con esas 4 opciones

            // Crear el diálogo
            val builder = AlertDialog.Builder(this) //Crea un cuadro de dialogo
            builder.setTitle("Selecciona una opción")

            // Configurar las opciones de la lista
            builder.setItems(opciones) { _, which -> //asigna las opciones de la lista y maneja el clic de cada una de ellas
                // Recuperar la opción seleccionada
                val seleccion = opciones[which] //el indice which se usa para obtener la opcion correspondinete al array
                // Mostrar un mensaje con la opción seleccionada
                Toast.makeText(this, "Seleccionaste: $seleccion", Toast.LENGTH_SHORT).show()
            }

            // Agregar botón "Cancelar"
            builder.setNegativeButton("Cancelar", null) //boton cancelar

            // Mostrar el diálogo
            builder.show()
        }

    }
}