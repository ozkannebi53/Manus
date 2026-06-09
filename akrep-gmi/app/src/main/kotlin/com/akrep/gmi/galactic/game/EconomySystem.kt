package com.akrep.gmi.galactic.game

class EconomySystem {
    
    private var gold: Long = 0
    private var diamonds: Long = 0
    private var scorpionCrystals: Long = 0
    private var seasonTokens: Long = 0
    private var cosmicPieces: Long = 0
    
    fun addReward(rewardType: String, amount: Long) {
        when (rewardType) {
            "gold" -> gold += amount
            "diamonds" -> diamonds += amount
            "scorpion_crystal" -> scorpionCrystals += amount
            "season_token" -> seasonTokens += amount
            "cosmic_piece" -> cosmicPieces += amount
        }
    }
    
    fun spendCurrency(currencyType: String, amount: Long): Boolean {
        return when (currencyType) {
            "gold" -> {
                if (gold >= amount) {
                    gold -= amount
                    true
                } else false
            }
            "diamonds" -> {
                if (diamonds >= amount) {
                    diamonds -= amount
                    true
                } else false
            }
            "scorpion_crystal" -> {
                if (scorpionCrystals >= amount) {
                    scorpionCrystals -= amount
                    true
                } else false
            }
            "season_token" -> {
                if (seasonTokens >= amount) {
                    seasonTokens -= amount
                    true
                } else false
            }
            "cosmic_piece" -> {
                if (cosmicPieces >= amount) {
                    cosmicPieces -= amount
                    true
                } else false
            }
            else -> false
        }
    }
    
    fun calculateLevelReward(level: Int): Map<String, Long> {
        val baseGold = 100L + (level * 50)
        val baseDiamonds = if (level % 5 == 0) 10L else 0L
        val baseCrystals = if (level % 10 == 0) 5L else 0L
        
        return mapOf(
            "gold" to baseGold,
            "diamonds" to baseDiamonds,
            "scorpion_crystal" to baseCrystals
        )
    }
    
    fun calculateWordReward(wordLength: Int, difficulty: Int): Long {
        val basePoints = 10L * wordLength
        val difficultyMultiplier = 1 + (difficulty * 0.2f)
        return (basePoints * difficultyMultiplier).toLong()
    }
    
    fun getBalance(): Map<String, Long> {
        return mapOf(
            "gold" to gold,
            "diamonds" to diamonds,
            "scorpion_crystal" to scorpionCrystals,
            "season_token" to seasonTokens,
            "cosmic_piece" to cosmicPieces
        )
    }
    
    fun setBalance(balances: Map<String, Long>) {
        gold = balances["gold"] ?: 0
        diamonds = balances["diamonds"] ?: 0
        scorpionCrystals = balances["scorpion_crystal"] ?: 0
        seasonTokens = balances["season_token"] ?: 0
        cosmicPieces = balances["cosmic_piece"] ?: 0
    }
}
