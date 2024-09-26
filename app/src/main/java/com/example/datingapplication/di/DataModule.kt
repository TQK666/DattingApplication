package com.example.datingapplication.di

import com.example.domain.message.MessageRepository
import com.example.domain.picture.PictureRepository
import com.example.domain.profile.ProfileRepository
import com.example.data.repository.match.MatchRemoteDataSource
import com.example.data.repository.match.MatchRepositoryImpl
import com.example.data.repository.message.MessageRemoteDataSource
import com.example.data.repository.message.MessageRepositoryImpl
import com.example.data.repository.picture.PictureRemoteDataSource
import com.example.data.repository.picture.PictureRepositoryImpl
import com.example.data.repository.profile.ProfileRemoteDataSource
import com.example.data.repository.profile.ProfileRepositoryImpl
import com.example.data.source.MatchRemoteDataSourceMockImpl
import com.example.data.source.MessageRemoteDataSourceMockImpl
import com.example.data.source.PictureRemoteDataSourceMockImpl
import com.example.data.source.ProfileRemoteDataSourceMockImpl
import com.example.domain.match.MatchRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProfileRepository> { ProfileRepositoryImpl(get()) }
    single<PictureRepository> { PictureRepositoryImpl(get()) }
    single<MessageRepository> { MessageRepositoryImpl(get()) }
    single<MatchRepository> { MatchRepositoryImpl(get()) }
}

val sourceModule = module {
    single<PictureRemoteDataSource> { PictureRemoteDataSourceMockImpl(get()) }
    single<ProfileRemoteDataSource> { ProfileRemoteDataSourceMockImpl() }
    single<MessageRemoteDataSource> { MessageRemoteDataSourceMockImpl() }
    single<MatchRemoteDataSource> { MatchRemoteDataSourceMockImpl() }
}

val dataModule = module {
    includes(repositoryModule)
    includes(sourceModule)
}