package com.akrep.gmi.galactic.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await

class FirestoreService(private val firestore: FirebaseFirestore = FirebaseConfig.firestore) {

    suspend fun saveUserData(userId: String, userData: Map<String, Any>): Result<Unit> {
        return try {
            firestore.collection("users").document(userId)
                .set(userData, SetOptions.merge()).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUserData(userId: String): Result<Map<String, Any>?> {
        return try {
            val document = firestore.collection("users").document(userId).get().await()
            Result.success(document.data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun saveGameProgress(userId: String, progress: Map<String, Any>): Result<Unit> {
        return try {
            firestore.collection("users").document(userId)
                .collection("progress").document("current")
                .set(progress, SetOptions.merge()).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getGameProgress(userId: String): Result<Map<String, Any>?> {
        return try {
            val document = firestore.collection("users").document(userId)
                .collection("progress").document("current").get().await()
            Result.success(document.data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun saveLeaderboardEntry(userId: String, score: Long, level: Int): Result<Unit> {
        return try {
            firestore.collection("leaderboard").document(userId)
                .set(mapOf(
                    "score" to score,
                    "level" to level,
                    "timestamp" to System.currentTimeMillis()
                ), SetOptions.merge()).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getLeaderboard(limit: Int = 100): Result<List<Map<String, Any>>> {
        return try {
            val documents = firestore.collection("leaderboard")
                .orderBy("score", com.google.firebase.firestore.Query.Direction.DESCENDING)
                .limit(limit.toLong())
                .get().await()
            Result.success(documents.documents.map { it.data ?: emptyMap() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
