package com.akrep.gmi.galactic.game

import java.util.UUID

data class GameRoom(
    val roomId: String = UUID.randomUUID().toString(),
    val roomCode: String = generateRoomCode(),
    val hostId: String = "",
    val players: List<String> = emptyList(),
    val maxPlayers: Int = 8,
    val gameMode: String = "", // timed, free, boss_battle
    val timeLimit: Int = 0, // seconds
    val isActive: Boolean = true,
    val createdAt: Long = System.currentTimeMillis()
)

data class PlayerScore(
    val playerId: String = "",
    val playerName: String = "",
    val score: Long = 0,
    val wordsFound: Int = 0,
    val rank: Int = 0,
    val lastUpdate: Long = System.currentTimeMillis()
)

class MultiplayerSystem {
    
    private val activeRooms = mutableMapOf<String, GameRoom>()
    private val roomScores = mutableMapOf<String, MutableList<PlayerScore>>()
    
    fun createRoom(hostId: String, maxPlayers: Int = 8, gameMode: String = "free"): GameRoom {
        val room = GameRoom(
            hostId = hostId,
            maxPlayers = maxPlayers,
            gameMode = gameMode
        )
        activeRooms[room.roomId] = room
        roomScores[room.roomId] = mutableListOf()
        return room
    }
    
    fun joinRoom(roomCode: String, playerId: String, playerName: String): Result<GameRoom> {
        val room = activeRooms.values.find { it.roomCode == roomCode }
            ?: return Result.failure(Exception("Oda bulunamadı"))
        
        if (room.players.size >= room.maxPlayers) {
            return Result.failure(Exception("Oda dolu"))
        }
        
        val updatedRoom = room.copy(
            players = room.players + playerId
        )
        activeRooms[room.roomId] = updatedRoom
        
        // Oyuncuyu skor listesine ekle
        roomScores[room.roomId]?.add(
            PlayerScore(playerId = playerId, playerName = playerName)
        )
        
        return Result.success(updatedRoom)
    }
    
    fun leaveRoom(roomId: String, playerId: String): Result<Unit> {
        val room = activeRooms[roomId] ?: return Result.failure(Exception("Oda bulunamadı"))
        
        val updatedRoom = room.copy(
            players = room.players.filter { it != playerId }
        )
        
        if (updatedRoom.players.isEmpty()) {
            activeRooms.remove(roomId)
            roomScores.remove(roomId)
        } else {
            activeRooms[roomId] = updatedRoom
        }
        
        roomScores[roomId]?.removeAll { it.playerId == playerId }
        
        return Result.success(Unit)
    }
    
    fun updatePlayerScore(roomId: String, playerId: String, score: Long, wordsFound: Int) {
        val scores = roomScores[roomId] ?: return
        val playerIndex = scores.indexOfFirst { it.playerId == playerId }
        
        if (playerIndex >= 0) {
            scores[playerIndex] = scores[playerIndex].copy(
                score = score,
                wordsFound = wordsFound,
                lastUpdate = System.currentTimeMillis()
            )
            
            // Sıralamayı güncelle
            scores.sortByDescending { it.score }
            scores.forEachIndexed { index, playerScore ->
                scores[index] = playerScore.copy(rank = index + 1)
            }
        }
    }
    
    fun getRoomScores(roomId: String): List<PlayerScore> {
        return roomScores[roomId]?.sortedBy { it.rank } ?: emptyList()
    }
    
    fun getRoom(roomId: String): GameRoom? {
        return activeRooms[roomId]
    }
    
    fun getRoomByCode(roomCode: String): GameRoom? {
        return activeRooms.values.find { it.roomCode == roomCode }
    }
    
    fun closeRoom(roomId: String) {
        activeRooms.remove(roomId)
        roomScores.remove(roomId)
    }
    
    companion object {
        fun generateRoomCode(): String {
            return (1000..9999).random().toString()
        }
    }
}
