package com.akrep.gmi.galactic.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E27))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profil Başlığı
        Text(
            "Profil",
            color = Color(0xFFFF6B00),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        
        // Profil Resmi
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color(0xFF1A1E3F), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("🦂", fontSize = 60.sp)
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Kullanıcı Bilgisi
        Text(
            "Oyuncu Adı",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            "Seviye 45 • Usta Ligi",
            color = Color(0xFFFFD700),
            fontSize = 14.sp
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // İstatistikler
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1A1E3F), shape = RoundedCornerShape(12.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatisticRow("Toplam Puan", "125,000")
            StatisticRow("Bulunan Kelime", "2,345")
            StatisticRow("Oynanan Bölüm", "450")
            StatisticRow("Mevcut Streak", "25")
            StatisticRow("En İyi Streak", "87")
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Para Bilgisi
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1A1E3F), shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Text("Bakiye", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CurrencyBox("💰", "50,000", "Altın")
                CurrencyBox("💎", "500", "Elmas")
                CurrencyBox("✨", "250", "Kristal")
            }
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        // Çıkış Butonu
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF666666)
            )
        ) {
            Text("Çıkış Yap", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun StatisticRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = Color.White)
        Text(value, color = Color(0xFFFFD700), fontWeight = FontWeight.Bold)
    }
}

@Composable
fun CurrencyBox(emoji: String, amount: String, label: String) {
    Column(
        modifier = Modifier
            .weight(1f)
            .background(Color(0xFF2A2E4F), shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(emoji, fontSize = 24.sp)
        Text(amount, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        Text(label, color = Color.Gray, fontSize = 10.sp)
    }
}
