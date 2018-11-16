package com.artto.wallpapers

import android.app.Application
import com.artto.wallpapers.di.application.ApplicationComponent
import com.artto.wallpapers.di.application.ApplicationModule
import com.artto.wallpapers.di.application.DaggerApplicationComponent

class ApplicationLoader : Application() {

    companion object {

        private lateinit var application: ApplicationLoader

        val applicationComponent
            get() = application.applicationComponent

    }

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        application = this
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

}