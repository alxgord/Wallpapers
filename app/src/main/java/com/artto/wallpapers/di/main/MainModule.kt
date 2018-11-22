package com.artto.wallpapers.di.main

import com.artto.wallpapers.data.network.WallpaperRepository
import com.artto.wallpapers.di.scope.ViewScope
import com.artto.wallpapers.features.main.MainInteract
import com.artto.wallpapers.features.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @ViewScope
    fun interact(wallpaperRepository: WallpaperRepository) = MainInteract(wallpaperRepository)

    @Provides
    @ViewScope
    fun presenter(interact: MainInteract) = MainPresenter(interact)

}