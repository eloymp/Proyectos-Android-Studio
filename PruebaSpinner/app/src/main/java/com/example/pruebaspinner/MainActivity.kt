package com.example.pruebaspinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtResultado = findViewById<TextView>(R.id.txtView)
        val lista = findViewById<Spinner>(R.id.lista)
        val n1 = findViewById<EditText>(R.id.txtNumero1)
        val n2 = findViewById<EditText>(R.id.txtNumero2)

        val adaptador = ArrayAdapter.createFromResource(this, R.array.values_array, android.R.layout.simple_spinner_dropdown_item)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        lista.adapter = adaptador


        lista.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>) {
                txtResultado.text = "Selecciona una operación"
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val operacion = parent.getItemAtPosition(position).toString()

                val numero1 = n1.text.toString().toDoubleOrNull()
                val numero2 = n2.text.toString().toDoubleOrNull()

                if (numero1 == null || numero2 == null) {
                    txtResultado.text = "Escribe dos numeros"
                    return
                }

                val resultado = when (operacion) {
                    "Sumar" -> numero1 + numero2
                    "Restar" -> numero1 - numero2
                    "Multiplicar" -> numero1 * numero2
                    "Dividir" -> if (numero2 != 0.0)
                                numero1 / numero2
                                else "División por 0 no permitida"
                    else -> "Escriba un numero"
                }

                txtResultado.text = "Resultado: "+resultado
            }
        }
    }
}