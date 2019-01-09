package com.artto.wallpapers.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artto.wallpapers.utils.moxy.MvpAppCompatFragment
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(getLayout(), container, false)

    override fun showProgressBar(show: Boolean) {
        activity?.progress_bar?.visibility = if (show) View.VISIBLE else View.GONE
    }

    abstract fun getLayout(): Int

}