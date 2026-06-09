package com.akrep.gmi.galactic.game

data class LeagueRank(
    val tier: String,
    val minPoints: Long,
    val maxPoints: Long,
    val rewards: Map<String, Long>
)

class LeagueSystem {
    
    private val leagueRanks = listOf(
        LeagueRank("bronze", 0, 499, mapOf("gold" to 100, "diamonds" to 0)),
        LeagueRank("silver", 500, 999, mapOf("gold" to 250, "diamonds" to 5)),
        LeagueRank("gold", 1000, 1999, mapOf("gold" to 500, "diamonds" to 15)),
        LeagueRank("diamond", 2000, 4999, mapOf("gold" to 1000, "diamonds" to 50)),
        LeagueRank("master", 5000, 9999, mapOf("gold" to 2500, "diamonds" to 100)),
        LeagueRank("legend", 10000, 19999, mapOf("gold" to 5000, "diamonds" to 250)),
        LeagueRank("galactic", 20000, 49999, mapOf("gold" to 10000, "diamonds" to 500)),
        LeagueRank("cosmic", 50000, Long.MAX_VALUE, mapOf("gold" to 25000, "diamonds" to 1000))
    )
    
    fun getCurrentLeague(points: Long): LeagueRank {
        return leagueRanks.find { points >= it.minPoints && points <= it.maxPoints }
            ?: leagueRanks.last()
    }
    
    fun getNextLeague(currentPoints: Long): LeagueRank? {
        val currentLeague = getCurrentLeague(currentPoints)
        return leagueRanks.find { it.tier == currentLeague.tier }?.let { current ->
            leagueRanks.getOrNull(leagueRanks.indexOf(current) + 1)
        }
    }
    
    fun getPointsNeededForNextLeague(currentPoints: Long): Long {
        val nextLeague = getNextLeague(currentPoints) ?: return 0
        return nextLeague.minPoints - currentPoints
    }
    
    fun addLeaguePoints(currentPoints: Long, wordPoints: Long): Long {
        return currentPoints + wordPoints
    }
    
    fun getLeagueRewards(tier: String): Map<String, Long> {
        return leagueRanks.find { it.tier == tier }?.rewards ?: emptyMap()
    }
    
    fun calculateRank(playerPoints: Long, totalPlayers: Int): Int {
        // Basit hesaplama: oyuncuların kaç tanesinin daha fazla puanı var
        return (totalPlayers * (1 - (playerPoints.toFloat() / 100000))).toInt() + 1
    }
}
