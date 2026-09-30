package com.desire.digital.tunnel.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun DesireDigitalTunnelApp() {
    MaterialTheme {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                AppDrawer(
                    onClose = {
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )
            }
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFF8FAFC)
            ) {
                HomeScreen(
                    onMenuClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun AppDrawer(
    onClose: () -> Unit
) {
    ModalDrawerSheet(
        drawerContainerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = "DÉSIRÉ DIGITAL",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A)
            )

            Text(
                text = "TUNNEL",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF0891B2)
            )

            Spacer(modifier = Modifier.height(24.dp))

            DrawerItem("🏠", "Accueil", onClose)
            DrawerItem("🔐", "Tunnel / Configurations", onClose)
            DrawerItem("💎", "Abonnement Premium", onClose)
            DrawerItem("📁", "Fichiers", onClose)
            DrawerItem("📖", "Journal", onClose)
            DrawerItem("🌐", "Réseau", onClose)
            DrawerItem("⚙️", "Paramètres", onClose)
            DrawerItem("🔄", "Mise à jour", onClose)
            DrawerItem("💬", "Support", onClose)
            DrawerItem("ℹ️", "À propos", onClose)

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "DÉSIRÉ DIGITAL • v1.0.0",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color(0xFF64748B),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
private fun DrawerItem(
    icon: String,
    title: String,
    onClick: () -> Unit
) {
    NavigationDrawerItem(
        label = {
            Text(
                text = "$icon  $title",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        },
        selected = false,
        onClick = onClick,
        modifier = Modifier.padding(vertical = 2.dp),
        shape = RoundedCornerShape(14.dp)
    )
}

@Composable
private fun HomeScreen(
    onMenuClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Header(onMenuClick)

        NetworkCard()

        VpnStatusCard()

        Spacer(modifier = Modifier.height(4.dp))

        PowerButton()

        PremiumCard()

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "DÉSIRÉ DIGITAL • v1.0.0",
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF64748B),
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun Header(
    onMenuClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(14.dp),
                color = Color(0xFFE0F2FE)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "D/T",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0284C7)
                    )
                }
            }

            Spacer(modifier = Modifier.size(12.dp))

            Column {
                Text(
                    text = "DÉSIRÉ DIGITAL",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                )

                Text(
                    text = "TUNNEL",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF0891B2)
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            HeaderButton("🔔")
            HeaderButton("🎁")
            HeaderButton("☰", onMenuClick)
        }
    }
}

@Composable
private fun HeaderButton(
    text: String,
    onClick: (() -> Unit)? = null
) {
    androidx.compose.material3.IconButton(
        onClick = { onClick?.invoke() },
        modifier = Modifier.size(40.dp)
    ) {
        Surface(
            modifier = Modifier.size(40.dp),
            shape = CircleShape,
            color = Color.White,
            shadowElevation = 2.dp
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = text,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
private fun NetworkCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "🌐 Réseau",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                NetworkItem("État", "Non connecté")
                NetworkItem("IP", "—")
                NetworkItem("Ping", "—")
            }
        }
    }
}

@Composable
private fun NetworkItem(
    title: String,
    value: String
) {
    Column {
        Text(
            text = title,
            color = Color(0xFF64748B),
            fontSize = 12.sp
        )

        Text(
            text = value,
            color = Color(0xFF0F172A),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun VpnStatusCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "🔴 VPN DÉCONNECTÉ",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFDC2626)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Aucune connexion active",
                color = Color(0xFF64748B),
                fontSize = 13.sp
            )
        }
    }
}

@Composable
private fun PowerButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0284C7)
        )
    ) {
        Text(
            text = "⚡  POWER",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun PremiumCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFBEB)
        ),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "💎 Premium",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF92400E)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Non activé",
                    color = Color(0xFF78350F),
                    fontSize = 13.sp
                )
            }

            Text(
                text = "ACTIVER",
                color = Color(0xFFB45309),
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
        }
    }
}
