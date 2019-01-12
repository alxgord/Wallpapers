package com.artto.wallpapers.ui.categories

import com.arellomobile.mvp.InjectViewState
import com.artto.wallpapers.ui.base.BasePresenter
import com.artto.wallpapers.ui.adapter.wallpaper.AdapterPresenter
import com.artto.wallpapers.ui.adapter.wallpaper.ItemView
import com.artto.wallpapers.utils.with
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import ua.corteva.data.network.request.parameter.CategoryParameter
import ua.corteva.data.network.response.HitsItem

@InjectViewState
class CategoriesPresenter(private val interact: CategoriesInteract) : BasePresenter<CategoriesView>(),
    AdapterPresenter {

    private val items = ArrayList<Pair<String, HitsItem>>()

    override fun onFirstViewAttach() {
        loadCategories()
    }

    private fun loadCategories() {
        interact.getCategoriesPreviews(CategoryParameter.categories)
            .with(AndroidSchedulers.mainThread(), Schedulers.io())
            .doOnSubscribe { viewState.showProgressBar(true) }
            .doOnEvent { _, _ -> viewState.showProgressBar(false) }
            .subscribeBy(
                onSuccess = { list -> list.forEach { updateItems(it) } },
                onError = { it.printStackTrace() })
            .addTo(disposables)
    }

    private fun updateItems(new: Pair<String, HitsItem>) {
        val position = items.size
        items.add(new)
        viewState.notifyItemRangeInserted(position, 1)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(view: ItemView, position: Int) =
        view.setData(items[position].second.webformatURL, items[position].first) {
            viewState.navigateToCategory(items[position].first)
        }
}