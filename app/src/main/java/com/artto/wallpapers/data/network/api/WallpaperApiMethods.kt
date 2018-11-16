package com.artto.wallpapers.data.network.api

import com.artto.wallpapers.data.network.response.WallpaperResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WallpaperApiMethods {

    @GET
    fun getWallpapers(@QueryMap parameters: Map<String, String>): Single<WallpaperResponse>

}