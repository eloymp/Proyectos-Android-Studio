package com.example.firebase2425

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore
class MainActivity : AppCompatActivity() {

    private lateinit var edId : EditText
    private lateinit var edNombre : EditText
        private lateinit var edEmail : EditText

    //findViewById<EditText>(R.id.editTextText)

    private lateinit var tvConsulta : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val db : FirebaseFirestore = FirebaseFirestore.getInstance()
        var btnGuardar = findViewById<Button>(R.id.button)
        var btnConsultar = findViewById<Button>(R.id.button2)
        var btnModificar = findViewById<Button>(R.id.button3)
        var btnBorrar = findViewById<Button>(R.id.button4)

        edId = findViewById<EditText>(R.id.editTextText)
        edNombre = findViewById<EditText>(R.id.editTextText2)
        edEmail = findViewById<EditText>(R.id.editTextText3)

        tvConsulta = findViewById<TextView>(R.id.textView)

        btnConsultar.setOnClickListener{
            var datos = ""
            //Abrir la conexión con la base de datos amigos
            db.collection("amigos")
                //Obtener los datos
                .get()
                //Listener para cuando todo haya ido bien
                .addOnSuccessListener {
                    //Si ha ido bien recibimos una variable con el resultado
                    //Para cada documento que haya en resultado leemos todos sus datos asociados
                    //Los guardamos en una cadena y la cadena se vuelva en TextView
                        resultado ->
                    for(documento in resultado){
                        datos += "${documento.id} : ${documento.data}"
                    }
                    tvConsulta.text = datos
                }
                .addOnFailureListener{ exception ->
                    tvConsulta.text = "No se ha podido conectar a la bd."
                }
        }

        btnGuardar.setOnClickListener{
            guardarDatos(db)
        }
        btnModificar.setOnClickListener{
            guardarDatos(db)
        }
        btnBorrar.setOnClickListener{
            if(edId.text.isNotBlank()){
                db.collection("amigos")
                    .document(edId.text.toString())
                    .delete()
                    .addOnSuccessListener { _ ->
                        tvConsulta.text = "Borrado correctamente."
                    }
                    .addOnFailureListener{ _ ->
                        tvConsulta.text = "No se ha podido borrar."
                    }
            }
        }
    }

    private fun guardarDatos (db : FirebaseFirestore){
        //Comprobar si los datos están vacíos
        if(edNombre.text.isNotBlank() && edEmail.text.isNotBlank() && edId.text.isNotBlank()){
            //Preparar dato
            val dato = hashMapOf(
                "nombre" to edNombre.text.toString(),
                "email" to edEmail.text.toString()
            )
            //añadimos los datos
            db.collection("amigos")
                //Añadimos la clave al documento
                .document(edId.text.toString())
                //Añadimos el resto de datos
                .set(dato)
                .addOnSuccessListener { _ -> tvConsulta.text = "Añadido correctamente." }
                .addOnFailureListener{ _ -> tvConsulta.text = "No se ha podido añadir."}
        }
    }
}