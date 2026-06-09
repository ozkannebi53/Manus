package com.akrep.gmi.galactic.game

import com.akrep.gmi.galactic.data.WordDictionary
import kotlin.math.pow

class WordGameEngine {
    
    private var currentLevel = 1
    private var currentScore = 0L
    private var wordsFound = mutableListOf<String>()
    private var currentStreak = 0
    private var availableLetters = mutableListOf<Char>()
    private var levelWords = mutableListOf<String>()
    
    fun initializeLevel(level: Int) {
        currentLevel = level
        currentScore = 0
        wordsFound.clear()
        currentStreak = 0
        
        // Seviyeye göre zorluk ayarla
        val difficulty = calculateDifficulty(level)
        val wordCount = 5 + (level / 5)
        
        levelWords = WordDictionary.getRandomWords(wordCount).toMutableList()
        generateAvailableLetters()
    }
    
    fun generateAvailableLetters() {
        val allLetters = mutableListOf<Char>()
        
        // Seviyedeki tüm kelimelerdeki harfleri topla
        for (word in levelWords) {
            allLetters.addAll(word.toCharArray().toList())
        }
        
        // Rastgele harfler ekle
        val turkishLetters = "ABCÇDEFGĞHIİJKLMNÖPRSŞTUÜVYZ"
        repeat(5) {
            allLetters.add(turkishLetters.random())
        }
        
        availableLetters = allLetters.shuffled().toMutableList()
    }
    
    fun checkWord(word: String): WordCheckResult {
        val upperWord = word.uppercase()
        
        // Kelime sözlükte var mı?
        if (!WordDictionary.turkishWords.containsKey(upperWord)) {
            return WordCheckResult(
                isValid = false,
                message = "Kelime sözlükte bulunamadı",
                points = 0
            )
        }
        
        // Kelime zaten bulundu mu?
        if (wordsFound.contains(upperWord)) {
            return WordCheckResult(
                isValid = false,
                message = "Bu kelimeyi zaten buldunuz",
                points = 0
            )
        }
        
        // Harfler mevcut mu?
        if (!canFormWord(upperWord)) {
            return WordCheckResult(
                isValid = false,
                message = "Bu harfleri kullanamazsınız",
                points = 0
            )
        }
        
        // Geçerli kelime
        wordsFound.add(upperWord)
        val points = calculatePoints(upperWord)
        currentScore += points
        currentStreak++
        
        // Bonus puan (kombo)
        val bonusMultiplier = 1 + (currentStreak / 5) * 0.1f
        val totalPoints = (points * bonusMultiplier).toInt()
        
        return WordCheckResult(
            isValid = true,
            message = "Doğru! +$totalPoints puan",
            points = totalPoints,
            isCombo = currentStreak > 1,
            comboCount = currentStreak
        )
    }
    
    private fun canFormWord(word: String): Boolean {
        val availableCopy = availableLetters.toMutableList()
        
        for (char in word) {
            if (!availableCopy.contains(char)) {
                return false
            }
            availableCopy.remove(char)
        }
        
        return true
    }
    
    private fun calculatePoints(word: String): Int {
        val basePoints = word.length * 10
        val difficulty = calculateDifficulty(currentLevel)
        val multiplier = 1 + (difficulty * 0.2f)
        
        return (basePoints * multiplier).toInt()
    }
    
    private fun calculateDifficulty(level: Int): Int {
        return minOf(5, 1 + (level / 10))
    }
    
    fun getAvailableLetters(): List<Char> = availableLetters
    
    fun getLevelWords(): List<String> = levelWords
    
    fun getFoundWords(): List<String> = wordsFound
    
    fun getCurrentScore(): Long = currentScore
    
    fun getCurrentStreak(): Int = currentStreak
    
    fun getCurrentLevel(): Int = currentLevel
    
    fun resetStreak() {
        currentStreak = 0
    }
}

data class WordCheckResult(
    val isValid: Boolean,
    val message: String,
    val points: Int,
    val isCombo: Boolean = false,
    val comboCount: Int = 0
)
