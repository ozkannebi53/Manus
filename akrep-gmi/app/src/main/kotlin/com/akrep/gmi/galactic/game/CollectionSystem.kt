package com.akrep.gmi.galactic.game

class CollectionSystem {
    
    private val collections = mutableMapOf<String, MutableSet<String>>(
        "scorpions" to mutableSetOf(),
        "effects" to mutableSetOf(),
        "badges" to mutableSetOf(),
        "planets" to mutableSetOf(),
        "constellations" to mutableSetOf(),
        "frames" to mutableSetOf(),
        "chests" to mutableSetOf()
    )
    
    private val totalItems = mapOf(
        "scorpions" to 11,
        "effects" to 20,
        "badges" to 50,
        "planets" to 20,
        "constellations" to 15,
        "frames" to 30,
        "chests" to 6
    )
    
    fun addItem(collectionType: String, itemId: String) {
        collections[collectionType]?.add(itemId)
    }
    
    fun hasItem(collectionType: String, itemId: String): Boolean {
        return collections[collectionType]?.contains(itemId) ?: false
    }
    
    fun getCollectionProgress(collectionType: String): Pair<Int, Int> {
        val owned = collections[collectionType]?.size ?: 0
        val total = totalItems[collectionType] ?: 0
        return Pair(owned, total)
    }
    
    fun getCollectionPercentage(collectionType: String): Float {
        val (owned, total) = getCollectionProgress(collectionType)
        return if (total > 0) (owned.toFloat() / total) * 100 else 0f
    }
    
    fun getTotalProgress(): Float {
        var totalOwned = 0
        var totalCount = 0
        
        for ((type, items) in collections) {
            totalOwned += items.size
            totalCount += totalItems[type] ?: 0
        }
        
        return if (totalCount > 0) (totalOwned.toFloat() / totalCount) * 100 else 0f
    }
    
    fun getCompletionRewards(collectionType: String): Map<String, Long> {
        val (owned, total) = getCollectionProgress(collectionType)
        
        return if (owned == total) {
            when (collectionType) {
                "scorpions" -> mapOf("diamonds" to 500, "gold" to 5000)
                "effects" -> mapOf("diamonds" to 300, "gold" to 3000)
                "badges" -> mapOf("diamonds" to 200, "gold" to 2000)
                "planets" -> mapOf("diamonds" to 250, "gold" to 2500)
                "constellations" -> mapOf("diamonds" to 300, "gold" to 3000)
                "frames" -> mapOf("diamonds" to 200, "gold" to 2000)
                "chests" -> mapOf("diamonds" to 100, "gold" to 1000)
                else -> emptyMap()
            }
        } else emptyMap()
    }
    
    fun getMissingItems(collectionType: String): List<String> {
        val allItems = getAllItemsForCollection(collectionType)
        val owned = collections[collectionType] ?: mutableSetOf()
        return allItems.filter { !owned.contains(it) }
    }
    
    private fun getAllItemsForCollection(collectionType: String): List<String> {
        return when (collectionType) {
            "scorpions" -> listOf(
                "sand_scorpion", "desert_scorpion", "ice_scorpion", "crystal_scorpion",
                "electric_scorpion", "fire_scorpion", "nebula_scorpion", "black_hole_scorpion",
                "cosmic_scorpion", "galactic_scorpion", "cosmic_king_scorpion"
            )
            "planets" -> listOf(
                "turkey", "japan", "south_korea", "china", "india",
                "germany", "france", "brazil", "usa", "canada",
                "australia", "russia", "mexico", "spain", "italy",
                "uk", "south_africa", "egypt", "greece", "thailand"
            )
            "constellations" -> listOf(
                "scorpius", "dragon", "phoenix", "lion", "eagle",
                "bear", "swan", "serpent", "wolf", "tiger",
                "fox", "raven", "butterfly", "comet", "nebula"
            )
            else -> (1..totalItems[collectionType]!!).map { "$collectionType-$it" }
        }
    }
}
