package com.artto.wallpapers.features.main

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.artto.wallpapers.features.base.BaseView

interface MainView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun notifyDataSetChanged()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun notifyItemRangeInserted(position: Int, count: Int)

}