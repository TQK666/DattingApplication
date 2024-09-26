package com.example.data.repository.profile

import com.example.domain.profile.Profile
import com.example.domain.profile.ProfileRepository
import com.example.domain.profile.UserProfile
import com.example.domain.profile.Gender
import com.example.domain.profile.Orientation
import java.time.LocalDate

class ProfileRepositoryImpl(
    private val profileRemoteDataSource: ProfileRemoteDataSource
): ProfileRepository {

    override suspend fun getProfile(): UserProfile {
        return profileRemoteDataSource.getUserProfile()
    }

    override suspend fun updateProfile(
        bio: String,
        gender: Gender,
        orientation: Orientation
    ) {
        profileRemoteDataSource.updateProfile(bio, gender, orientation)
    }

    override suspend fun updatePictures(pictureNames: List<String>) {
        profileRemoteDataSource.updateProfile(pictureNames)
    }

    override suspend fun addProfile(
        userId: String,
        name: String,
        birthdate: LocalDate,
        bio: String,
        gender: Gender,
        orientation: Orientation
    ) {
        profileRemoteDataSource.createProfile(userId, name, birthdate, bio, gender, orientation)
    }

    override suspend fun likeProfile(profile: Profile): String? {
        return profileRemoteDataSource.likeProfile(profile)
    }

    override suspend fun passProfile(profile: Profile) {
        profileRemoteDataSource.passProfile(profile)
    }

    override suspend fun getProfiles(): List<Profile> {
        return profileRemoteDataSource.getProfiles()
    }

}