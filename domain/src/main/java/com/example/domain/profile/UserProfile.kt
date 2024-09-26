package com.example.domain.profile

import com.example.domain.profile.Gender
import com.example.domain.profile.Orientation
import java.time.LocalDate

data class UserProfile(val id:String="",
                       val name: String="",
                       val birthDate: LocalDate,
                       val bio: String = "",
                       val gender: Gender,
                       val orientation: Orientation,
                       val pictureNames: List<String>)
