package com.desire.digital.tunnel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
                    onCustomConfig = { screen = "custom" }
                )

                "custom" -> CustomConfigScreen(
                    onBack = { screen = "home" }
                )
            }
        }
    }
}

@Composable
fun HomeScreen(
    onCustomConfig: () -> Unit
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
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF5F5F5)
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
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
            Button(onClick = { }) {
                Text("VMess")
            }

            Button(onClick = { }) {
                Text("VLESS")
            }

            Button(onClick = { }) {
                Text("Trojan")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { }) {
                Text("SlowDNS")
            }

            Button(onClick = { }) {
                Text("UDP")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text("CONNECTER")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF5F5F5)
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
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
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("DASHBOARD ADMINISTRATIF")
        }
    }
}

@Composable
fun CustomConfigScreen(
    onBack: () -> Unit
) {
    var activationCode by remember { mutableStateOf("") }
    var activated by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    if (!activated) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(20.dp)
        ) {
            Button(onClick = onBack) {
                Text("← Retour")
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Configuration personnalisée",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Cette section nécessite un code d'activation.",
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = activationCode,
                onValueChange = {
                    activationCode = it
                    message = ""
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Code d'activation")
                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (activationCode.isBlank()) {
                        message = "Veuillez saisir un code d'activation."
                    } else {
                        message = "Vérification du code..."
                        activated = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("VALIDER")
            }

            Spacer(modifier = Modifier.height(12.dp))

            if (message.isNotEmpty()) {
                Text(
                    text = message,
                    color = Color.DarkGray
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Vous n'avez pas de code ?",
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Contactez l'administrateur sur WhatsApp.",
                color = Color.DarkGray
            )
        }
    } else {
        CustomToolsScreen(
            onBack = onBack
        )
    }
}

@Composable
fun CustomToolsScreen(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        Button(onClick = onBack) {
            Text("← Retour")
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Configuration personnalisée",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("IMPORTER UNE CONFIGURATION")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("EXPORTER UNE CONFIGURATION")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CRÉER UN FICHIER TEMPORAIRE")
        }
    }
}
