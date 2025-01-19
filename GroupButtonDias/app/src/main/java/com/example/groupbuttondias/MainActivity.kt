package com.example.groupbuttondias

import android.os.Bundle

import android.widget.RadioButton
import android.widget.TextView
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioButtonLunes = findViewById<RadioButton>(R.id.radioButtonLunes)
        val radioButtonMartes = findViewById<RadioButton>(R.id.radioButtonMartes)
        val radioButtonMiercoles = findViewById<RadioButton>(R.id.radioButtonMiercoles)
        val radioButtonJueves = findViewById<RadioButton>(R.id.radioButtonJueves)
        val radioButtonViernes = findViewById<RadioButton>(R.id.radioButtonViernes)
        val radioButtonSabado = findViewById<RadioButton>(R.id.radioButtonSabado)
        val radioButtonDomingo = findViewById<RadioButton>(R.id.radioButtonDomingo)
        val textView = findViewById<TextView>(R.id.textView)
        val radioGroupDias = findViewById<RadioGroup>(R.id.radioGroup)

        radioGroupDias.setOnCheckedChangeListener { _, checkedId ->
            textView.text=when (checkedId) {
                R.id.radioButtonLunes -> "Pulsado Lunes"
                R.id.radioButtonMartes -> "Pulsado Martes"
                R.id.radioButtonMiercoles -> "Pulsado Miércoles"
                R.id.radioButtonJueves -> "Pulsado Jueves"
                R.id.radioButtonViernes -> "Pulsado Viernes"
                R.id.radioButtonSabado -> "Pulsado Sábado"
                R.id.radioButtonDomingo -> "Pulsado Domingo"
                else -> ""
            }

        }
            /*radioButtonLunes.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) textView.text = "Pulsado Lunes"
        }
        radioButtonMartes.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) textView.text = "Pulsado Martes"
        }
        radioButtonMiercoles.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) textView.text = "Pulsado Miércoles"
        }
        radioButtonJueves.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) textView.text = "Pulsado Jueves"
        }
        radioButtonViernes.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) textView.text = "Pulsado Viernes"
        }
        radioButtonSabado.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) textView.text = "Pulsado Sábado"
        }
        radioButtonDomingo.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) textView.text = "Pulsado Domingo"
        }*/

    }
}