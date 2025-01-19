package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MiSQLiteHelper(context: Context, ) : SQLiteOpenHelper(
    context, "amigos.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val ordenCreacion="CREATE TABLE amigos (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, email TEXT)"
        db!!.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?,p1: Int, p2:Int) {
        val ordenBorrado="DROP TABLE IF EXISTS amigos"
        db!!.execSQL(ordenBorrado)
        // Volver a crear la tabla
        onCreate(db)
    }

    fun añadirDato(nombre:String, email:String){
        val datos=ContentValues()
        datos.put("nombre",nombre)
        datos.put("email",email)
        val db=this.writableDatabase
        db.insert("amigos", null, datos)
        db.close()
    }

    fun borrarDato(id:Int):Int{
        val args= arrayOf(id.toString())
        val db=this.writableDatabase
        val borrados=db.delete("amigos","id=?",args)
        db.close()
        return borrados
    }

    fun modificarDato(id:Int, nombre:String, email:String){
        val args= arrayOf(id.toString())
        val datos=ContentValues()
        datos.put("nombre",nombre)
        datos.put("email",email)
        val db=this.writableDatabase
        db.update("amigos",datos,"id=?",args)
        db.close()
    }
}