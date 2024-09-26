package com.example.datingapplication.di

import com.example.domain.usecase.GetPictureUseCase
import com.example.domain.usecase.GetProfilesUseCase
import com.example.domain.usecase.LikeProfileUseCase
import com.example.domain.usecase.PassProfileUseCase
import com.example.domain.usecase.SendMessageUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { LikeProfileUseCase(get(), get()) }
    factory { PassProfileUseCase(get()) }
    factory { SendMessageUseCase(get()) }
    factory { GetProfilesUseCase(get()) }
    factory { GetPictureUseCase(get()) }
}