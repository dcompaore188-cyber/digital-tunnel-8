package com.desire.digital.tunnel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubscriptionScreen(
    onBack: () -> Unit
) {
    var code by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

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
            text = "Activation de l'abonnement",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Saisissez votre code d'activation.",
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = code,
            onValueChange = {
                code = it
                message = ""
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Code d'activation")
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                if (code.isBlank()) {
                    message = "Veuillez saisir un code."
                } else {
                    message = "Vérification auprès du serveur..."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("ACTIVER")
        }

        Spacer(modifier = Modifier.height(25.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF5F5F5)
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Tarifs",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text("7 jours : 500 FCFA")
                Text("30 jours : 1 000 FCFA")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Vous n'avez pas de code ?",
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Contactez l'administrateur pour obtenir un code d'activation.",
            color = Color.DarkGray
        )

        if (message.isNotEmpty()) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = message,
                color = Color.DarkGray
            )
        }
    }
}
