package com.artto.wallpapers.data.network.request.parameter

import com.artto.wallpapers.data.network.api.WallpaperApiConstants

class ApiKeyParameter(override val value: String = WallpaperApiConstants.API_KEY, override val key: String = "key") :
    BaseWallpaperRequestParameter