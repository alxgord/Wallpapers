package com.artto.wallpapers.features.main

import com.arellomobile.mvp.InjectViewState
import com.artto.wallpapers.data.network.response.HitsItem
import com.artto.wallpapers.features.base.BasePresenter
import com.artto.wallpapers.features.main.recycler.MainRecyclerAdapterContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

@InjectViewState
class MainPresenter(private val interact: MainInteract) : BasePresenter<MainView>(),
    MainRecyclerAdapterContract.AdapterPresenter,
    MainRecyclerAdapterContract.ItemPresenter {

    private val items = ArrayList<HitsItem>()

    private val itemsPerPage = 30

    private var hasNext = true
    private var nextPage = 2

    override fun onFirstViewAttach() {
        getPopulartWallpapers()
    }

    private fun getPopulartWallpapers() {
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

    override fun onBindViewHolder(view: MainRecyclerAdapterContract.ItemView, position: Int) =
        view.setImage(items[position].webformatURL)

    override fun onClicked(position: Int) {}

    fun onLoadMore() {
        getPopulartWallpapers()
    }
}