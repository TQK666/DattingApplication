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
import com.example.data.source.MatchDataSourceImpl
import com.example.data.source.MessageDataSourceImpl
import com.example.data.source.PictureDataSourceImpl
import com.example.data.source.ProfileDataSourceImpl
import com.example.domain.match.MatchRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProfileRepository> { ProfileRepositoryImpl(get()) }
    single<PictureRepository> { PictureRepositoryImpl(get()) }
    single<MessageRepository> { MessageRepositoryImpl(get()) }
    single<MatchRepository> { MatchRepositoryImpl(get()) }
}

val sourceModule = module {
    single<PictureRemoteDataSource> { PictureDataSourceImpl(get()) }
    single<ProfileRemoteDataSource> { ProfileDataSourceImpl() }
    single<MessageRemoteDataSource> { MessageDataSourceImpl() }
    single<MatchRemoteDataSource> { MatchDataSourceImpl() }
}

val dataModule = module {
    includes(repositoryModule)
    includes(sourceModule)
}