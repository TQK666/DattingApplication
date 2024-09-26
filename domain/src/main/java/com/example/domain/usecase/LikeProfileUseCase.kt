package com.example.domain.usecase

import com.example.domain.match.Match
import com.example.domain.match.MatchRepository
import com.example.domain.profile.Profile
import com.example.domain.profile.ProfileRepository

class LikeProfileUseCase(private val profileRepository: ProfileRepository, private val matchRepository: MatchRepository) {

    suspend operator fun invoke(profile: Profile): Result<Match?> {
        return Result.runCatching {
            profileRepository.likeProfile(profile)?.let {
                matchRepository.getMatch(it)
            }
        }
    }
}