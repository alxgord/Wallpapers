package ua.corteva.data.network.request.parameter

class OrderParameter(override val value: String = POPULAR, override val key: String = "order") : BaseWallpaperRequestParameter {

    companion object {
        const val POPULAR = "popular"
        const val LATEST = "latest"
    }

}