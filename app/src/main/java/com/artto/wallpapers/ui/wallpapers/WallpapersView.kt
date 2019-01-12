package com.artto.wallpapers.ui.wallpapers

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.artto.wallpapers.ui.base.BaseView

interface WallpapersView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun notifyItemRangeInserted(position: Int, count: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateUp()

}