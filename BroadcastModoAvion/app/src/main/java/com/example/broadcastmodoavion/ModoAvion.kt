package com.example.broadcastmodoavion

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

class ModoAvion : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Verificamos si la acción es el cambio del estado del modo avión
        if (intent.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            // Obtenemos el estado del modo avión
            val isAirplaneModeOn = Settings.Global.getInt(
                context.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON,
                0
            ) != 0

            // Mostramos un Toast dependiendo del estado del modo avión
            if (isAirplaneModeOn) {
                Toast.makeText(context, "Modo avión activado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Modo avión desactivado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
