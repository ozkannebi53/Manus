package com.akrep.gmi.galactic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akrep.gmi.galactic.ui.theme.AkrepGMITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AkrepGMITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AkrepGMIApp()
                }
            }
        }
    }
}

@Composable
fun AkrepGMIApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0A0E27)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "🦂",
                fontSize = 80.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "AKREP GMİ",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF6B00),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "GALACTIC Akrep",
                fontSize = 18.sp,
                color = Color(0xFFFFD700),
                modifier = Modifier.padding(bottom = 32.dp)
            )
            Text(
                text = "Yükleniyor...",
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}
