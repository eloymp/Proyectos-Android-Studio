package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AdapterAnimal(
    private var animales: MutableList<Animal>,
    private val contexto: Context
) : RecyclerView.Adapter<AdapterAnimal.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.elemento_lista_animales, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = animales[position]
        holder.bind(animal, contexto)
    }

    override fun getItemCount(): Int {
        return animales.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nombre: TextView = view.findViewById(R.id.tvNombre)
        private val latin: TextView = view.findViewById(R.id.tvNombreLatin)
        private val imagen: ImageView = view.findViewById(R.id.tvImagen)

        fun bind(animal: Animal, context: Context) {
            nombre.text = animal.nombre
            latin.text = animal.latin
            imagen.setImageResource(animal.imagen)
            itemView.setOnClickListener {
                Toast.makeText(context, animal.nombre, Toast.LENGTH_SHORT).show()
            }
        }
    }
}