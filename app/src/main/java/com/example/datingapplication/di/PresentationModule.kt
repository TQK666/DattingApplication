package com.example.datingapplication.di

import com.example.datingapplication.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    //View models
    viewModel { HomeViewModel(get(), get(), get(), get()) }
}