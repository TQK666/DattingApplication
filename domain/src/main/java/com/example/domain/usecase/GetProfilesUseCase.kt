package com.example.domain.usecase

import com.example.domain.profile.Profile
import com.example.domain.profile.ProfileRepository

class GetProfilesUseCase(private val profileRepository: ProfileRepository) {

    suspend operator fun invoke(): Result<List<Profile>> {
       return Result.runCatching {
            profileRepository.getProfiles()
        }
    }
}