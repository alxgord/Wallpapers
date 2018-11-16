package com.artto.wallpapers.features.main

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.artto.wallpapers.ApplicationLoader
import com.artto.wallpapers.R
import com.artto.wallpapers.di.main.MainModule
import com.artto.wallpapers.features.base.BaseActivity

class MainActivity : BaseActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = ApplicationLoader.applicationComponent.main(MainModule()).presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
