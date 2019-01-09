package ua.corteva.data.network.api

import ua.corteva.data.network.response.WallpaperResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WallpaperApiMethods {

    @GET("api/")
    fun getWallpapers(@QueryMap parameters: Map<String, String>): Single<WallpaperResponse>

}