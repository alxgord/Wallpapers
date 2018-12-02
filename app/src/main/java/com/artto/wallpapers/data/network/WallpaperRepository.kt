package com.artto.wallpapers.data.network

import com.artto.wallpapers.data.network.api.WallpaperApi
import com.artto.wallpapers.data.network.request.WallpaperRequest
import com.artto.wallpapers.data.network.request.parameter.ApiKeyParameter
import com.artto.wallpapers.data.network.request.parameter.OrderParameter
import com.artto.wallpapers.data.network.request.parameter.PageParameter
import com.artto.wallpapers.data.network.request.parameter.PerPageParameter
import com.artto.wallpapers.data.network.response.WallpaperResponse
import io.reactivex.Single

class WallpaperRepository(private val api: WallpaperApi) {

    fun getPopular(page: String, perPage: String): Single<WallpaperResponse> = api.getWallpapers(
        WallpaperRequest(
            listOf(
                ApiKeyParameter(),
                OrderParameter(OrderParameter.POPULAR),
                PerPageParameter(perPage),
                PageParameter(page)
            )
        )
    )

}