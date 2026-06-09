package com.akrep.gmi.galactic.game

data class BossData(
    val id: String,
    val name: String,
    val type: String,
    val maxHealth: Long,
    val difficulty: Int,
    val rewards: Map<String, Long>
)

class BossSystem {
    
    private val bosses = listOf(
        BossData("meteor_monster", "Meteor Canavarı", "meteor", 500, 1, mapOf("gold" to 500, "diamonds" to 50)),
        BossData("nebula_guardian", "Nebula Muhafızı", "nebula", 1000, 2, mapOf("gold" to 1000, "diamonds" to 100)),
        BossData("black_hole_lord", "Kara Delik Efendisi", "black_hole", 2000, 3, mapOf("gold" to 2000, "diamonds" to 250)),
        BossData("galactic_titan", "Galaktik Titan", "galactic", 5000, 4, mapOf("gold" to 5000, "diamonds" to 500)),
        BossData("cosmic_destroyer", "Kozmik Yıkıcı", "cosmic", 10000, 5, mapOf("gold" to 10000, "diamonds" to 1000))
    )
    
    fun getBossByLevel(level: Int): BossData {
        val bossIndex = (level / 10).coerceIn(0, bosses.size - 1)
        return bosses[bossIndex]
    }
    
    fun calculateDamage(wordLength: Int, difficulty: Int): Long {
        val baseDamage = 10L * wordLength
        val difficultyMultiplier = 1 + (difficulty * 0.5f)
        return (baseDamage * difficultyMultiplier).toLong()
    }
    
    fun isBossDefeated(currentHealth: Long): Boolean {
        return currentHealth <= 0
    }
    
    fun getHealthPercentage(currentHealth: Long, maxHealth: Long): Float {
        return (currentHealth.toFloat() / maxHealth).coerceIn(0f, 1f)
    }
    
    fun getBossRewards(bossId: String): Map<String, Long> {
        return bosses.find { it.id == bossId }?.rewards ?: emptyMap()
    }
}
