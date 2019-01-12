package com.artto.wallpapers.ui.wallpapers

import ua.corteva.data.network.WallpaperRepository
import ua.corteva.data.network.request.WallpaperRequest
import ua.corteva.data.network.request.parameter.*

class WallpapersInteract(private val wallpaperRepository: WallpaperRepository) {

    fun getWallpapersByCategory(page: String, perPage: String, category: String) =
        wallpaperRepository.getWallpapers(
            WallpaperRequest(
                listOf(
                    ApiKeyParameter(),
                    PageParameter(page),
                    PerPageParameter(perPage),
                    CategoryParameter(category),
                    OrderParameter(OrderParameter.POPULAR)
                )
            )
        )

}