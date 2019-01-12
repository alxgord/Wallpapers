package ua.corteva.data.network.request.parameter

import ua.corteva.data.network.api.WallpaperApiConstants

class PerPageParameter(
    override val value: String = "${WallpaperApiConstants.ITEMS_PER_PAGE}",
    override val key: String = "per_page"
) :
    BaseWallpaperRequestParameter