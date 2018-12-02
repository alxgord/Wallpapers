package com.artto.wallpapers.features.main

import com.artto.wallpapers.data.network.WallpaperRepository
import com.artto.wallpapers.data.network.response.WallpaperResponse
import io.reactivex.Single

class MainInteract(private val wallpaperRepository: WallpaperRepository) {

    fun getPopularWallpapers(page: String = "1", perPage: String = "20"): Single<WallpaperResponse> =
        wallpaperRepository.getPopular(page, perPage)

}