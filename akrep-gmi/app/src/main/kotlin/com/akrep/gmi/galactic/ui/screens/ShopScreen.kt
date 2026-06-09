package com.akrep.gmi.galactic.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ShopItem(
    val id: String,
    val name: String,
    val description: String,
    val emoji: String,
    val price: Long,
    val currency: String, // gold, diamonds, crystal
    val category: String // scorpion, effect, frame, chest, emoji_pack
)

@Composable
fun ShopScreen() {
    val shopItems = listOf(
        ShopItem("chest_gold", "Altın Sandık", "100 Altın ve 10 Elmas", "🎁", 500, "gold", "chest"),
        ShopItem("chest_diamond", "Elmas Sandık", "500 Elmas ve Nadir Efekt", "💎", 50, "diamonds", "chest"),
        ShopItem("scorpion_crystal", "Kristal Akrebi", "Nadir Akrep", "🦂", 100, "diamonds", "scorpion"),
        ShopItem("effect_neon", "Neon Efekti", "Parlak neon efekti", "✨", 25, "diamonds", "effect"),
        ShopItem("frame_gold", "Altın Çerçeve", "Profil çerçevesi", "🖼️", 30, "diamonds", "frame"),
        ShopItem("emoji_pack", "Emoji Paketi", "20 Yeni Emoji", "😀", 15, "diamonds", "emoji_pack"),
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E27))
            .padding(16.dp)
    ) {
        Text(
            "Mağaza",
            color = Color(0xFFFF6B00),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(shopItems) { item ->
                ShopItemCard(item)
            }
        }
    }
}

@Composable
fun ShopItemCard(item: ShopItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1A1E3F), shape = RoundedCornerShape(12.dp))
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 4.dp)
            ) {
                Text(
                    item.emoji,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    item.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            
            Text(
                item.description,
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
        
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .width(80.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF6B00)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "${item.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                )
            }
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                when (item.currency) {
                    "gold" -> "💰"
                    "diamonds" -> "💎"
                    "crystal" -> "✨"
                    else -> ""
                },
                fontSize = 12.sp
            )
        }
    }
}
