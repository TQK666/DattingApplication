package com.example.datingapplication

import android.app.Application
import com.example.datingapplication.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MainApp)
            modules(appModule)
        }
    }
}