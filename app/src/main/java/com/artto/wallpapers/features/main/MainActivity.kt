package com.artto.wallpapers.features.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.artto.wallpapers.ApplicationLoader
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val columns = 3
        val itemWidth = (resources.displayMetrics.widthPixels / columns)
        val itemHeight = (itemWidth * 1.7).toInt()

        recyclerAdapter = MainRecyclerAdapter(presenter, presenter, itemWidth, itemHeight)
        with(recycler_view_main) {
            adapter = recyclerAdapter
            layoutManager = GridLayoutManager(context, columns)
            addItemDecoration(MainRecyclerItemDecorator(8, columns))
        }
    }

    override fun notifyDataSetChanged() = recyclerAdapter.notifyDataSetChanged()

}
