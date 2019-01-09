package ua.corteva.data.network.request.parameter

import ua.corteva.data.network.api.WallpaperApiConstants

class ApiKeyParameter(override val value: String = WallpaperApiConstants.API_KEY, override val key: String = "key") :
    BaseWallpaperRequestParameter