package com.artto.wallpapers.data.network.request

import com.artto.wallpapers.data.network.request.parameter.BaseWallpaperRequestParameter

class WallpaperRequest(private val parameters: List<BaseWallpaperRequestParameter>) {

    fun getParametersMap(): Map<String, String> = parameters.map { it.key to it.value }.toMap()

}