package com.artto.wallpapers.features.main

import com.artto.wallpapers.data.network.WallpaperRepository
import com.artto.wallpapers.data.network.response.WallpaperResponse
import io.reactivex.Single

class MainInteract(private val wallpaperRepository: WallpaperRepository) {

    fun getPopularWallpapers(): Single<WallpaperResponse> = wallpaperRepository.getPopular()

}