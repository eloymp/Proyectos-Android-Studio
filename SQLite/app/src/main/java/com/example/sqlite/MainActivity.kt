package com.example.sqlite

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    lateinit var amigosDBHelper: MiSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        var edId = findViewById<EditText>(R.id.editTextText)
        var edNombre = findViewById<EditText>(R.id.editTextText2)
        var edEmail = findViewById<EditText>(R.id.editTextText3)
        var btnGuardar = findViewById<Button>(R.id.button)
        var btnConsultar = findViewById<Button>(R.id.button2)
        var btnModificar = findViewById<Button>(R.id.button3)
        var btnBorrar = findViewById<Button>(R.id.button4)
        var tvConsulta = findViewById<TextView>(R.id.textView)

        amigosDBHelper = MiSQLiteHelper(this)

        btnGuardar.setOnClickListener{
            if(edNombre.text.isNotBlank() && edEmail.text.isNotBlank()){
                amigosDBHelper.añadirDato(edNombre.text.toString(), edEmail.text.toString())
                edNombre.text.clear()
                edEmail.text.clear()
                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "No se ha podido guardar", Toast.LENGTH_LONG).show()
            }
        }
        btnConsultar.setOnClickListener{
            tvConsulta.text = ""
            val db:SQLiteDatabase=amigosDBHelper.readableDatabase
            val cursor=db.rawQuery("SELECT * FROM amigos",null)
            if(cursor.moveToFirst()){
                do{
                    tvConsulta.append(cursor.getInt(0).toString()+": ")
                    tvConsulta.append(cursor.getString(1).toString()+", ")
                    tvConsulta.append(cursor.getString(2).toString()+"\n")
                }while(cursor.moveToNext())
            }
            cursor.close()
        }

        btnBorrar.setOnClickListener{
            var cantidad=0

            if(edId.text.isNotBlank()){
                cantidad=amigosDBHelper.borrarDato(edId.text.toString().toInt())
                edId.text.clear()
                Toast.makeText(this, "Datos borrados: $cantidad", Toast.LENGTH_LONG).show()
            }

            tvConsulta.text = ""
            val db:SQLiteDatabase=amigosDBHelper.readableDatabase
            val cursor=db.rawQuery("SELECT * FROM amigos",null)
            if(cursor.moveToFirst()){
                do{
                    tvConsulta.append(cursor.getInt(0).toString()+": ")
                    tvConsulta.append(cursor.getString(1).toString()+", ")
                    tvConsulta.append(cursor.getString(2).toString()+"\n")
                }while(cursor.moveToNext())
            }
            cursor.close()

        }
        btnModificar.setOnClickListener {
            if (edId.text.isNotBlank() && edNombre.text.isNotBlank() && edEmail.text.isNotBlank()) {
                amigosDBHelper.modificarDato(
                    edId.text.toString().toInt(),
                    edNombre.text.toString(),
                    edEmail.text.toString()
                )
                edId.text.clear()
                edNombre.text.clear()
                edEmail.text.clear()
                Toast.makeText(this, "Modificado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Los campos no deben estar vacíos", Toast.LENGTH_SHORT).show()
            }

            tvConsulta.text = ""
            val db:SQLiteDatabase=amigosDBHelper.readableDatabase
            val cursor=db.rawQuery("SELECT * FROM amigos",null)
            if(cursor.moveToFirst()){
                do{
                    tvConsulta.append(cursor.getInt(0).toString()+": ")
                    tvConsulta.append(cursor.getString(1).toString()+", ")
                    tvConsulta.append(cursor.getString(2).toString()+"\n")
                }while(cursor.moveToNext())
            }
            cursor.close()
        }
}
}