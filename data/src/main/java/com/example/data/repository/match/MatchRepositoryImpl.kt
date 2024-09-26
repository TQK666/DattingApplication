package com.example.data.repository.match

import com.example.domain.match.Match
import com.example.domain.match.MatchRepository

class MatchRepositoryImpl(
    private val matchRemoteDataSource: MatchRemoteDataSource
): MatchRepository {

    override suspend fun getMatches(): List<Match> = matchRemoteDataSource.getMatches()

    override suspend fun getMatch(id: String): Match {
        return matchRemoteDataSource.getMatch(id)
    }

}