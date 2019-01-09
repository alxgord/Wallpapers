package ua.corteva.data.network

import ua.corteva.data.network.api.WallpaperApi
import ua.corteva.data.network.request.WallpaperRequest
import ua.corteva.data.network.request.parameter.ApiKeyParameter
import ua.corteva.data.network.request.parameter.OrderParameter
import ua.corteva.data.network.request.parameter.PageParameter
import ua.corteva.data.network.request.parameter.PerPageParameter
import ua.corteva.data.network.response.WallpaperResponse
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