package com.artto.wallpapers.ui.wallpapers

import com.arellomobile.mvp.InjectViewState
import com.artto.wallpapers.ui.adapter.wallpaper.AdapterPresenter
import com.artto.wallpapers.ui.adapter.wallpaper.ItemView
import com.artto.wallpapers.ui.base.BasePresenter
import com.artto.wallpapers.utils.with
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import ua.corteva.data.network.api.WallpaperApiConstants
import ua.corteva.data.network.response.HitsItem

@InjectViewState
class WallpapersPresenter(private val interact: WallpapersInteract) : BasePresenter<WallpapersView>(),
    AdapterPresenter {

    private val items = arrayListOf<HitsItem>()

    private var category = ""
    private val perPage = WallpaperApiConstants.ITEMS_PER_PAGE

    private var nextPage = 1
    private var hasNextPage = true
    private var isLoading = false

    fun onCreate(categoryName: String?) {
        categoryName?.let {
            category = categoryName
            loadWallpapers()
        } ?: viewState.navigateUp()
    }

    fun loadWallpapers() {
        if (!isLoading && hasNextPage)
            interact.getWallpapersByCategory("$nextPage", "$perPage", category)
                .with(AndroidSchedulers.mainThread(), Schedulers.io())
                .doOnSubscribe { isLoading = true }
                .doOnEvent { _, _ -> isLoading = false }
                .doOnSuccess {
                    hasNextPage = it.totalHits - items.size >= perPage
                    if (hasNextPage) nextPage++
                }
                .subscribeBy(
                    onSuccess = { updateItems(it.hits) },
                    onError = { it.printStackTrace() }
                )
                .addTo(disposables)
    }

    private fun updateItems(new: List<HitsItem>) {
        val position = items.size
        items.addAll(new)
        viewState.notifyItemRangeInserted(position, new.size)
    }

    override fun onBindViewHolder(view: ItemView, position: Int) =
        view.setData(items[position].webformatURL) {}

    override fun getItemCount() = items.size

}