package com.example.radiobuttonsumaresta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de las vistas
        val checkBoxSuma= findViewById<CheckBox>(R.id.checkBox)
        val checkBoxResta = findViewById<CheckBox>(R.id.checkBox2)
        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val buttonOperar = findViewById<Button>(R.id.button)
        val textViewResultado = findViewById<TextView>(R.id.textView)

        // Configurar el listener para el botón Operar
        buttonOperar.setOnClickListener {

            val number1 = editTextNumber1.text.toString().toDoubleOrNull() ?: 0.0
            val number2 = editTextNumber2.text.toString().toDoubleOrNull() ?: 0.0

            var resultadoTexto = ""


            if (checkBoxSuma.isChecked && checkBoxResta.isChecked) {
                val suma = number1 + number2
                val resta = number1 - number2
                resultadoTexto = "Resultado suma: " +suma+ " Resultado resta: "+ resta
            } else if (checkBoxSuma.isChecked) {
                val suma = number1 + number2
                resultadoTexto = "Resultado suma: $suma"
            } else if (checkBoxResta.isChecked) {
                val resta = number1 - number2
                resultadoTexto = "Resultado resta: $resta"
            } else {
                resultadoTexto = "Seleccione al menos una operación"
            }

            textViewResultado.text = resultadoTexto
            
        }
    }
}