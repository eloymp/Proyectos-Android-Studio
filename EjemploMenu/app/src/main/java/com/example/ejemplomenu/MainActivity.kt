package com.example.ejemplomenu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val TAG="ciclo de vida"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show()
        Log.d(TAG,"Pasando por onCreate")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show()
        Log.d(TAG,"Pasando por onStart")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show()
        Log.d(TAG,"Pasando por onResume")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show()
        Log.d(TAG,"Pasando por onStop")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show()
        Log.d(TAG,"Pasando por onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"onRestart",Toast.LENGTH_LONG).show()
        Log.d(TAG,"Pasando por onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show()
        Log.d(TAG,"Pasando por onDestroy")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_opciones -> {
            Log.i("ActionBar", "Dias!")
            lanzarAcercaDe()
            true
        }
        R.id.action_nuevo -> {
            Log.i("ActionBar", "Nuevo!")
            lanzarAcercaDe()
            true
        }
        R.id.action_buscar -> {
            Log.i("ActionBar", "Buscar!")
            lanzarAcercaDe()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    fun lanzarAcercaDe(view: View? = null){
        val i = Intent(this, AcercaDe::class.java)
        startActivity(i)
        Toast.makeText(this,"Esta es la segunda actividad",Toast.LENGTH_LONG).show()

    }

}