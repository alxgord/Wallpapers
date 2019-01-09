package com.artto.wallpapers.ui.base

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T: BaseView> : MvpPresenter<T>() {

    protected val disposables = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }

}