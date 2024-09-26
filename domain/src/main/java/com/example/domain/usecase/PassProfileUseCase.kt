package com.example.domain.usecase

import com.example.domain.profile.Profile
import com.example.domain.profile.ProfileRepository

class PassProfileUseCase(private val profileRepository: ProfileRepository) {

    suspend operator fun invoke(profile: Profile): Result<Unit> {
        return Result.runCatching { profileRepository.passProfile(profile) }
    }
}