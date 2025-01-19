package com.example.serviciomusica

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class ServicioMusica : Service() {

    private var reproductor: MediaPlayer? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this, "Servicio creado", Toast.LENGTH_SHORT).show()
        reproductor = MediaPlayer.create(this, R.raw.flow_violento)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Servicio arrancado", Toast.LENGTH_SHORT).show()
        reproductor?.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Servicio detenido", Toast.LENGTH_SHORT).show()
        reproductor?.stop()
        reproductor?.release()
        reproductor = null
    }
}

