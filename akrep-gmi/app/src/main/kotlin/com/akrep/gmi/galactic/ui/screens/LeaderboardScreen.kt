package com.akrep.gmi.galactic.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class LeaderboardEntry(
    val rank: Int,
    val playerName: String,
    val score: Long,
    val level: Int,
    val isCurrentPlayer: Boolean = false
)

@Composable
fun LeaderboardScreen() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Global", "Ülke", "Şehir", "Arkadaş", "Kulüp")
    
    val mockLeaderboard = listOf(
        LeaderboardEntry(1, "Oyuncu1", 50000, 45, false),
        LeaderboardEntry(2, "Oyuncu2", 48000, 42, false),
        LeaderboardEntry(3, "Oyuncu3", 46000, 40, true),
        LeaderboardEntry(4, "Oyuncu4", 44000, 38, false),
        LeaderboardEntry(5, "Oyuncu5", 42000, 36, false),
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E27))
            .padding(16.dp)
    ) {
        Text(
            "Liderlik Tablosu",
            color = Color(0xFFFF6B00),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        TabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1A1E3F), shape = RoundedCornerShape(12.dp)),
            containerColor = Color(0xFF1A1E3F)
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title, color = Color.White, fontSize = 12.sp) }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(mockLeaderboard) { index, entry ->
                LeaderboardEntryItem(entry)
            }
        }
    }
}

@Composable
fun LeaderboardEntryItem(entry: LeaderboardEntry) {
    val backgroundColor = if (entry.isCurrentPlayer) {
        Color(0xFF2A3F5F)
    } else {
        Color(0xFF1A1E3F)
    }
    
    val rankColor = when (entry.rank) {
        1 -> Color(0xFFFFD700) // Altın
        2 -> Color(0xFFC0C0C0) // Gümüş
        3 -> Color(0xFFCD7F32) // Bronz
        else -> Color(0xFFFF6B00)
    }
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Sıra
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(rankColor, shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "${entry.rank}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        
        // Oyuncu Bilgisi
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        ) {
            Text(
                entry.playerName,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Text(
                "Seviye ${entry.level}",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
        
        // Puan
        Text(
            "${entry.score}",
            color = Color(0xFFFFD700),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}
