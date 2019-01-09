package ua.corteva.data.network.request

import ua.corteva.data.network.request.parameter.BaseWallpaperRequestParameter

class WallpaperRequest(private val parameters: List<BaseWallpaperRequestParameter>) {

    fun getParametersMap(): Map<String, String> = parameters.map { it.key to it.value }.toMap()

}