package com.artto.wallpapers.features.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.artto.wallpapers.ApplicationLoader
import com.artto.wallpapers.EndlessRecyclerViewScrollListener
import com.artto.wallpapers.OnLoadMoreListener
import com.artto.wallpapers.R
import com.artto.wallpapers.di.main.MainModule
import com.artto.wallpapers.features.base.BaseActivity
import com.artto.wallpapers.features.main.recycler.MainRecyclerAdapter
import com.artto.wallpapers.features.main.recycler.MainRecyclerItemDecorator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = ApplicationLoader.applicationComponent.main(MainModule()).presenter()

    private lateinit var recyclerAdapter: MainRecyclerAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val columns = 3
        val itemWidth = (resources.displayMetrics.widthPixels / columns)
        val itemHeight = (itemWidth * 1.7).toInt()

        gridLayoutManager = GridLayoutManager(recycler_view_main.context, columns)
        recyclerAdapter = MainRecyclerAdapter(presenter, presenter, itemWidth, itemHeight)
        with(recycler_view_main) {
            adapter = recyclerAdapter
            layoutManager = gridLayoutManager
            addItemDecoration(MainRecyclerItemDecorator(8, columns))
            addOnScrollListener(EndlessRecyclerViewScrollListener(gridLayoutManager, object : OnLoadMoreListener {
                override fun onLoadMore() {
                    presenter.onLoadMore()
                }
            }))
        }
    }

    override fun notifyDataSetChanged() = recyclerAdapter.notifyDataSetChanged()

    override fun notifyItemRangeInserted(position: Int, count: Int) = recyclerAdapter.notifyItemRangeInserted(position, count)

}
