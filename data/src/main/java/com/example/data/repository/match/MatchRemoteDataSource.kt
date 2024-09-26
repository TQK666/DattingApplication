package com.example.data.repository.match

import com.example.domain.match.Match

interface MatchRemoteDataSource {
    suspend fun getMatches(): List<Match>
    suspend fun getMatch(id: String): Match
}