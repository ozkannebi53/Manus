package com.akrep.gmi.galactic.game

import com.akrep.gmi.galactic.models.Scorpion

class ScorpionPetSystem {
    
    private val scorpionEvolutions = mapOf(
        "sand_scorpion" to SandScorpion(),
        "desert_scorpion" to DesertScorpion(),
        "ice_scorpion" to IceScorpion(),
        "crystal_scorpion" to CrystalScorpion(),
        "electric_scorpion" to ElectricScorpion(),
        "fire_scorpion" to FireScorpion(),
        "nebula_scorpion" to NebulaScorpion(),
        "black_hole_scorpion" to BlackHoleScorpion(),
        "cosmic_scorpion" to CosmicScorpion(),
        "galactic_scorpion" to GalacticScorpion(),
        "cosmic_king_scorpion" to CosmicKingScorpion()
    )
    
    fun createInitialScorpion(): Scorpion {
        return Scorpion(
            id = "sand_scorpion",
            name = "Kum Akrebi",
            type = "sand",
            level = 1,
            experience = 0,
            rarity = "common",
            specialEffects = listOf("breathing", "moving"),
            evolutionStage = 1,
            isActive = true
        )
    }
    
    fun addExperience(scorpion: Scorpion, experience: Long): Scorpion {
        var newScorpion = scorpion.copy(
            experience = scorpion.experience + experience
        )
        
        // Seviye atlaması kontrol et
        val experiencePerLevel = 100L * scorpion.level
        if (newScorpion.experience >= experiencePerLevel) {
            newScorpion = newScorpion.copy(
                level = newScorpion.level + 1,
                experience = newScorpion.experience - experiencePerLevel
            )
            
            // Evrim kontrol et
            newScorpion = checkEvolution(newScorpion)
        }
        
        return newScorpion
    }
    
    private fun checkEvolution(scorpion: Scorpion): Scorpion {
        val evolutionThresholds = mapOf(
            1 to "sand_scorpion",
            5 to "desert_scorpion",
            10 to "ice_scorpion",
            15 to "crystal_scorpion",
            20 to "electric_scorpion",
            25 to "fire_scorpion",
            30 to "nebula_scorpion",
            40 to "black_hole_scorpion",
            50 to "cosmic_scorpion",
            75 to "galactic_scorpion",
            100 to "cosmic_king_scorpion"
        )
        
        val nextEvolution = evolutionThresholds[scorpion.level]
        if (nextEvolution != null && nextEvolution != scorpion.id) {
            val newScorpionType = scorpionEvolutions[nextEvolution]
            if (newScorpionType != null) {
                return scorpion.copy(
                    id = nextEvolution,
                    name = newScorpionType.name,
                    type = newScorpionType.type,
                    rarity = newScorpionType.rarity,
                    specialEffects = newScorpionType.specialEffects,
                    evolutionStage = scorpion.evolutionStage + 1
                )
            }
        }
        
        return scorpion
    }
    
    fun getScorpionReaction(result: String): String {
        return when (result) {
            "perfect" -> "🦂😎 Mükemmel!"
            "combo" -> "🦂🔥 Efsane!"
            "long_word" -> "🦂👑 Kelime Ustası!"
            "wrong" -> "🦂😅 Tekrar Dene"
            else -> "🦂"
        }
    }
    
    fun getScorpionAnimation(reaction: String): String {
        return when (reaction) {
            "perfect" -> "celebrate"
            "combo" -> "excited"
            "long_word" -> "proud"
            "wrong" -> "sad"
            else -> "idle"
        }
    }
}

// Akrep türleri
abstract class ScorpionType {
    abstract val name: String
    abstract val type: String
    abstract val rarity: String
    abstract val specialEffects: List<String>
}

class SandScorpion : ScorpionType() {
    override val name = "Kum Akrebi"
    override val type = "sand"
    override val rarity = "common"
    override val specialEffects = listOf("breathing", "moving")
}

class DesertScorpion : ScorpionType() {
    override val name = "Çöl Akrebi"
    override val type = "desert"
    override val rarity = "common"
    override val specialEffects = listOf("breathing", "moving", "heat_wave")
}

class IceScorpion : ScorpionType() {
    override val name = "Buz Akrebi"
    override val type = "ice"
    override val rarity = "rare"
    override val specialEffects = listOf("breathing", "moving", "frost_aura")
}

class CrystalScorpion : ScorpionType() {
    override val name = "Kristal Akrebi"
    override val type = "crystal"
    override val rarity = "rare"
    override val specialEffects = listOf("breathing", "moving", "crystal_shine")
}

class ElectricScorpion : ScorpionType() {
    override val name = "Elektrik Akrebi"
    override val type = "electric"
    override val rarity = "epic"
    override val specialEffects = listOf("breathing", "moving", "electric_spark")
}

class FireScorpion : ScorpionType() {
    override val name = "Ateş Akrebi"
    override val type = "fire"
    override val rarity = "epic"
    override val specialEffects = listOf("breathing", "moving", "fire_aura")
}

class NebulaScorpion : ScorpionType() {
    override val name = "Nebula Akrebi"
    override val type = "nebula"
    override val rarity = "epic"
    override val specialEffects = listOf("breathing", "moving", "nebula_glow")
}

class BlackHoleScorpion : ScorpionType() {
    override val name = "Kara Delik Akrebi"
    override val type = "black_hole"
    override val rarity = "legendary"
    override val specialEffects = listOf("breathing", "moving", "gravity_pull")
}

class CosmicScorpion : ScorpionType() {
    override val name = "Kozmik Akrebi"
    override val type = "cosmic"
    override val rarity = "legendary"
    override val specialEffects = listOf("breathing", "moving", "cosmic_energy")
}

class GalacticScorpion : ScorpionType() {
    override val name = "Galaktik Akrebi"
    override val type = "galactic"
    override val rarity = "cosmic"
    override val specialEffects = listOf("breathing", "moving", "galactic_pulse")
}

class CosmicKingScorpion : ScorpionType() {
    override val name = "Kozmik Kral Akrep"
    override val type = "cosmic_king"
    override val rarity = "cosmic"
    override val specialEffects = listOf("breathing", "moving", "cosmic_crown", "supreme_power")
}
