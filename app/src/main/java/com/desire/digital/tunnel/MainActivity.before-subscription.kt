package com.desire.digital.tunnel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DesireDigitalTunnelApp()
        }
    }
}

@Composable
fun DesireDigitalTunnelApp() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            var screen by remember { mutableStateOf("home") }

            when (screen) {
                "home" -> HomeScreen(
                    onCustomConfig = {
                        screen = "custom"
                    },
                    onAdmin = {
                        screen = "admin"
                    }
                )

                "custom" -> CustomConfigScreen(
                    onBack = {
                        screen = "home"
                    }
                )

                "admin" -> AdminDashboard(
                    onBack = {
                        screen = "home"
                    }
                )
            }
        }
    }
}

@Composable
fun HomeScreen(
    onCustomConfig: () -> Unit,
    onAdmin: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {

        Text(
            text = "DÉSIRÉ DIGITAL TUNNEL",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "v1.0.0",
            fontSize = 13.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF5F5F5)
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Réseau",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text("IP : Non disponible")
                Text("Réseau : Non connecté")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Configuration",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ConfigButton("VMess")
            ConfigButton("VLESS")
            ConfigButton("Trojan")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ConfigButton("SlowDNS")
            ConfigButton("UDP")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally),
            shape = CircleShape
        ) {
            Text(
                text = "CONNECTER",
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF5F5F5)
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Abonnement",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text("Temps restant : --")

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = { }) {
                    Text("AJOUTER DU TEMPS")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onCustomConfig,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CONFIGURATION PERSONNALISÉE")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onAdmin,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("DASHBOARD ADMINISTRATIF")
        }
    }
}

@Composable
fun ConfigButton(name: String) {
    Button(
        onClick = { },
        modifier = Modifier.weight(1f)
    ) {
        Text(
            text = name,
            fontSize = 12.sp
        )
    }
}
