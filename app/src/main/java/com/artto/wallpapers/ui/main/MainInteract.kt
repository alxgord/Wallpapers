package com.artto.wallpapers.ui.main

import ua.corteva.data.network.WallpaperRepository
import ua.corteva.data.network.response.WallpaperResponse
import io.reactivex.Single

class MainInteract(private val wallpaperRepository: WallpaperRepository) {

    fun getPopularWallpapers(page: String = "1", perPage: String = "20"): Single<WallpaperResponse> =
        wallpaperRepository.getPopular(page, perPage)

}