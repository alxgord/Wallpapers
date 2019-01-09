package ua.corteva.data.network.api

import ua.corteva.data.network.request.WallpaperRequest

class WallpaperApi(private val apiMethods: WallpaperApiMethods) {

    fun getWallpapers(request: WallpaperRequest) = apiMethods.getWallpapers(request.getParametersMap())

}