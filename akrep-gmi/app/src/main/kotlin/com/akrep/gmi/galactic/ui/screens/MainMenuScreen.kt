package com.akrep.gmi.galactic.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainMenuScreen(
    onPlayClick: () -> Unit,
    onLeaderboardClick: () -> Unit,
    onCollectionClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    // Akrep animasyonu
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = EaseInOutQuad),
            repeatMode = RepeatMode.Reverse
        )
    )
    
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Başlık
            Text(
                "AKREP GMİ",
                color = Color(0xFFFF6B00),
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Text(
                "GALACTIC Akrep",
                color = Color(0xFFFFD700),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            
            // Akrep Animasyonu
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .graphicsLayer(
                        rotationZ = rotation,
                        scaleX = scale,
                        scaleY = scale
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "🦂",
                    fontSize = 120.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(48.dp))
            
            // Butonlar
            MenuButton(
                text = "Oyna",
                emoji = "▶️",
                onClick = onPlayClick
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            MenuButton(
                text = "Liderlik Tablosu",
                emoji = "🏆",
                onClick = onLeaderboardClick
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            MenuButton(
                text = "Koleksiyon",
                emoji = "📚",
                onClick = onCollectionClick
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            MenuButton(
                text = "Profil",
                emoji = "👤",
                onClick = onProfileClick
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Alt bilgi
            Text(
                "v1.0.0",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun MenuButton(
    text: String,
    emoji: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF6B00)
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(emoji, fontSize = 24.sp, modifier = Modifier.padding(end = 8.dp))
            Text(
                text,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}
