package com.artto.wallpapers

import android.app.Application
import com.artto.wallpapers.di.dataModule
import com.artto.wallpapers.di.uiModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(uiModule, dataModule))
    }

}