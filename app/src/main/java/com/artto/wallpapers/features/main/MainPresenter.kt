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

    override fun onFirstViewAttach() {
        interact.getPopularWallpapers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { updateItems(it.hits) },
                onError = { it.printStackTrace() })
            .addTo(disposables)
    }

    private fun updateItems(new: List<HitsItem>) {
        items.clear()
        items.addAll(new)
        viewState.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(view: MainRecyclerAdapterContract.ItemView, position: Int) =
        view.setImage(items[position].webformatURL)

    override fun onClicked(position: Int) {}
}