package com.desire.digital.tunnel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.desire.digital.tunnel.ui.DesireDigitalTunnelApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DesireDigitalTunnelApp()
        }
    }
}
