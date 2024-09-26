package com.example.data.source

import com.example.domain.profile.Gender
import com.example.domain.profile.Orientation
import com.example.domain.profile.Profile
import com.example.domain.profile.UserProfile
import com.example.data.repository.profile.ProfileRemoteDataSource
import kotlinx.coroutines.delay
import java.time.LocalDate
import java.util.UUID
import kotlin.random.Random

class ProfileDataSourceImpl : ProfileRemoteDataSource {
    private val userProfile = UserProfile(
        "mock_user",
        "John Doe",
        LocalDate.of(2000, 1, 1),
        "A lover of libraries, coffee, and perhaps, you.",
        Gender.MALE,
        Orientation.WOMEN,
        listOf("man_1.jpg, man_2.jpg", "man_3.jpg")
    )
    override suspend fun getUserProfile(): UserProfile = userProfile

    override suspend fun createProfile(
        userId: String,
        name: String,
        birthdate: LocalDate,
        bio: String,
        gender: Gender,
        orientation: Orientation
    ) {
        delay(2000)
    }

    override suspend fun updateProfile(
        bio: String,
        gender: Gender,
        orientation: Orientation
    ) {
        delay(2000)
    }

    override suspend fun updateProfile(pictureNames: List<String>) {
        delay(2000)
    }

    override suspend fun getProfiles(): List<Profile> {
        delay(1000)
        return (0 until 10).map { getRandomProfile() }.toList()
    }

    override suspend fun passProfile(profile: Profile) {}

    override suspend fun likeProfile(profile: Profile): String? = null

    private fun getRandomProfile(): Profile {
        val name = getRandomName()
        val age = getRandomAge()
        val gender = "woman"
        return Profile(getRandomUserId(), name, age, (0..5).map { "${gender}_${Random.nextInt(1, 43)}.jpg" })
    }

    private fun getRandomUserId(): String = UUID.randomUUID().toString()
    private fun getRandomName(): String = femaleNames.random()
    private fun getRandomAge(): Int = Random.nextInt(18, 30)

    private val femaleNames = listOf(
        "Ngọc" ,
        "Mỹ" ,
        "Tuyền" ,
        "Phương" ,
        "Ly" ,
        "Na" ,
        "Nhi" ,
        "Yến" ,
        "Hạnh" ,
        "Trà" ,
        "Loan" ,
        "Linh" ,
        "Hằng" ,
    )
}