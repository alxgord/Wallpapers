package com.artto.wallpapers.ui.categories

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.artto.wallpapers.ui.base.BaseView

interface CategoriesView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun notifyItemRangeInserted(position: Int, count: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun navigateToCategory(category: String)

}