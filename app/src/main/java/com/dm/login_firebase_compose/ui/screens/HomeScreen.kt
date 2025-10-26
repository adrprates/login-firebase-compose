package com.dm.login_firebase_compose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(navController: NavController) {
    val user = FirebaseAuth.getInstance().currentUser
    val email = user?.email ?: "usuário"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Bem-vindo,", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF333333))
        Text(email, fontSize = 18.sp, color = Color(0xFF555555))

        Spacer(Modifier.height(32.dp))

        Button(
            onClick = {
                FirebaseAuth.getInstance().signOut()
                navController.navigate("login") {
                    popUpTo("home") { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Sair", color = Color.White, fontSize = 18.sp)
        }
    }
}
