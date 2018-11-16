package com.artto.wallpapers.di.main

import com.artto.wallpapers.di.scope.ViewScope
import com.artto.wallpapers.features.main.MainPresenter
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
@ViewScope
interface MainComponent {

    fun presenter(): MainPresenter

}