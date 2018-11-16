package com.artto.wallpapers.di.application

import com.artto.wallpapers.di.data.WallpaperApiModule
import com.artto.wallpapers.di.main.MainComponent
import com.artto.wallpapers.di.main.MainModule
import com.artto.wallpapers.di.scope.ApplicationScope
import dagger.Component

@Component(
    modules = [
        ApplicationModule::class,
        WallpaperApiModule::class]
)
@ApplicationScope
interface ApplicationComponent {

    fun main(module: MainModule): MainComponent

}