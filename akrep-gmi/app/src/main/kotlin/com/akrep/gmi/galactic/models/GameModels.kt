package com.akrep.gmi.galactic.models

import com.google.firebase.firestore.PropertyName

// Oyuncu Modeli
data class Player(
    @PropertyName("user_id")
    val userId: String = "",
    @PropertyName("username")
    val username: String = "",
    @PropertyName("level")
    val level: Int = 1,
    @PropertyName("experience")
    val experience: Long = 0,
    @PropertyName("score")
    val score: Long = 0,
    @PropertyName("gold")
    val gold: Long = 0,
    @PropertyName("diamonds")
    val diamonds: Long = 0,
    @PropertyName("scorpion_crystals")
    val scorpionCrystals: Long = 0,
    @PropertyName("current_scorpion_id")
    val currentScorpionId: String = "sand_scorpion",
    @PropertyName("total_words_found")
    val totalWordsFound: Int = 0,
    @PropertyName("current_streak")
    val currentStreak: Int = 0,
    @PropertyName("best_streak")
    val bestStreak: Int = 0,
    @PropertyName("created_at")
    val createdAt: Long = System.currentTimeMillis(),
    @PropertyName("last_login")
    val lastLogin: Long = System.currentTimeMillis()
)

// Akrep Modeli
data class Scorpion(
    @PropertyName("id")
    val id: String = "",
    @PropertyName("name")
    val name: String = "",
    @PropertyName("type")
    val type: String = "", // sand, desert, ice, crystal, electric, fire, nebula, black_hole, cosmic, galactic, cosmic_king
    @PropertyName("level")
    val level: Int = 1,
    @PropertyName("experience")
    val experience: Long = 0,
    @PropertyName("rarity")
    val rarity: String = "", // common, rare, epic, legendary, cosmic
    @PropertyName("special_effects")
    val specialEffects: List<String> = emptyList(),
    @PropertyName("evolution_stage")
    val evolutionStage: Int = 1,
    @PropertyName("is_active")
    val isActive: Boolean = false
)

// Kelime Modeli
data class Word(
    @PropertyName("word")
    val word: String = "",
    @PropertyName("meaning")
    val meaning: String = "",
    @PropertyName("word_type")
    val wordType: String = "", // noun, verb, adjective, etc.
    @PropertyName("example")
    val example: String = "",
    @PropertyName("difficulty")
    val difficulty: Int = 1, // 1-5
    @PropertyName("points")
    val points: Int = 0,
    @PropertyName("found_at")
    val foundAt: Long = 0,
    @PropertyName("times_found")
    val timesFound: Int = 0
)

// Bölüm Modeli
data class Level(
    @PropertyName("level_id")
    val levelId: Int = 0,
    @PropertyName("region")
    val region: String = "", // Turkey, Japan, South Korea, etc.
    @PropertyName("difficulty")
    val difficulty: Int = 1,
    @PropertyName("target_score")
    val targetScore: Long = 0,
    @PropertyName("time_limit")
    val timeLimit: Int = 0, // seconds, 0 = unlimited
    @PropertyName("words_available")
    val wordsAvailable: Int = 0,
    @PropertyName("is_boss_level")
    val isBossLevel: Boolean = false,
    @PropertyName("boss_name")
    val bossName: String = ""
)

// Oyun İlerleme Modeli
data class GameProgress(
    @PropertyName("user_id")
    val userId: String = "",
    @PropertyName("current_level")
    val currentLevel: Int = 1,
    @PropertyName("completed_levels")
    val completedLevels: List<Int> = emptyList(),
    @PropertyName("current_score")
    val currentScore: Long = 0,
    @PropertyName("session_start_time")
    val sessionStartTime: Long = 0,
    @PropertyName("session_duration")
    val sessionDuration: Long = 0,
    @PropertyName("words_found_in_session")
    val wordsFoundInSession: List<String> = emptyList()
)

// Koleksiyon Modeli
data class Collection(
    @PropertyName("collection_id")
    val collectionId: String = "",
    @PropertyName("collection_type")
    val collectionType: String = "", // scorpions, effects, badges, planets, constellations, frames, chests
    @PropertyName("items_owned")
    val itemsOwned: List<String> = emptyList(),
    @PropertyName("completion_percentage")
    val completionPercentage: Float = 0f,
    @PropertyName("total_items")
    val totalItems: Int = 0
)

// Sandık Modeli
data class Chest(
    @PropertyName("chest_id")
    val chestId: String = "",
    @PropertyName("chest_type")
    val chestType: String = "", // bronze, silver, gold, diamond, cosmic, galactic
    @PropertyName("rewards")
    val rewards: Map<String, Long> = emptyMap(),
    @PropertyName("unlock_time")
    val unlockTime: Long = 0,
    @PropertyName("is_unlocked")
    val isUnlocked: Boolean = false
)

// Lig Modeli
data class League(
    @PropertyName("user_id")
    val userId: String = "",
    @PropertyName("league_tier")
    val leagueTier: String = "", // bronze, silver, gold, diamond, master, legend, galactic, cosmic
    @PropertyName("league_points")
    val leaguePoints: Long = 0,
    @PropertyName("rank")
    val rank: Int = 0,
    @PropertyName("season")
    val season: Int = 1,
    @PropertyName("wins")
    val wins: Int = 0,
    @PropertyName("losses")
    val losses: Int = 0
)

// Boss Modeli
data class Boss(
    @PropertyName("boss_id")
    val bossId: String = "",
    @PropertyName("boss_name")
    val bossName: String = "",
    @PropertyName("boss_type")
    val bossType: String = "", // meteor_monster, nebula_guardian, black_hole_lord, galactic_titan, cosmic_destroyer
    @PropertyName("health")
    val health: Long = 0,
    @PropertyName("max_health")
    val maxHealth: Long = 0,
    @PropertyName("difficulty")
    val difficulty: Int = 1,
    @PropertyName("rewards")
    val rewards: Map<String, Long> = emptyMap(),
    @PropertyName("is_defeated")
    val isDefeated: Boolean = false
)
