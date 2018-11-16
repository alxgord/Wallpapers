package com.artto.wallpapers.di.application

import android.content.Context
import com.artto.wallpapers.ApplicationLoader
import com.artto.wallpapers.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: ApplicationLoader) {

    @Provides
    @ApplicationScope
    fun context(): Context = application

}