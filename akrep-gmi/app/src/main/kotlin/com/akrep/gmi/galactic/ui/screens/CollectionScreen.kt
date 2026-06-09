package com.akrep.gmi.galactic.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CollectionItem(
    val id: String,
    val name: String,
    val emoji: String,
    val isOwned: Boolean,
    val rarity: String // common, rare, epic, legendary, cosmic
)

@Composable
fun CollectionScreen() {
    val scorpionCollection = listOf(
        CollectionItem("sand", "Kum Akrebi", "🦂", true, "common"),
        CollectionItem("desert", "Çöl Akrebi", "🦂", true, "common"),
        CollectionItem("ice", "Buz Akrebi", "🦂", true, "rare"),
        CollectionItem("crystal", "Kristal Akrebi", "🦂", false, "rare"),
        CollectionItem("electric", "Elektrik Akrebi", "⚡", false, "epic"),
        CollectionItem("fire", "Ateş Akrebi", "🔥", false, "epic"),
        CollectionItem("nebula", "Nebula Akrebi", "✨", false, "epic"),
        CollectionItem("black_hole", "Kara Delik Akrebi", "🌌", false, "legendary"),
        CollectionItem("cosmic", "Kozmik Akrebi", "🌠", false, "legendary"),
        CollectionItem("galactic", "Galaktik Akrebi", "🌌", false, "cosmic"),
        CollectionItem("cosmic_king", "Kozmik Kral Akrep", "👑", false, "cosmic"),
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E27))
            .padding(16.dp)
    ) {
        Text(
            "Koleksiyon",
            color = Color(0xFFFF6B00),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // İlerleme Göstergesi
        val ownedCount = scorpionCollection.count { it.isOwned }
        val totalCount = scorpionCollection.size
        val progress = ownedCount.toFloat() / totalCount
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1A1E3F), shape = RoundedCornerShape(12.dp))
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Akrepler", color = Color.White, fontWeight = FontWeight.Bold)
                Text("$ownedCount/$totalCount", color = Color(0xFFFFD700), fontWeight = FontWeight.Bold)
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Color(0xFFFF6B00),
                trackColor = Color(0xFF333333)
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                "${(progress * 100).toInt()}% Tamamlandı",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Koleksiyon Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(scorpionCollection.size) { index ->
                CollectionItemCard(scorpionCollection[index])
            }
        }
    }
}

@Composable
fun CollectionItemCard(item: CollectionItem) {
    val backgroundColor = when {
        !item.isOwned -> Color(0xFF333333)
        item.rarity == "cosmic" -> Color(0xFF4A3F8F)
        item.rarity == "legendary" -> Color(0xFF8B4513)
        item.rarity == "epic" -> Color(0xFF663399)
        item.rarity == "rare" -> Color(0xFF4169E1)
        else -> Color(0xFF1A1E3F)
    }
    
    Column(
        modifier = Modifier
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            item.emoji,
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        
        Text(
            item.name,
            color = if (item.isOwned) Color.White else Color.Gray,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        
        if (!item.isOwned) {
            Text(
                "🔒",
                fontSize = 12.sp
            )
        }
    }
}
