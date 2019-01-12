package com.artto.wallpapers.ui.categories

import io.reactivex.Single
import io.reactivex.rxkotlin.toObservable
import ua.corteva.data.network.WallpaperRepository
import ua.corteva.data.network.request.WallpaperRequest
import ua.corteva.data.network.request.parameter.*
import ua.corteva.data.network.response.HitsItem

class CategoriesInteract(private val wallpaperRepository: WallpaperRepository) {

    fun getCategoriesPreviews(categories: List<String>): Single<List<Pair<String, HitsItem>>> = categories
        .toObservable()
        .flatMapSingle { category ->
            getWallpapersByCategory("1", "3", category)
                .map { Pair(category, it.hits[0]) }
        }.toList()

    private fun getWallpapersByCategory(page: String, perPage: String, category: String) =
        wallpaperRepository.getWallpapers(
            WallpaperRequest(
                listOf(
                    ApiKeyParameter(),
                    PageParameter(page),
                    PerPageParameter(perPage),
                    CategoryParameter(category),
                    OrientationParameter(OrientationParameter.VERTICAL),
                    OrderParameter(OrderParameter.POPULAR)
                )
            )
        )

}