package com.example.data.repository.profile

import com.example.domain.profile.Gender
import com.example.domain.profile.Orientation
import com.example.domain.profile.Profile
import com.example.domain.profile.UserProfile
import java.time.LocalDate

interface ProfileRemoteDataSource {
    suspend fun getUserProfile(): UserProfile
    suspend fun createProfile(
        userId: String,
        name: String,
        birthdate: LocalDate,
        bio: String,
        gender: Gender,
        orientation: Orientation
    )
    suspend fun updateProfile(
        bio: String,
        gender: Gender,
        orientation: Orientation
    )
    suspend fun updateProfile(pictureNames: List<String>)

    suspend fun getProfiles(): List<Profile>
    suspend fun passProfile(profile: Profile)
    suspend fun likeProfile(profile: Profile): String?
}