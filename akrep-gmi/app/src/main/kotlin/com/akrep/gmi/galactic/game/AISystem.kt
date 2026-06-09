package com.akrep.gmi.galactic.game

import kotlin.math.pow
import kotlin.random.Random

class AISystem {
    
    fun analyzeBehavior(playerData: Map<String, Any>): PlayerBehavior {
        val level = playerData["level"] as? Int ?: 1
        val averageScore = playerData["average_score"] as? Long ?: 0
        val playTime = playerData["play_time"] as? Long ?: 0
        val streak = playerData["current_streak"] as? Int ?: 0
        
        return PlayerBehavior(
            skillLevel = calculateSkillLevel(level, averageScore),
            engagementLevel = calculateEngagementLevel(playTime),
            consistency = calculateConsistency(streak),
            preferredDifficulty = calculatePreferredDifficulty(level, averageScore)
        )
    }
    
    fun adjustDifficulty(behavior: PlayerBehavior): Int {
        var difficulty = 3 // Orta zorluk
        
        if (behavior.skillLevel > 0.8f) {
            difficulty = 5
        } else if (behavior.skillLevel > 0.6f) {
            difficulty = 4
        } else if (behavior.skillLevel < 0.3f) {
            difficulty = 1
        } else if (behavior.skillLevel < 0.5f) {
            difficulty = 2
        }
        
        return difficulty
    }
    
    fun generatePersonalizedQuest(behavior: PlayerBehavior, playerLevel: Int): Quest {
        val difficulty = adjustDifficulty(behavior)
        val targetScore = 100 * difficulty * playerLevel
        
        return Quest(
            id = "ai_quest_${System.currentTimeMillis()}",
            title = "Özel Görev",
            description = "Sana özel olarak oluşturulan görev",
            type = "seasonal",
            target = targetScore.toInt(),
            rewards = mapOf("gold" to (500L * difficulty), "diamonds" to (50L * difficulty))
        )
    }
    
    fun generateDynamicContent(playerData: Map<String, Any>): List<String> {
        val behavior = analyzeBehavior(playerData)
        val content = mutableListOf<String>()
        
        // Oyuncunun seviyesine göre içerik
        val level = playerData["level"] as? Int ?: 1
        
        if (behavior.skillLevel > 0.7f) {
            content.add("boss_challenge")
            content.add("hard_puzzle")
        }
        
        if (behavior.engagementLevel > 0.8f) {
            content.add("daily_bonus")
            content.add("special_event")
        }
        
        if (behavior.consistency > 0.6f) {
            content.add("streak_reward")
            content.add("loyalty_bonus")
        }
        
        content.add("new_scorpion_available")
        
        return content
    }
    
    fun getAIRecommendation(behavior: PlayerBehavior, playerLevel: Int): String {
        return when {
            behavior.skillLevel > 0.8f -> "🦂 Harika oynuyorsun! Boss bölümlerini dene!"
            behavior.skillLevel > 0.6f -> "🦂 İyi gidiyorsun! Zorluk seviyesini artırabiliriz."
            behavior.skillLevel < 0.3f -> "🦂 Endişelenme, pratik yaparak daha iyi olacaksın!"
            behavior.engagementLevel > 0.8f -> "🦂 Çok aktif görünüyorsun! Yeni etkinliklere katıl!"
            behavior.consistency > 0.8f -> "🦂 Harika tutarlılık! Sezon ödüllerini kazanmaya devam et!"
            else -> "🦂 Oynamaya devam et ve eğlen!"
        }
    }
    
    private fun calculateSkillLevel(level: Int, averageScore: Long): Float {
        val levelFactor = (level.toFloat() / 100).coerceIn(0f, 1f)
        val scoreFactor = (averageScore.toFloat() / 10000).coerceIn(0f, 1f)
        return (levelFactor * 0.4f + scoreFactor * 0.6f).coerceIn(0f, 1f)
    }
    
    private fun calculateEngagementLevel(playTime: Long): Float {
        val hoursPlayed = playTime / (1000 * 60 * 60)
        return (hoursPlayed.toFloat() / 100).coerceIn(0f, 1f)
    }
    
    private fun calculateConsistency(streak: Int): Float {
        return (streak.toFloat() / 100).coerceIn(0f, 1f)
    }
    
    private fun calculatePreferredDifficulty(level: Int, averageScore: Long): Int {
        val skillLevel = calculateSkillLevel(level, averageScore)
        return when {
            skillLevel > 0.8f -> 5
            skillLevel > 0.6f -> 4
            skillLevel > 0.4f -> 3
            skillLevel > 0.2f -> 2
            else -> 1
        }
    }
}

data class PlayerBehavior(
    val skillLevel: Float,
    val engagementLevel: Float,
    val consistency: Float,
    val preferredDifficulty: Int
)
