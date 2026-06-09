package com.akrep.gmi.galactic.game

data class Quest(
    val id: String,
    val title: String,
    val description: String,
    val type: String, // daily, weekly, monthly, seasonal
    val target: Int,
    val current: Int = 0,
    val rewards: Map<String, Long>,
    val isCompleted: Boolean = false,
    val isClaimed: Boolean = false
)

class QuestSystem {
    
    private val dailyQuests = listOf(
        Quest("find_10_words", "10 Kelime Bul", "Bugün 10 kelime bul", "daily", 10, 
            mapOf("gold" to 100, "diamonds" to 5)),
        Quest("score_1000", "1000 Puan Kazanma", "Oyunda 1000 puan kazanma", "daily", 1000,
            mapOf("gold" to 200, "diamonds" to 10)),
        Quest("level_up_scorpion", "Akrebi Seviye Atla", "Akrebin seviyesini bir kez atla", "daily", 1,
            mapOf("gold" to 150, "diamonds" to 8)),
        Quest("complete_3_levels", "3 Bölümü Tamamla", "3 bölümü tamamla", "daily", 3,
            mapOf("gold" to 300, "diamonds" to 15))
    )
    
    private val weeklyQuests = listOf(
        Quest("find_100_words", "100 Kelime Bul", "Bu hafta 100 kelime bul", "weekly", 100,
            mapOf("gold" to 1000, "diamonds" to 50)),
        Quest("reach_level_5", "Seviye 5'e Ulaş", "Oyunda seviye 5'e ulaş", "weekly", 5,
            mapOf("gold" to 500, "diamonds" to 30)),
        Quest("complete_boss_level", "Boss Bölümünü Tamamla", "Bir boss bölümünü tamamla", "weekly", 1,
            mapOf("gold" to 800, "diamonds" to 40))
    )
    
    private val monthlyQuests = listOf(
        Quest("find_1000_words", "1000 Kelime Bul", "Bu ay 1000 kelime bul", "monthly", 1000,
            mapOf("gold" to 5000, "diamonds" to 200)),
        Quest("reach_level_20", "Seviye 20'ye Ulaş", "Oyunda seviye 20'ye ulaş", "monthly", 20,
            mapOf("gold" to 3000, "diamonds" to 150)),
        Quest("complete_all_bosses", "Tüm Bossları Yenme", "Tüm boss bölümlerini tamamla", "monthly", 5,
            mapOf("gold" to 10000, "diamonds" to 500))
    )
    
    fun getDailyQuests(): List<Quest> = dailyQuests
    
    fun getWeeklyQuests(): List<Quest> = weeklyQuests
    
    fun getMonthlyQuests(): List<Quest> = monthlyQuests
    
    fun updateQuestProgress(quest: Quest, progress: Int): Quest {
        val newCurrent = (quest.current + progress).coerceAtMost(quest.target)
        val isCompleted = newCurrent >= quest.target
        
        return quest.copy(
            current = newCurrent,
            isCompleted = isCompleted
        )
    }
    
    fun claimQuestReward(quest: Quest): Quest {
        return if (quest.isCompleted && !quest.isClaimed) {
            quest.copy(isClaimed = true)
        } else quest
    }
    
    fun getQuestProgress(quest: Quest): Float {
        return (quest.current.toFloat() / quest.target).coerceIn(0f, 1f)
    }
}
