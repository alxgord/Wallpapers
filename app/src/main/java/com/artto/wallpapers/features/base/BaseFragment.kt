package com.artto.wallpapers.features.base

import com.arellomobile.mvp.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    protected val router: BaseRouter
        get() = (parentFragment ?: activity) as BaseRouter

}