package com.akrep.gmi.galactic.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit,
    onRegisterClick: (String, String) -> Unit,
    onAnonymousClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isRegistering by remember { mutableStateOf(false) }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E27))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo
            Text(
                "🦂",
                fontSize = 80.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            Text(
                "AKREP GMİ",
                color = Color(0xFFFF6B00),
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Text(
                "GALACTIC Akrep",
                color = Color(0xFFFFD700),
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            
            // Email Input
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF1A1E3F),
                    unfocusedContainerColor = Color(0xFF1A1E3F),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLabelColor = Color(0xFFFF6B00),
                    unfocusedLabelColor = Color.Gray
                ),
                shape = RoundedCornerShape(8.dp)
            )
            
            // Password Input
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Şifre") },
                type = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF1A1E3F),
                    unfocusedContainerColor = Color(0xFF1A1E3F),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLabelColor = Color(0xFFFF6B00),
                    unfocusedLabelColor = Color.Gray
                ),
                shape = RoundedCornerShape(8.dp),
                visualTransformation = PasswordVisualTransformation()
            )
            
            // Ana Buton
            Button(
                onClick = {
                    if (isRegistering) {
                        onRegisterClick(email, password)
                    } else {
                        onLoginClick(email, password)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(bottom = 12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6B00)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    if (isRegistering) "Kayıt Ol" else "Giriş Yap",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
            
            // Geçiş Butonu
            Button(
                onClick = { isRegistering = !isRegistering },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(bottom = 12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF666666)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    if (isRegistering) "Zaten hesabım var" else "Hesap oluştur",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
            
            // Anonim Giriş
            Button(
                onClick = onAnonymousClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF333333)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Anonim Giriş",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}
