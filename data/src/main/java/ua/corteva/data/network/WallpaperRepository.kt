package ua.corteva.data.network

import io.reactivex.Single
import ua.corteva.data.network.api.WallpaperApi
import ua.corteva.data.network.request.WallpaperRequest
import ua.corteva.data.network.response.WallpaperResponse

class WallpaperRepository(private val api: WallpaperApi) {

    fun getWallpapers(request: WallpaperRequest): Single<WallpaperResponse> = api.getWallpapers(request)

}