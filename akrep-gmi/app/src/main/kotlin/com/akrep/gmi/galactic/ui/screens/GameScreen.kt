package com.akrep.gmi.galactic.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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

@Composable
fun GameScreen() {
    var score by remember { mutableStateOf(0L) }
    var level by remember { mutableStateOf(1) }
    var health by remember { mutableStateOf(100) }
    var wordInput by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var showMessage by remember { mutableStateOf(false) }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E27))
    ) {
        // Arka plan efektleri
        GalacticBackground()
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Üst Bar - Puan ve Seviye
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xFF1A1E3F),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Puan", color = Color.White, fontSize = 12.sp)
                    Text("$score", color = Color(0xFFFFD700), fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
                
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Seviye", color = Color.White, fontSize = 12.sp)
                    Text("$level", color = Color(0xFFFF6B00), fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
                
                Column(horizontalAlignment = Alignment.End) {
                    Text("Sağlık", color = Color.White, fontSize = 12.sp)
                    LinearProgressIndicator(
                        progress = health / 100f,
                        modifier = Modifier.width(80.dp),
                        color = Color(0xFF00FF00),
                        trackColor = Color(0xFF333333)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Akrep Görseli ve Animasyon
            ScorpionDisplay()
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Harf Tekerleği
            LetterWheel()
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Kelime Giriş Alanı
            TextField(
                value = wordInput,
                onValueChange = { wordInput = it.uppercase() },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1A1E3F), shape = RoundedCornerShape(12.dp)),
                placeholder = { Text("Kelime yazın...", color = Color.Gray) },
                textStyle = LocalTextStyle.current.copy(color = Color.White, fontSize = 18.sp),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Kontrol Butonları
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = { 
                        // Kelimeyi kontrol et
                        message = "Doğru! +100 puan"
                        showMessage = true
                        score += 100
                        wordInput = ""
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF6B00)
                    )
                ) {
                    Text("Gönder", fontWeight = FontWeight.Bold)
                }
                
                Button(
                    onClick = { wordInput = "" },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF666666)
                    )
                ) {
                    Text("Temizle")
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Mesaj Gösterimi
            AnimatedVisibility(
                visible = showMessage,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Text(
                    message,
                    color = Color(0xFFFFD700),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun GalacticBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E27))
    )
}

@Composable
fun ScorpionDisplay() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .background(
                Color(0xFF1A1E3F),
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "🦂",
            fontSize = 100.sp,
            modifier = Modifier
        )
    }
}

@Composable
fun LetterWheel() {
    val letters = listOf("A", "B", "C", "D", "E", "F", "G", "H")
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Mevcut Harfler", color = Color.White, fontSize = 14.sp)
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1A1E3F), shape = RoundedCornerShape(12.dp))
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            letters.forEach { letter ->
                Button(
                    onClick = { },
                    modifier = Modifier
                        .size(40.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF6B00)
                    ),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(letter, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
    }
}
