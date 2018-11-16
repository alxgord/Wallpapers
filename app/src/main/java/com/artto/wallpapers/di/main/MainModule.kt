package com.artto.wallpapers.di.main

import com.artto.wallpapers.di.scope.ViewScope
import com.artto.wallpapers.features.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @ViewScope
    fun presenter() = MainPresenter()

}