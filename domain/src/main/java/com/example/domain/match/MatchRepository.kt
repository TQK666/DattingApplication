package com.example.domain.match

interface MatchRepository {
    suspend fun getMatches(): List<Match>
    suspend fun getMatch(id: String): Match
}