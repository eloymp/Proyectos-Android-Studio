package com.example.ejemplonotificacion

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val button = findViewById<Button>(R.id.button)
        val canalID="com.example.EjemploNotificacion"
        val i = Intent(this, ActivityNotificacion::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0,i,PendingIntent.FLAG_IMMUTABLE)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val importancia = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(canalID,"nombre",importancia)
            val manager = getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager

            manager.createNotificationChannel(channel)

            button.setOnClickListener{
                val notificacion = NotificationCompat.Builder(this, canalID).also{noti ->
                                    noti.setSmallIcon(R.drawable.ic_launcher_foreground)
                    noti.setContentTitle("Mi notificacion")
                    noti.setContentText("Ejemplo de notificacion")
                    noti.priority= NotificationCompat.PRIORITY_HIGH
                    noti.setContentIntent(pendingIntent)
                    noti.setAutoCancel(true)

                }.build()

                //En Android 13 (API 33) o superior, necesitas pedir permiso al usuario.

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 1)
                    }
                }

                NotificationManagerCompat.from(this).notify(1,notificacion)

            }
        }

    }
}