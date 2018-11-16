package com.artto.wallpapers.data.network.api

import com.artto.wallpapers.data.network.request.WallpaperRequest

class WallpaperApi(private val apiMethods: WallpaperApiMethods) {

    fun getWallpapers(request: WallpaperRequest) = apiMethods.getWallpapers(request.getParametersMap())

}