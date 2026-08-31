package com.desire.digital.tunnel

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdminDashboard(
    onBack: () -> Unit
) {
    var password by remember { mutableStateOf("") }
    var authenticated by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    if (!authenticated) {
        AdminLoginScreen(
            password = password,
            errorMessage = errorMessage,
            onPasswordChange = {
                password = it
                errorMessage = ""
            },
            onLogin = {
                if (password == "25803") {
                    authenticated = true
                    errorMessage = ""
                } else {
                    errorMessage =
                        "Mot de passe incorrect.\nVous n'êtes pas l'administrateur.\nVous n'êtes pas autorisé à entrer ici."
                }
            },
            onBack = onBack
        )
    } else {
        AdminPanel(
            onBack = onBack
        )
    }
}

@Composable
private fun AdminLoginScreen(
    password: String,
    errorMessage: String,
    onPasswordChange: (String) -> Unit,
    onLogin: () -> Unit,
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

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "ADMINISTRATION",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Accès réservé à l'administrateur.",
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Mot de passe")
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = onLogin,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("ENTRER")
        }

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = errorMessage,
                color = Color.Red
            )
        }
    }
}

@Composable
private fun AdminPanel(
    onBack: () -> Unit
) {
    var selectedDuration by remember { mutableStateOf("7 jours") }
    var generatedCode by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {
        Button(onClick = onBack) {
            Text("← Retour")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Bienvenue chez l'administration",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

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
                    text = "Générer un code",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            selectedDuration = "7 jours"
                        }
                    ) {
                        Text("7 JOURS")
                    }

                    Button(
                        onClick = {
                            selectedDuration = "30 jours"
                        }
                    ) {
                        Text("30 JOURS")
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Durée sélectionnée : $selectedDuration",
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {
                        generatedCode = "À générer par le serveur"
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("GÉNÉRER LE CODE")
                }

                if (generatedCode.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = generatedCode,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("GESTION DES CODES")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("FICHIERS TEMPORAIRES")
        }
    }
}
