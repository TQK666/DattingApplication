package com.example.domain.match

import com.example.domain.profile.Profile
import java.time.LocalDate

data class Match(
    val id: String,
    val profile: Profile,
    val creationDate: LocalDate,
    val lastMessage: String?
)
