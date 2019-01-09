package com.artto.wallpapers.ui.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.artto.wallpapers.AppConstants
import com.artto.wallpapers.utils.LoadMoreRecyclerViewListener
import com.artto.wallpapers.R
import com.artto.wallpapers.ui.base.BaseFragment
import com.artto.wallpapers.ui.main.recycler.MainRecyclerAdapter
import com.artto.wallpapers.ui.main.recycler.MainRecyclerItemDecorator
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.inject

class MainFragment : BaseFragment(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = inject<MainPresenter>().value

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val columns = AppConstants.MainRecycler.columns
        val itemWidth = (resources.displayMetrics.widthPixels / columns)
        val itemHeight = (itemWidth * AppConstants.MainRecycler.sizeMultiplier).toInt()

        with(recycler_view_main) {
            adapter = MainRecyclerAdapter(presenter, itemWidth, itemHeight)
            addItemDecoration(MainRecyclerItemDecorator(8, columns))
            addOnScrollListener(LoadMoreRecyclerViewListener(layoutManager as GridLayoutManager, presenter::onLoadMore))
        }
    }

    override fun notifyDataSetChanged() {
        recycler_view_main.adapter?.notifyDataSetChanged()
    }

    override fun notifyItemRangeInserted(position: Int, count: Int) {
        recycler_view_main.adapter?.notifyItemRangeInserted(position, count)
    }

    override fun getLayout() = R.layout.fragment_main

}