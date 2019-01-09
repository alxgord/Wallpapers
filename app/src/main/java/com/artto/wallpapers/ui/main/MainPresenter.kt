package com.artto.wallpapers.ui.main

import com.arellomobile.mvp.InjectViewState
import ua.corteva.data.network.response.HitsItem
import com.artto.wallpapers.ui.base.BasePresenter
import com.artto.wallpapers.ui.main.recycler.AdapterPresenter
import com.artto.wallpapers.ui.main.recycler.ItemView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

@InjectViewState
class MainPresenter(private val interact: MainInteract) : BasePresenter<MainView>(),
    AdapterPresenter {

    private val items = ArrayList<HitsItem>()

    private val itemsPerPage = 30

    private var hasNext = true
    private var nextPage = 2

    override fun onFirstViewAttach() {
        getPopularWallpapers()
    }

    private fun getPopularWallpapers() {
        if (hasNext)
            interact.getPopularWallpapers(page = nextPage.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        updateItems(it.hits)
                        hasNext = it.totalHits - items.size >= itemsPerPage
                        if (hasNext) nextPage++
                    },
                    onError = { it.printStackTrace() })
                .addTo(disposables)
    }

    private fun updateItems(new: List<HitsItem>) {
        val position = items.size
        items.addAll(new)
        viewState.notifyItemRangeInserted(position, new.size)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(view: ItemView, position: Int) = view.setData(items[position].webformatURL) {}

    fun onLoadMore() {
        getPopularWallpapers()
    }
}